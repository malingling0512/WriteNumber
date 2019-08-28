package com.mll.writenumber2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import util.mCustomProgressDialog;


public class OneActivity extends Activity {      //OnActivity类头部

    public mCustomProgressDialog mdialog;
    MediaPlayer mediaPlayer;

    private ImageView iv_frame;
    int i=1;
    float x1;
    float y1;
    float x2;
    float y2;
    float x3;
    float y3;
    int igvx;
    int igvy;
    int type=0;

    int widthPixels;
    int heightPixels;

    float scaleWidth;
    float scaleHeight;

    Timer touchTimer = null;
    Bitmap arrdown;
    boolean typedialog = true;
    private LinearLayout linearLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {   //onCreate()方法头部
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        if (MainActivity.isPlay==true){
            PlayMusic();  //播放音乐
        }

        initView();

        //判断手势按下的坐标位置来判断是否可以进行书写
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x1=event.getX();    //手指按下的X坐标
                        y1=event.getY();    //手指按下的Y坐标
                        igvx=iv_frame.getLeft();    //手指按下图片的X坐标
                        igvy=iv_frame.getTop();     //手指按下图片的Y坐标
                        if (x1>=igvx && x1<=igvx+(int)(arrdown.getWidth()*scaleWidth)
                            && y1>=igvy && y1<=igvy+(int)(arrdown.getWidth()*scaleWidth)){
                            type=1;         //开启书写
                        }else {
                            type=0;     //关闭书写
                        }break;
                    case MotionEvent.ACTION_MOVE:
                        igvx=iv_frame.getLeft();    //手指按下图片的X坐标
                        igvy=iv_frame.getTop();     //手指按下图片的Y坐标
                        x2 = event.getX();      //手指移动中的X坐标的位置
                        y2 = event.getY();      //手指移动中的Y坐标的位置
                        if (type==1){
                            if (x2>igvx && x2<=igvx+(int)(arrdown.getWidth()*scaleWidth)){
                                if (y2<=igvy +(int)(arrdown.getHeight()*scaleHeight)/24 && y2>= igvy){
                                    lodimagep(1);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*2){
                                    lodimagep(2);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*3){
                                    lodimagep(3);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*4){
                                    lodimagep(4);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*5){
                                    lodimagep(5);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*6){
                                    lodimagep(6);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*7){
                                    lodimagep(7);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*8){
                                    lodimagep(8);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*9){
                                    lodimagep(9);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*10){
                                    lodimagep(10);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*11){
                                    lodimagep(11);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*12){
                                    lodimagep(12);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*13){
                                    lodimagep(13);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*14){
                                    lodimagep(14);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*15){
                                    lodimagep(15);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*16){
                                    lodimagep(16);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*17){
                                    lodimagep(17);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*18){
                                    lodimagep(18);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*19){
                                    lodimagep(19);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*20){
                                    lodimagep(20);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*21){
                                    lodimagep(21);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*22){
                                    lodimagep(22);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*23){
                                    lodimagep(23);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight)/24*24){
                                    lodimagep(24);
                                }else {
                                    type=0;
                                }
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        type=0;
                        if (touchTimer != null){
                            touchTimer.cancel();
                            touchTimer=null;
                        }
                        touchTimer=new Timer();   //初始化计时器
                        touchTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Thread thread=new Thread(new Runnable() {            //创建一个新线程
                                    @Override
                                    public void run() {
                                        Message message=new Message();
                                        message.what = 2;
                                        mHandle.sendMessage(message);
                                    }
                                });
                                thread.start();          //开新线程
                            }
                        },300,200);
                }
                return true;
            }
        });
    }       //onCreate()方法尾部

    public void OnYS(View v){
        if (mdialog == null){
            mdialog=new mCustomProgressDialog(this,"演示中点击边缘取消演示动画",R.drawable.frame1);
        }
        mdialog.show();
    }

    //获取布局文件中相关控件
    private void initView() {       //initView()方法头部
        iv_frame = (ImageView) findViewById(R.id.iv_frame);
        linearLayout = (LinearLayout) findViewById(R.id.LinearLayout1);
        LinearLayout write_layout = (LinearLayout) findViewById(R.id.LinearLayout_number);

        write_layout.setBackgroundResource(R.drawable.bg1);

        widthPixels = this.getResources().getDisplayMetrics().widthPixels;
        heightPixels = this.getResources().getDisplayMetrics().heightPixels;

        scaleWidth = ((float)widthPixels /720) ;
        scaleHeight = ((float)heightPixels/1280);
        try{
            InputStream is = getResources().getAssets().open("on1_1.png");
            arrdown = BitmapFactory.decodeStream(is);
        }catch (IOException e){
            e.printStackTrace();
        }
        //获取屏幕宽高信息
        LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams) iv_frame.getLayoutParams();
        layoutParams.width = (int)(arrdown.getWidth()*scaleHeight);
        layoutParams.height = (int)(arrdown.getHeight()*scaleHeight);

        iv_frame.setLayoutParams(layoutParams);
        lodimagep(1);
    }       //initView()方法尾部

    //递减显示帧图片的handler消息头部
    public Handler mHandle=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 2:
                    jlodimage();
                    break;
                    default:
                        break;
            }
            super.handleMessage(msg);
        }
    };

    //手姿抬起时，数字资源图片倒退显示
    private void jlodimage(){
        if (i==25){
        }else if (i<25){
            if (i>1){
                i--;
            }else if (i==1){
                i=1;
                if (touchTimer!=null){
                    touchTimer.cancel();
                    touchTimer=null;
                }
            }
            String name="on1_"+1;
            int imgid=getResources().getIdentifier(name,"drawable","com.mll.writenumber2");
            iv_frame.setBackgroundResource(imgid);
        }
    }



    //手姿移动时加载不同图片
    private synchronized void lodimagep(int j) {   //lodimagep()方法头部
        i=j;
        if (i<25){
            String name = "on1_"+i;
            int imgid = getResources().getIdentifier(name,"drawable","com.mll.writenumber2"); //获取图片资源id
            iv_frame.setBackgroundResource(imgid);      //设置图片
            i++;
        }
        if (j==24){
            if (typedialog){
                dialog();
            }
        }
    }       //lodimagep()方法尾部

    //实现对话框
    private void dialog() {     //dialog()方法头部
        typedialog = false;
        //实例化对话框dialog
        AlertDialog.Builder builder=new AlertDialog.Builder(OneActivity.this);
        builder.setMessage("太棒了！书写完成！");
        builder.setTitle("提示");
        builder.setPositiveButton("完  成", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
               typedialog = true;
               finish();
           }
       });
        builder.setNegativeButton("再来一次", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                typedialog = true;
                i=1;
                lodimagep(i);
            }
        });
        builder.create().show();
    }       //dialog()方法尾部

    //播放数字儿歌
    private void PlayMusic(){       //播放音乐
        mediaPlayer=MediaPlayer.create(this,R.raw.music1);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    protected void onStop(){        //停止音乐
        super.onStop();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
    protected void onDestroy(){         //释放资源
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }


}       //OnActivity类尾部
