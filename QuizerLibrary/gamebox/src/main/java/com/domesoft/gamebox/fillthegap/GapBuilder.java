package com.domesoft.gamebox.fillthegap;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.domesoft.gamebox.interfaces.SetOnFailureListener;
import com.domesoft.gamebox.interfaces.SetOnFinishedListener;
import com.domesoft.gamebox.interfaces.SetOnSuccessListener;
import com.domesoft.gamebox.interfaces.SetOnTimeUpListener;

import java.util.List;

public class GapBuilder {

    private final Context context;
    private List<FillData> questionList;

    // variable for primary element
    private TextView tvQuestion; private EditText etUserInput; private Button btnCheckAnswer;


    // variable for progressBar
    private ProgressBar progressBar; private boolean progressbarSet = false;
    private int progress = 10; private int minusProgress = 0; private int finalProgress = 0; private int addProgress;

    // variable for score set
    private TextView tvScore; private boolean tvScoreSet = false;


    private int currentIndex = 0; private int totalQuestion; private int questionCount = 1;
    private String currentAnswer;



    // variable for Listener
    private SetOnSuccessListener onSuccessListener;
    private SetOnFailureListener onFailureListener;
    private SetOnFinishedListener onFinishedListener;
    private SetOnTimeUpListener onTimeUpListener;

    // variable for click events
    private boolean successClicked = false; private boolean failureClicked = false;
    private boolean finishedClicked = false; private boolean timeUpSet = false;
    private boolean quizFinished = false;

    // variable for set timer
    private CountDownTimer timer; private boolean isTimer1Set = false; private boolean isTimerSetAll;
    private TextView tvTimer; private int timeCount;


    /**
     * @param context is need to initialize the GapBuilder library
     */
    public GapBuilder(Context context) {
        this.context = context;
    }


    /**
     * @param questionSet this list
     * @return a list of question made by user. This is a mandatory method for Quizer library.
     */
    public GapBuilder setQuestion(List<FillData> questionSet){
        this.questionList = questionSet;
        return this;
    }

    /**
     * @param questionTxt is
     * @param userInputEditTxt is
     * @param checkAnswerBtn is
     * @return the primary element of Quiz. This is a mandatory method for Quizer library.
     */
    public GapBuilder setPrimaryElement(TextView questionTxt,EditText userInputEditTxt,Button checkAnswerBtn){
        this.tvQuestion = questionTxt;
        this.etUserInput = userInputEditTxt;
        this.btnCheckAnswer = checkAnswerBtn;
        return this;
    }


    /**
     * @param progressBar is
     * @return this method is used to set a progressBar for Quiz.
     * This is an optional Method.
     */
    public GapBuilder setProgressBar(ProgressBar progressBar){
        progressbarSet = true;
        this.progressBar = progressBar;
        return this;
    }

    /**
     * @param addForCorrectAnswer i
     * @param cutForWrongAnswer i
     * @return calculate custom score for every correct and wrong answer.
     */
    public GapBuilder setScore(int addForCorrectAnswer, int cutForWrongAnswer){
        this.progress = addForCorrectAnswer;
        this.minusProgress = cutForWrongAnswer;
        return this;
    }

    /**
     * @param addForCorrectAnswer i
     * @param cutForWrongAnswer i
     * @param tvScore i
     * @return calculate custom score for every correct and wrong answer and set score in a textView.
     */
    public GapBuilder setScore(int addForCorrectAnswer, int cutForWrongAnswer, TextView tvScore){
        this.progress = addForCorrectAnswer;
        this.minusProgress = cutForWrongAnswer;
        this.tvScore = tvScore;
        tvScore.setText("0");
        tvScoreSet = true;
        return this;
    }

    /**
     * @param onSuccessListener is
     * @return user can call this method if they want to do something when the answer will be correct.
     */
    public GapBuilder setOnSuccessListener(SetOnSuccessListener onSuccessListener){
        this.onSuccessListener = onSuccessListener;
        successClicked = true;
        return this;
    }

    /**
     * @param onFailureListener is
     * @return user can call this method if they want to do something when the answer will be correct.
     */
    public GapBuilder setOnFailureListener(SetOnFailureListener onFailureListener){
        this.onFailureListener = onFailureListener;
        failureClicked = true;
        return this;
    }

    /**
     * @param onFinishedListener is
     * @return user can call this method if they want to do something when all quiz will be finished.
     */
    public GapBuilder setOnFinishedListener(SetOnFinishedListener onFinishedListener){
        this.onFinishedListener = onFinishedListener;
        finishedClicked = true;
        return this;
    }

    /**
     * @param onTimeUpListener is
     * @return user can call this method if they want to do something when time up.
     */
    public GapBuilder setOnTimeUpListener(SetOnTimeUpListener onTimeUpListener){
        this.onTimeUpListener = onTimeUpListener;
        timeUpSet = true;
        return this;
    }


    /**
     * @param tvTimer is
     * @param second is
     * @return set countDownTimer for individual question.
     */
    public GapBuilder setTimerPerQuestion(TextView tvTimer, int second){
      this.tvTimer = tvTimer;
      this.timeCount = second;
      isTimer1Set = true;
      return this;
    }

    /**
     * @param tvTimer is
     * @param second is
     * @return set countDownTimer for all question.
     */
    public GapBuilder setTimerForAllQuestion(TextView tvTimer, int second){
        this.tvTimer = tvTimer;
        this.timeCount = second;
        isTimerSetAll = true;
        return this;
    }


    /**
     * This method is the final touch of Quizer library.
     * When everything is done, call the method to start playing your awesome Quiz Game.
     */
    public void create(){

        if (questionList!=null){
            totalQuestion = questionList.size();
            this.addProgress = (int) Math.ceil(100.0/totalQuestion);
            createQuestion();
        }

        if (isTimer1Set){
            resetTimer(tvTimer, timeCount);
        }
        if (isTimerSetAll){
            resetTimer(tvTimer, timeCount);
        }


        if (btnCheckAnswer !=null){
            onClick();
        }
    }

    /**
     * this method is used to get and set current Quiz content
     * from Quiz List to Quiz Element.
     */
    private void createQuestion(){

        String questionLower = questionList.get(currentIndex).getQuestion().toLowerCase();
        currentAnswer = questionList.get(currentIndex).getAnswer().toLowerCase();

        if (questionLower.contains(currentAnswer)){
            String question = questionLower.replace(currentAnswer,ReplaceStringKt.replaceString(currentAnswer,"_"));
            String firstChar = String.valueOf(question.charAt(0)) ;
            String currentQuestion = question.replace(firstChar, firstChar.toUpperCase());
            tvQuestion.setText(currentQuestion);
        }

    }

    /**
     * this method is call when user click on check button.
     */
    private void onClick(){
        btnCheckAnswer.setOnClickListener(v -> {

            if (!quizFinished){
                String userInput = etUserInput.getText().toString();
                checkAnswer(userInput.toLowerCase());
            }
        });
    }

    /**
     * @param userInput
     * this method is used to check the user selection is true or false.
     * if true it redirect to successListener
     * else it redirect to failureListener
     */
    private void checkAnswer(String userInput) {

        if (userInput.equals(currentAnswer)){
            questionCount = questionCount+1;
            finalProgress = finalProgress + progress;
            if (isTimer1Set){
                if (timer !=null){
                    timer.cancel();
                }
            }

            if (successClicked){
                onSuccessListener.onSuccess(currentIndex);
            } else Toast.makeText(context, "Correct Answer", Toast.LENGTH_SHORT).show();


            etUserInput.setText("",TextView.BufferType.EDITABLE);
            updateQuestion();

            progressBar.incrementProgressBy(progress);
            String finalProgress = String.valueOf( progressBar.getProgress());

            if (finalProgress.equals("100")){
                Toast.makeText(context, "Finished", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (minusProgress>0){
                finalProgress = finalProgress - minusProgress;
                if (tvScoreSet){
                    setScoreTextView(finalProgress);
                }
            }
            if (failureClicked){
                onFailureListener.onFailure(currentIndex);
            } else Toast.makeText(context, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * This method is used to update the Quiz and set next Question to user.
     */
    private void updateQuestion() {

        if (questionCount > totalQuestion){
            finishQuiz();
        } else {
            currentIndex = (currentIndex+1)%questionList.size();
            createQuestion();
        }

        if (progressbarSet){
            updateProgressBar();
        }

        if (tvScoreSet){
            setScoreTextView(finalProgress);
        }

        if (isTimer1Set){
            if (timer != null){
                timer.cancel();
            }
            resetTimer(tvTimer,timeCount);
        }


    }

    /**
     * @param score is
     * this method is used to set score in tvScore
     */
    private void setScoreTextView(int score){
        this.tvScore.setText(String.valueOf(score));
    }

    /**
     * This method is call when need to finish the Quiz.
     */
    private void finishQuiz() {
        this.quizFinished = true;

        if (finishedClicked){
            onFinishedListener.onFinished(finalProgress);
        } else {
            tvQuestion.setVisibility(View.INVISIBLE);
            etUserInput.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * This method is used to update the value of progressBar if available.
     */
    private void updateProgressBar() {

        progressBar.incrementProgressBy(addProgress);

        if (questionCount>totalQuestion){
            progressBar.setProgress(100);
        }
    }


    /**
     * @param tvTimer is
     * @param second is
     * reset the timer after change the question.
     */
    private void resetTimer(TextView tvTimer, int second){
        timer = new CountDownTimer(second* 1000L,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                if (timeUpSet){
                    onTimeUpListener.timeUp(finalProgress);
                } else {
                    Toast.makeText(context, "Times up", Toast.LENGTH_SHORT).show();
                }
            }
        };
        timer.start();
    }

}
