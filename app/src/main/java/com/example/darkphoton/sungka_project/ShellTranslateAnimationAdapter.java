package com.example.darkphoton.sungka_project;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import game.Cup;

/**
 * Created by darkphoton on 25/10/15.
 */
public class ShellTranslateAnimationAdapter implements Animation.AnimationListener {
    private CupButton _btn;
    private View _v;
    private float _x;
    private float _y;

    public ShellTranslateAnimationAdapter(CupButton btn, View v, float x, float y){
        _btn = btn;
        _v = v;
        _x = x;
        _y = y;
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
        animation.setDuration(1);
        _v.startAnimation(animation);

        _v.setX(_x);
        _v.setY(_y);

        _btn.updateText();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
