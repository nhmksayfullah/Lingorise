package com.doombox.vocabuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.doombox.vocabuilder.Fragments.AccountFragment;
import com.doombox.vocabuilder.Fragments.CourseFragment;
import com.doombox.vocabuilder.Fragments.FeedFragment;
import com.doombox.vocabuilder.Fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    /** *************************declare all variables****************/
    BottomNavigationView bottomNav;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* *************************call every methods****************/
        typeCast();



        // TODO

        FragmentTransaction homeTransaction = getSupportFragmentManager().beginTransaction();
        homeTransaction.replace(R.id.fragmentContainerId, new HomeFragment());
        homeTransaction.commit();

        bottomNav.setOnNavigationItemSelectedListener(item -> {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            switch (item.getItemId()) {

                case R.id.homeId:
                    transaction.replace(R.id.fragmentContainerId, new HomeFragment());
                    break;

                case R.id.feedId:
                    transaction.replace(R.id.fragmentContainerId, new FeedFragment());
                    break;

                case R.id.courseId:
                    transaction.replace(R.id.fragmentContainerId, new CourseFragment());
                    break;

                case R.id.accountId:
                    transaction.replace(R.id.fragmentContainerId, new AccountFragment());
                    break;
            }
            transaction.commit();
            return true;
        });


    }

    void typeCast(){
        bottomNav = this.findViewById(R.id.bottomNavId);


    }

}