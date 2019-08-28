package util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mll.writenumber2.R;

public class mCustomProgressDialog extends ProgressDialog {

    private AnimationDrawable mAnimation;
    private Context mContext;
    private ImageView mImageView;
    private String mLoadingTip;
    private TextView mLoadingTv;
    private int mResid;


    //自定义对话框构造方法头部
    public mCustomProgressDialog(Context context,String content,int id) {
        super(context);
        this.mContext=context;
        this.mLoadingTip=content;
        this.mResid=id;
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);

        //获取布局文件、显示动画相关控件
        mLoadingTv = (TextView)findViewById(R.id.loadingTv);
        mImageView = (ImageView) findViewById(R.id.loadingIv);
        if (mResid == 0){
            mImageView.setBackgroundDrawable(null);
        }else {
            mImageView.setBackgroundResource(mResid);
        }
        mAnimation = (AnimationDrawable) mImageView.getBackground();
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();
            }
        });
        mLoadingTv.setText(mLoadingTip);
    }
}
