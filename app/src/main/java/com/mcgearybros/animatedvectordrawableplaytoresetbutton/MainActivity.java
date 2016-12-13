package com.mcgearybros.animatedvectordrawableplaytoresetbutton;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private AnimatedVectorDrawableCompat playToResetAnim;
    private AnimatedVectorDrawableCompat resetToPlayAnim;
    private boolean isShowingPlay = true;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        playToResetAnim = AnimatedVectorDrawableCompat.create(this, R.drawable.fab_play_to_reset_animated_vector);
        resetToPlayAnim = AnimatedVectorDrawableCompat.create(this, R.drawable.fab_reset_to_play_animated_vector);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setImageDrawable(playToResetAnim);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonIcon();
            }
        });


        AppCompatImageView bv= (AppCompatImageView) findViewById(R.id.butterfly_view);
        AnimatedVectorDrawableCompat drawable = (AnimatedVectorDrawableCompat) bv.getDrawable();

        drawable.start();
    }

    private void changeButtonIcon(){
        AnimatedVectorDrawableCompat currentDrawable = isShowingPlay ? playToResetAnim : resetToPlayAnim;
        floatingActionButton.setImageDrawable(currentDrawable);
        currentDrawable.start();
        isShowingPlay = !isShowingPlay;
    }

}
