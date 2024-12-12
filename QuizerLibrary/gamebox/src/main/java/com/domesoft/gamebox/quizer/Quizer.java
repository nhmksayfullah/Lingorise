package com.domesoft.gamebox.quizer;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.domesoft.gamebox.SpannableStringBuilderKt;
import com.domesoft.gamebox.interfaces.SetOnFailureListener;
import com.domesoft.gamebox.interfaces.SetOnFinishedListener;
import com.domesoft.gamebox.interfaces.SetOnSuccessListener;
import com.domesoft.gamebox.interfaces.SetOnTimeUpListener;
import java.util.List;


public class Quizer {

    /** The Main class of Quizer Library.
     *
     */

    private final Context context;
    private List<Quiz> quizList;

    // variable for primary element
    private TextView tvQuestion, tvOption1, tvOption2, tvOption3, tvOption4;
    private Button btnOption1, btnOption2, btnOption3, btnOption4;


    // variable for set question
    private int currentIndex = 0; private int totalQuestion; private int questionCount = 1;



    //variable for progressBar
    private ProgressBar progressBar; private boolean progressbarSet = false;
    private int progress = 10; private int minusProgress = 0; private int finalProgress = 0; private int addProgress;

    // variable for score set
    private TextView tvScore; private boolean tvScoreSet = false;



    // variable for Listener
    private SetOnSuccessListener onSuccessListener;
    private SetOnFailureListener onFailureListener;
    private SetOnFinishedListener onFinishedListener;
    private SetOnTimeUpListener onTimeUpListener;

    // variable for click events
    private boolean successClicked = false; private boolean failureClicked = false;
    private boolean finishedClicked = false; private boolean timeUpSet = false;
    private boolean quizFinished = false;


    // variable for spanning word
    private boolean isSpanned = false; private String spanColor; private int spanStart;

    // variable for set timer
    private CountDownTimer timer; private boolean isTimerPerOneSet = false; private boolean isTimerForAllSet; private TextView tvTimer; private int timeCount;





    /**
     *
     * @param context is need to initialize the Quizer Constructor
     */
    public Quizer(Context context) {
        this.context = context;
    }





    /**
     *
     * @param quizList this list
     * @return a list of Quiz made by user. This is a mandatory method for Quizer library.
     */
    public Quizer setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
        return this;
    }

    /**
     * It takes the current question set and
     * @return the question set again after randomize its options.
     */
    public Quizer setOptionRandomly(){
        this.quizList = RandomizeQuizKt.randomizeQuiz(quizList);
        return this;
    }

    /**
     * @param tvQuestion is
     * @param tvOption1 is
     * @param tvOption2 is
     * @param tvOption3 is
     * @param tvOption4 is
     * @return the primary element of Quiz. This is a mandatory method for Quizer library.
     */
    public Quizer setPrimaryElement(TextView tvQuestion, TextView tvOption1, TextView tvOption2, TextView tvOption3, TextView tvOption4) {

        this.tvQuestion = tvQuestion;
        this.tvOption1 = tvOption1;
        this.tvOption2 = tvOption2;
        this.tvOption3 = tvOption3;
        this.tvOption4 = tvOption4;
        return this;
    }

    /**
     *Alternative of the method above.
     */
    public Quizer setPrimaryElement(TextView tvQuestion, Button btnOption1, Button btnOption2, Button btnOption3, Button btnOption4) {

        this.tvQuestion = tvQuestion;
        this.btnOption1 = btnOption1;
        this.btnOption2 = btnOption2;
        this.btnOption3 = btnOption3;
        this.btnOption4 = btnOption4;
        return this;
    }


    /**
     * @param progressBar is
     * @return this method is used to set a progressBar for Quiz.
     * This is an optional Method.
     */
    public Quizer setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
        progressbarSet = true;
        return this;
    }

    /**
     * @param addForCorrectAnswer i
     * @param cutForWrongAnswer i
     * @return calculate custom score for every correct and wrong answer.
     */
    public Quizer setScore(int addForCorrectAnswer, int cutForWrongAnswer){

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
    public Quizer setScore(int addForCorrectAnswer, int cutForWrongAnswer, TextView tvScore){

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
    public Quizer setOnSuccessListener(SetOnSuccessListener onSuccessListener){
        this.onSuccessListener = onSuccessListener;
        successClicked = true;
        return this;
    }

    /**
     * @param onFailureListener is
     * @return user can call this method if they want to do something when the answer will be correct.
     */
    public Quizer setOnFailureListener(SetOnFailureListener onFailureListener){
        this.onFailureListener = onFailureListener;
        failureClicked = true;
        return this;
    }

    /**
     * @param onFinishedListener is
     * @return user can call this method if they want to do something when all quiz will be finished.
     */
    public Quizer setOnFinishedListener(SetOnFinishedListener onFinishedListener){
        this.onFinishedListener = onFinishedListener;
        finishedClicked = true;
        return this;
    }

    /**
     * @param onTimeUpListener is
     * @return user can call this method if they want to do something when time is up.
     */
    public Quizer setOnTimeUpListener(SetOnTimeUpListener onTimeUpListener){
        this.onTimeUpListener = onTimeUpListener;
        timeUpSet = true;
        return this;
    }


    /**
     * @param tvTimer is
     * @param second is
     * @return set countDownTimer for individual question.
     */
    public Quizer setTimerPerQuestion(TextView tvTimer, int second){
        this.tvTimer = tvTimer;
        this.timeCount = second;
        isTimerPerOneSet = true;
        return this;
    }

    /**
     * @param tvTimer is
     * @param second is
     * @return set countDownTimer for all question.
     */
    public Quizer setTimerForAllQuestion(TextView tvTimer, int second){
        this.tvTimer = tvTimer;
        this.timeCount = second;
        isTimerForAllSet = true;

        return this;
    }


    /**
     * This method is the final touch of Quizer library.
     * When everything is done, call the method to start playing your awesome Quiz Game.
     */
    public void create() {

        setQuiz(currentIndex);
        totalQuestion = quizList.size();
        this.addProgress = (int) Math.ceil(100.0/totalQuestion);
//        this.cutProgress = (int) Math.ceil(100/totalQuestion);


        if (tvOption1!=null && tvOption2!=null && tvOption3!=null && tvOption4!=null){
            setOnClick(tvOption1);
            setOnClick(tvOption2);
            setOnClick(tvOption3);
            setOnClick(tvOption4);
        }
        if (btnOption1!=null && btnOption2!=null && btnOption3!=null && btnOption4!=null){
            setOnClick(btnOption1);
            setOnClick(btnOption2);
            setOnClick(btnOption3);
            setOnClick(btnOption4);
        }

        if (isTimerPerOneSet){
            resetTimer(tvTimer, timeCount);
        }
        if (isTimerForAllSet){
            resetTimer(tvTimer, timeCount);
        }



    }


    /**
     * @param color is
     * @param startSpan is
     * @return custom style for the word you want to.
     */
    public Quizer setSpannable(String color, int startSpan){
        isSpanned = true;
        spanColor = color;
        spanStart = startSpan;
        return this;
    }


    /**
     * @param currentIndex is stands for witch question is running now.
     *                     this method is used to get and set current Quiz content
     *                     from Quiz List to Quiz Element.
     */
    private void setQuiz(int currentIndex) {
        String currentQuestion = quizList.get(currentIndex).getQuestion();
        String currentOption1 = quizList.get(currentIndex).getOption1();
        String currentOption2 = quizList.get(currentIndex).getOption2();
        String currentOption3 = quizList.get(currentIndex).getOption3();
        String currentOption4 = quizList.get(currentIndex).getOption4();

        if (isSpanned){
            tvQuestion.setText(SpannableStringBuilderKt.buildSpan(currentQuestion,spanStart,spanColor));
        } else {
            tvQuestion.setText(currentQuestion);
        }

        if (tvOption1 != null && tvOption2 != null && tvOption3 != null && tvOption4 != null) {
            tvOption1.setText(currentOption1);
            tvOption2.setText(currentOption2);
            tvOption3.setText(currentOption3);
            tvOption4.setText(currentOption4);
        }
        if (btnOption1 != null && btnOption2 != null && btnOption3 != null && btnOption4 != null) {
            btnOption1.setText(currentOption1);
            btnOption2.setText(currentOption2);
            btnOption3.setText(currentOption3);
            btnOption4.setText(currentOption4);
        }
    }

    /**
     * @param tvOption is the option witch is clicked by user.
     *                 this method is used to get the input from user clicked option.
     *                 and put the data to @method checkAnswer to check the user input
     *                 is true or false.
     */
    private void setOnClick(TextView tvOption) {


            tvOption.setOnClickListener(v -> {
                if (!quizFinished){
                    checkAnswer(String.valueOf(tvOption.getText()));
                }
            });


    }
    private void setOnClick(Button btnOption) {

        btnOption.setOnClickListener(v -> {
            if (!quizFinished){
                checkAnswer(String.valueOf(btnOption.getText()));
            }
        });
    }

    /**
     * @param userSelection
     * this method is used to check the user selection is true or false.
     * if true it redirect to successListener
     * else it redirect to failureListener
     */
    private void checkAnswer(String userSelection) {

        String currentAnswer = quizList.get(currentIndex).getAnswer();

            if (userSelection.equals(currentAnswer)) {

                if (isTimerPerOneSet){
                    if (timer !=null){
                        timer.cancel();
                    }
                }

                questionCount = questionCount+1;
                finalProgress = finalProgress + progress;
                if (successClicked){
                    onSuccessListener.onSuccess(currentIndex);
                } else Toast.makeText(context, "Correct Answer", Toast.LENGTH_SHORT).show();
                updateQuestion();

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
            currentIndex = (currentIndex + 1) % quizList.size();
            setQuiz(currentIndex);
        }

        if (progressbarSet){
            updateProgressBar();
        }

        if (tvScoreSet){
            setScoreTextView(finalProgress);
        }

        if (isTimerPerOneSet){
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

            if (tvOption1!=null && tvOption2!=null && tvOption3!=null && tvOption4!=null) {
                tvOption1.setVisibility(View.INVISIBLE);
                tvOption2.setVisibility(View.INVISIBLE);
                tvOption3.setVisibility(View.INVISIBLE);
                tvOption4.setVisibility(View.INVISIBLE);
            }
            if (btnOption1!=null && btnOption2!=null && btnOption3!=null && btnOption4!=null) {
                btnOption1.setVisibility(View.INVISIBLE);
                btnOption2.setVisibility(View.INVISIBLE);
                btnOption3.setVisibility(View.INVISIBLE);
                btnOption4.setVisibility(View.INVISIBLE);
            }
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
        CountDownTimer timer = new CountDownTimer(second* 1000L,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {

                if (finishedClicked){
                    onFinishedListener.onFinished(finalProgress);
                } else {
                    if (timeUpSet){
                        onTimeUpListener.timeUp(finalProgress);
                    } else {
                        Toast.makeText(context, "Times up", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
        timer.start();
    }





}
