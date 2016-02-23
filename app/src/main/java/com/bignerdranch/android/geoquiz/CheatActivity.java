package com.bignerdranch.android.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";
    private static final String KEY_ANSWER = "com.bignerdranch.android.geoquiz.key_answer";
    private static final String KEY_SHOWN = "com.bignerdranch.android.geoquiz.key_shown";
    private static final String EXTRA_ANSWER = "com.bignerdranch.android.geoquiz.extra_answer";

    private boolean mAnswerIsTrue;

    private boolean mKeepCheat;
    private boolean mQuestionAns;

    private TextView mAnswerTextView;
    private Button mShowAnswer;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            int cx = mShowAnswer.getWidth()/2;
            int cy = mShowAnswer.getHeight()/2;
            float radius = mShowAnswer.getWidth();
            Animator anim = viewAnimationUnits.createCircularReveal(mShowAnswer,cx,cy,radius,0);
            anim.addListener(new AnimatorListenerAdapter(){
            }
        })

            //@Override
            //protected void outState(Bundle onSaveInstanceState) {
                //super.outState(onSaveInstanceState);
                //outState.putBoolean(KEY_ANSWER, mKeepCheat);
                //outState.putBoolean(KEY_ANSWER, mQuestionAns);
            //}
        //});

        //mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        //mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        //mShowAnswer = (Button) findViewById(R.id.show_answer_button);
        //mShowAnswer.setOnClickListener(new View.OnClickListener() {

            //@Override
            //public void onClick(View v) {
                //mAnswerTextView.setText((mQuestionAns == true) ? R.string.True : R.string.False);
                //mKeepCheat = true;
                //setKeepCheat(mKeepCheat);
                //if (mAnswerIsTrue) {
                  //  mAnswerTextView.setText(R.string.true_button);
                //} else {
                    //mAnswerTextView.setText(R.string.false_button);
                //}
                //setAnswerShownResult(true);
            //}
        //});

        //if (savedInstanceState != null) {
           // mKeepCheat = savedInstanceState.getBoolean(KEY_SHOWN, false);
            //mQuestionAns = savedInstanceState.getBoolean(KEY_ANSWER, false);
          //  if (mKeepCheat) {
            //    mAnswerTextView.setText((mQuestionAns == true) ? R.string.cheat_button);
            //}
        //}
        //else {
          //  mQuestionAns = getIntent().getBooleanExtra(EXTRA_ANSWER, false);
        //}
    //}

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    }