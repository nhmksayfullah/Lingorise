package com.doombox.vocabuilder.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.doombox.vocabuilder.UserGuideActivity;
import com.doombox.vocabuilder.VocabListActivity;
import com.doombox.vocabuilder.GetVocabActivity;
import com.doombox.vocabuilder.MyDataBaseHelper;
import com.doombox.vocabuilder.R;


public class HomeFragment extends Fragment implements View.OnClickListener {


    View learnButton,learnAboutBtn, toLearnVocabListBtn, learnedVocabListBtn, userGuidBtn;
    TextView toLearnCounterText, learnedCounterText;

    MyDataBaseHelper myDataBaseHelper;
    String toLearnCount, learnedCount;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /* **************** Start your Code from here******************************/



        typCast(view);
        setCounterText();

        learnButton.setOnClickListener(this);
        learnAboutBtn.setOnClickListener(this);
        toLearnVocabListBtn.setOnClickListener(this);
        learnedVocabListBtn.setOnClickListener(this);
        userGuidBtn.setOnClickListener(this);








        /* *******************The End**************************/
        return view;
    }


    /** *******************Type cast every element**************************/
    private void typCast(View view) {


        learnAboutBtn = view.findViewById(R.id.learnAboutThisBtnId);
        toLearnVocabListBtn = view.findViewById(R.id.toLearnVocabListBtnId);
        learnedVocabListBtn = view.findViewById(R.id.learnedVocabListBtnId);
        userGuidBtn = view.findViewById(R.id.userGuideBtnId);
        learnButton = view.findViewById(R.id.learnVocabBtnId);
        toLearnCounterText = view.findViewById(R.id.toLearnVocabCountTxt);
        learnedCounterText = view.findViewById(R.id.learnedVocabCountTxt);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.learnVocabBtnId){

            Intent intent = new Intent(getActivity(), GetVocabActivity.class);
            startActivity(intent);

        }

        else if (v.getId()==R.id.learnAboutThisBtnId){

            Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.toLearnVocabListBtnId){

            Intent intent = new Intent(getActivity(), VocabListActivity.class);
            intent.putExtra("table","1");
            startActivityForResult(intent,1);

//            startActivity(new Intent(getActivity(),ActivityVocabularyList.class));

        }
        else if (v.getId()==R.id.learnedVocabListBtnId){

            Intent intent = new Intent(getActivity(), VocabListActivity.class);
            intent.putExtra("table","2");
            startActivityForResult(intent,1);

        }
        else if (v.getId()==R.id.userGuideBtnId){

            Intent intent = new Intent(getActivity(), UserGuideActivity.class);
            startActivity(intent);

        }

    }

    public void setCounterText(){


        myDataBaseHelper = new MyDataBaseHelper(getActivity());
        int counterToLearn = myDataBaseHelper.getCountToLearn();
        toLearnCount = String.valueOf(counterToLearn);
        toLearnCounterText.setText(toLearnCount);

        int counterLearned = myDataBaseHelper.getCountLearned();
        learnedCount = String.valueOf(counterLearned);
        learnedCounterText.setText(learnedCount);

//        myDataBaseHelper.close();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String value = null;
        if (data != null) {
            value = data.getStringExtra("key");
        }
        if (value != null && value.equals("1")) {

            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction().detach(HomeFragment.this).attach(HomeFragment.this).commit();
            }

        }

    }




}