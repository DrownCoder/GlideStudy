package com.study.glidestudy.acitivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.glidestudy.R;
import com.study.glidestudy.adapter.HorizonAdapter;
import com.study.glidestudy.util.DensityUtils;
import com.study.glidestudy.view.VerticalViewPager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private VerticalViewPager mViewPager;
    private String[] mImgSource = new String[]{
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091912314&di=043ca0ff0cdf5bfce360f287be22a538&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D3686266434%2C1600710035%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=666ba858a654baa53d060f063ad65b9f&imgtype=0&src=http%3A%2F%2Fwww.benbenla.cn%2Fimages%2F20130107%2Fbenbenla-09c.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=7cccb906d6fa0d26776896c1c7d1f7eb&imgtype=0&src=http%3A%2F%2Fwww.benbenla.cn%2Fimages%2F20110910%2Fbenbenla-06c.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=04960dad8aa3b028c531a51ba3f47afc&imgtype=0&src=http%3A%2F%2Fimg.wallpaperlist.com%2Fuploads%2Fwallpaper%2Ffiles%2Fora%2Forange-lake-shore-in-sunset-wallpaper-1366x768-5346ca4997dfa.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091912314&di=043ca0ff0cdf5bfce360f287be22a538&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D3686266434%2C1600710035%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=666ba858a654baa53d060f063ad65b9f&imgtype=0&src=http%3A%2F%2Fwww.benbenla.cn%2Fimages%2F20130107%2Fbenbenla-09c.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=7cccb906d6fa0d26776896c1c7d1f7eb&imgtype=0&src=http%3A%2F%2Fwww.benbenla.cn%2Fimages%2F20110910%2Fbenbenla-06c.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=04960dad8aa3b028c531a51ba3f47afc&imgtype=0&src=http%3A%2F%2Fimg.wallpaperlist.com%2Fuploads%2Fwallpaper%2Ffiles%2Fora%2Forange-lake-shore-in-sunset-wallpaper-1366x768-5346ca4997dfa.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091912314&di=043ca0ff0cdf5bfce360f287be22a538&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D3686266434%2C1600710035%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=666ba858a654baa53d060f063ad65b9f&imgtype=0&src=http%3A%2F%2Fwww.benbenla.cn%2Fimages%2F20130107%2Fbenbenla-09c.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=7cccb906d6fa0d26776896c1c7d1f7eb&imgtype=0&src=http%3A%2F%2Fwww.benbenla.cn%2Fimages%2F20110910%2Fbenbenla-06c.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=04960dad8aa3b028c531a51ba3f47afc&imgtype=0&src=http%3A%2F%2Fimg.wallpaperlist.com%2Fuploads%2Fwallpaper%2Ffiles%2Fora%2Forange-lake-shore-in-sunset-wallpaper-1366x768-5346ca4997dfa.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091912314&di=043ca0ff0cdf5bfce360f287be22a538&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D3686266434%2C1600710035%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=666ba858a654baa53d060f063ad65b9f&imgtype=0&src=http%3A%2F%2Fwww.benbenla.cn%2Fimages%2F20130107%2Fbenbenla-09c.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=7cccb906d6fa0d26776896c1c7d1f7eb&imgtype=0&src=http%3A%2F%2Fwww.benbenla.cn%2Fimages%2F20110910%2Fbenbenla-06c.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490091910387&di=04960dad8aa3b028c531a51ba3f47afc&imgtype=0&src=http%3A%2F%2Fimg.wallpaperlist.com%2Fuploads%2Fwallpaper%2Ffiles%2Fora%2Forange-lake-shore-in-sunset-wallpaper-1366x768-5346ca4997dfa.jpg"
    };
    private HorizonAdapter mAdapter;

    private ImageView mImgClick;
    private ImageView mImgAdd;
    private TextView mTvAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        mAdapter.setmOnImageClikListener(new HorizonAdapter.OnImgClickListener() {
            @Override
            public void onImgClick(View view) {
                mImgClick.setVisibility(View.VISIBLE);
                Animation imgClickAnimation = AnimationUtils.loadAnimation(MainActivity.this
                        , R.anim.collect_click);
                mImgClick.startAnimation(imgClickAnimation);

                Animator bigAnimationX = ObjectAnimator.ofFloat(mImgAdd, "scaleX", 1.0f, 1.3f, 1.0f);
                Animator bigAnimationY = ObjectAnimator.ofFloat(mImgAdd, "scaleY", 1.0f, 1.3f, 1.0f);
                AnimatorSet set = new AnimatorSet();
                set.play(bigAnimationX).with(bigAnimationY);
                set.start();

                Animation tvClickAnimation = AnimationUtils.loadAnimation(MainActivity.this
                        , R.anim.tv_collect_add);
                mTvAdd.setVisibility(View.VISIBLE);
                mTvAdd.startAnimation(tvClickAnimation);

            }
        });
    }

    private void initView() {
        mViewPager = (VerticalViewPager) findViewById(R.id.viewpager);
        mImgClick = (ImageView) findViewById(R.id.iv_collect_click);
        mImgAdd = (ImageView) findViewById(R.id.iv_collect_add);
        mTvAdd = (TextView) findViewById(R.id.tv_collect_add);
    }

    private void initData() {
        List<String> mData = new ArrayList<>();
        Collections.addAll(mData, mImgSource);
        mAdapter = new HorizonAdapter(this, mData, mViewPager);

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setCurrentItem(mImgSource.length);
    }
}
