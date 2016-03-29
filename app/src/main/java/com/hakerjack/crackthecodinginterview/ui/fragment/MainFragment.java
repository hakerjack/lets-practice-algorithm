package com.hakerjack.crackthecodinginterview.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hakerjack.crackthecodinginterview.R;
import com.hakerjack.crackthecodinginterview.data.Problem;
import com.hakerjack.crackthecodinginterview.util.SharedPrefsUtil;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;
import java.util.Random;

/**
 * Created by kjia on 3/27/16.
 */
public class MainFragment extends Fragment {
    private TextView mTitle;
    private TextView mInitialText;
    private Button mNextRandomButton;

    private Problem mProblem;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mTitle = (TextView) rootView.findViewById(R.id.problem_title);
        mInitialText = (TextView) rootView.findViewById(R.id.initial_text);

        mNextRandomButton = (Button) rootView.findViewById(R.id.next_random_btn);
        mNextRandomButton.setOnClickListener(v -> {
            getRandomProblem();
        });

        Log.i("KJ", "mainfragment oncreateview");
        loadLastProblem();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mProblem != null) {
            Prefs.putLong(SharedPrefsUtil.PREFS_KEY_LAST_VIEW_PROBLEM_ID, mProblem.getId());
        }

        super.onSaveInstanceState(outState);
    }

    private void loadLastProblem() {
        long problemId = Prefs.getLong(SharedPrefsUtil.PREFS_KEY_LAST_VIEW_PROBLEM_ID, -1);
        Log.i("KJ", "problem id:" + problemId);
        if (problemId == -1) {
            // no problem was loaded before. show an initial screen
            displayInitialScreen();
        } else {
            mProblem = Problem.findById(Problem.class, problemId);
            if (mProblem == null) {
                displayInitialScreen();
            } else {
                displayProblem();
            }

        }
    }

    private void displayProblem() {
        if (mProblem != null) {
            if (mInitialText.getVisibility() == View.VISIBLE) {
                mInitialText.setVisibility(View.GONE);
            }

            mTitle.setText(mProblem.getTitle());
        }
    }

    private void displayInitialScreen() {
        mInitialText.setVisibility(View.VISIBLE);
    }

    private void getRandomProblem() {
        int minVisited = Prefs.getInt(SharedPrefsUtil.PREFS_KEY_MINIMUM_VISITED_TIME, 0);
        String whereArgs = "" + minVisited;
        List<Problem> problems = Problem.findWithQuery(Problem.class, "Select * from problem");
        Random r = new Random();
        int index = r.nextInt(problems.size());

        mProblem = problems.get(index);
        mProblem.incrementVisitedTime();
        mProblem.save();

        displayProblem();
    }
}
