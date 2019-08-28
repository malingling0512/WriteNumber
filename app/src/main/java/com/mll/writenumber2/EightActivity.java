package com.mll.writenumber2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import util.mCustomProgressDialog;

public class EightActivity extends Activity {

    //3. 动画是对象
    public mCustomProgressDialog mdialog;

    //2. 手姿事件
    //（1）定义全局对象及变量
    private ImageView iv_frame;     //定义显示写数字的ImageView控件
    int i=1;        //图片展示到第几张
    float x1;       //屏幕按下时的X值
    float x2;       //屏幕离开时的X值
    float x3;       //移动中的坐标的X值
    float y1;
    float y2;
    float y3;

    int igvx;       //图片x坐标
    int igvy;       //图片y坐标

    int type=0;     //是否可书写标识

    int widthPixels;        //屏幕宽度
    int heightPixels;       //屏幕高度

    float scaleWidth;       //宽度的缩放比例
    float scaleHeight;      //高度的缩放比例
    Timer touchTimer = null;        //点击虚拟按钮上用于连续动作的计时器
    Bitmap arrdown;         //Bitmap图像处理
    boolean typedialog = true;      //dialog对话框状态
    private LinearLayout linearLayout = null;       //linearLayout线性布局


    //1.定义音乐相关
    MediaPlayer mediaPlayer;
    //（1）播放音乐
    private void PlayMusic(){
        mediaPlayer = MediaPlayer.create(this,R.raw.music8);
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
    //（3）释放内存
    protected void onDestroy(){
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        if (MainActivity.isPlay==true){
            PlayMusic();        //播放音乐
        }
        initView();         //调用设置屏幕显示


        //（5） 添加书写区域的触摸事件
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:       //手势按下时
                        x1 = event.getX();
                        y1 = event.getY();
                        igvx = iv_frame.getLeft();
                        igvy = iv_frame.getTop();
                        if (x1>=igvx&&x1<=igvx+(int)(arrdown.getWidth()*scaleWidth)  &&  y1>=igvy&y1<=igvy+(int)(arrdown.getWidth()*scaleWidth)){
                            type=1;
                        }else {
                            type=0;
                        }
                        break;

                    case MotionEvent.ACTION_MOVE:       //手势移动时
                        x2 = event.getX();
                        y2 = event.getY();
                        igvx = iv_frame.getLeft();
                        igvy = iv_frame.getTop();
                        if (type==1){
                            if (x2 >= igvx && x2<=igvx+(int)(arrdown.getWidth()*scaleWidth)){
                                if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24 && y2 >= igvy){
                                    lodimagep(1);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*2){
                                    lodimagep(2);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*3){
                                    lodimagep(3);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*4){
                                    lodimagep(4);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*5){
                                    lodimagep(5);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*6){
                                    lodimagep(6);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*7){
                                    lodimagep(7);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*8){
                                    lodimagep(8);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*9){
                                    lodimagep(9);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*10){
                                    lodimagep(10);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*11){
                                    lodimagep(11);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*12){
                                    lodimagep(12);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*13){
                                    lodimagep(13);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*14){
                                    lodimagep(14);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*15){
                                    lodimagep(15);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*16){
                                    lodimagep(16);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*17){
                                    lodimagep(17);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*18){
                                    lodimagep(18);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*19){
                                    lodimagep(19);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*20){
                                    lodimagep(20);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*21){
                                    lodimagep(21);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*22){
                                    lodimagep(22);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*23){
                                    lodimagep(23);
                                }else if (y2<=igvy+(int)(arrdown.getHeight() * scaleHeight) / 24*24){
                                    lodimagep(24);
                                }
                            }
                        }
                        break;

                    case MotionEvent.ACTION_UP:         //手势抬起时
                        type=0;
                        if (touchTimer!=null){
                            touchTimer.cancel();
                            touchTimer=null;
                        }
                        touchTimer = new Timer();       // 初始化计时器
                        touchTimer.schedule(new TimerTask() {       //开启时间计时器
                            @Override
                            public void run() {
                                Thread thread = new Thread(new Runnable() {     //创建子线程
                                    @Override
                                    public void run() {
                                        Message message = new Message();
                                        message.what=2;
                                        mHandler.sendMessage(message);         // 发送消息给handler实现倒退显示图片
                                    }
                                });
                                thread.start();
                            }
                        },300,200);         //// 设置0.3秒后执行定时器，定时器每0.2秒发送一次
                }
                return true;
            }
        });
    }

    //（2）获取布局文件中相关控件，设置屏幕显示
    private void initView() {       //initView()方法头部
        iv_frame = (ImageView)findViewById(R.id.iv_frame);      //写数字的ImageView组件
        linearLayout =(LinearLayout)findViewById(R.id.LinearLayout1);        //书写区域布局（里面的）
        LinearLayout write_layout=(LinearLayout)findViewById(R.id.LinearLayout_number);     //书写界面(外面的)

        write_layout.setBackgroundResource(R.drawable.bg8);     //设置书写界面背景
        widthPixels=this.getResources().getDisplayMetrics().widthPixels;        //屏幕宽度
        heightPixels=this.getResources().getDisplayMetrics().heightPixels;      //屏幕高度
        scaleWidth=((float)widthPixels/720);        //宽度缩放比例
        scaleHeight=((float)heightPixels/1280);     //高度缩放比例
        try{
            InputStream is = getResources().getAssets().open("on8_1.png");      //打开第一张图片
            arrdown = BitmapFactory.decodeStream(is);       //并进行解析
        }catch (IOException e){
            e.printStackTrace();
        }

        LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams) iv_frame.getLayoutParams();
        layoutParams.width = (int)(arrdown.getWidth()*scaleHeight);     //获取图片缩放后宽度
        layoutParams.height = (int)(arrdown.getHeight()*scaleHeight);   //获取图片缩放后高度
        iv_frame.setLayoutParams(layoutParams);     //设置iv_frame的宽高
        lodimagep(1);       //进入页面后加载第一个图
    }       //initView()方法尾部

    //（3）设置书写区域递增流程图
    private synchronized void lodimagep(int j) {   //lodimagep()方法头部
        i=j;
        if (i<25){
            String name = "on8_"+i;          //设置背景图序号递增显示
            int imgid = getResources().getIdentifier(name,"drawable","com.mll.writenumber2"); //获取图片资源id
            iv_frame.setBackgroundResource(imgid);      //设置图片
            i++;
        }
        if (j==24){
            if (typedialog){
                dialog();        //书写完成时，调用对话框，提示书写完成是否再来一次
            }
        }
    }       //lodimagep()方法尾部

    //(4)创建对话框
    protected void dialog(){
        typedialog = false;
        AlertDialog.Builder builder=new AlertDialog.Builder(EightActivity.this);
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
    }

    //（6）用于接收手姿抬起时，子线程中传递得消息
    public Handler mHandler=new Handler(){
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

    //（7）设置书写区域递减流程图
    private void jlodimage(){
        if (i==25){
        }else if (i<25){
            if (i>1){
                i--;
            }else if (i==1){
                i=1;
                if (touchTimer !=null){
                    touchTimer.cancel();
                    touchTimer=null;
                }
            }
            String name="on8_"+i;
            int imgid=getResources().getIdentifier(name,"drawable","com.mll.writenumber2");
            iv_frame.setBackgroundResource(imgid);
        }
    }

    //3.(1)显示动画
    public void OnYS(View v){
        if (mdialog == null){
            mdialog=new mCustomProgressDialog(this,"演示中点击边缘取消演示动画",R.drawable.frame8);
        }
        mdialog.show();
    }

}
