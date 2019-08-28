package com.mll.writenumber2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {            //MainActivity类头部

    static boolean isPlay=true;
    MediaPlayer mediaPlayer;
    Button music_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {      //onCreate()方法头部
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music_btn = (Button) findViewById(R.id.btn_music);
        PlayMusic();

    }       //onCreate()方法尾部

    //1.音乐
    //(1)播放背景音乐方法
    private void PlayMusic() {
        mediaPlayer=MediaPlayer.create(this,R.raw.main_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    //(2)音乐按钮点击事件
    public void OnMusic(View v){
        if (isPlay==true){
            if (mediaPlayer != null){
                mediaPlayer.stop();
                music_btn.setBackgroundResource(R.drawable.btn_music2);
                isPlay=false;
            }
        }else {
            PlayMusic();
            music_btn.setBackgroundResource(R.drawable.btn_music1);
            isPlay=true;
        }
    }
    //(3)游戏主界面停止时，背景音乐停止
    protected void Onstop(){
        super.onStop();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
    //(4)清空内存资源
    protected void onDestroy(){
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    //(5)返回主界面自动播放音乐
    protected void onRestart(){
        super.onRestart();
        if (isPlay == true){
            PlayMusic();
        }
    }

    //2.跳转游戏界面
    public void OnPlay(View v){
        startActivity(new Intent(MainActivity.this,SelectActivity.class));
    }

    //3.跳转关于我们界面
    public void OnAbout(View v){
        startActivity(new Intent(MainActivity.this,AboutActivity.class));
    }

}       //MainActivity类尾部
