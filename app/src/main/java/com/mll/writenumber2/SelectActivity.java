package com.mll.writenumber2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class SelectActivity extends Activity {       //SelectActivity类头部

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //onCreate()方法头部
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        if (MainActivity.isPlay==true){
            PlayMusic();
        }

    }       //onCreate()方法尾部

    //1.播放音乐的方法
    //（1）播放音乐
    private void PlayMusic() {
        mediaPlayer = MediaPlayer.create(this,R.raw.number_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    //（2）停止音乐
    protected void onStop(){
        super.onStop();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
    //（3）清空音乐内存资源
    protected void onDestroy(){
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer =null;
        }
    }
    //（4）放回界面继续播放音乐
    protected void onRestart(){
        super.onRestart();
        if (MainActivity.isPlay==true){
            PlayMusic();
        }
    }

    //跳转数字1界面
    public void OnOne(View v){
        startActivity(new Intent(SelectActivity.this, OneActivity.class));
    }
    //跳转数字2界面
    public void OnTwo(View v){
        startActivity(new Intent(SelectActivity.this, TwoActivity.class));
    }
    //跳转数字3界面
    public void OnThree(View v){
        startActivity(new Intent(SelectActivity.this, ThreeActivity.class));
    }
    //跳转数字4界面
    public void OnFour(View v){
        startActivity(new Intent(SelectActivity.this, FourActivity.class));
    }
    //跳转数字5界面
    public void OnFive(View v){
        startActivity(new Intent(SelectActivity.this, FiveActivity.class));
    }
    //跳转数字6界面
    public void OnSix(View v){
        startActivity(new Intent(SelectActivity.this, SixActivity.class));
    }
    //跳转数字7界面
    public void OnSeven(View v){
        startActivity(new Intent(SelectActivity.this, SevenActivity.class));
    }
    //跳转数字8界面
    public void OnEight(View v){
        startActivity(new Intent(SelectActivity.this, EightActivity.class));
    }
    //跳转数字9界面
    public void OnNine(View v){
        startActivity(new Intent(SelectActivity.this, NineActivity.class));
    }
    //跳转数字9界面
    public void OnZero(View v){
        startActivity(new Intent(SelectActivity.this, ZeroActivity.class));
    }
}       //SelectActivity类尾部
