package com.study.glidestudy.acitivity;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.study.glidestudy.R;
import com.study.glidestudy.view.VerticalViewPager;

import java.util.ArrayList;
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
    private List<ImageView> mImageViews = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initData();

        mViewPager = (VerticalViewPager) findViewById(R.id.viewpager);

        mViewPager.setAdapter(new PagerAdapter()
        {
            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_viewpager,null);
                ImageView img = (ImageView) view.findViewById(R.id.iv_viewpager);
                Glide.with(MainActivity.this)
                        .load(mImgSource[position])
                        .into(img);
                //img.setImageResource(R.mipmap.ic_launcher);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object)
            {

                container.removeView(mImageViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view == object;
            }

            @Override
            public int getCount()
            {
                return mImgSource.length;
            }
        });
        mViewPager.setOffscreenPageLimit(3);
        //mViewPager.setCurrentItem(7);
    }

    private void initData() {
        for (String imgurl : mImgSource) {
            ImageView imageView = new ImageView(this);
            mImageViews.add(imageView);
        }
    }
}
