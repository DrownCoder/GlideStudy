package com.study.glidestudy.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Uses a combination of a PageTransformer and swapping X & Y coordinates
 * of touch events to create the illusion of a vertically scrolling ViewPager.
 * <p>
 * Requires API 11+
 */
public class VerticalViewPager extends ViewPager {
    private Context context;

    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        // The majority of the magic happens here
        setPageTransformer(false, new VerticalPageTransformer());
        // The easiest way to get rid of the overscroll drawing that happens on the left and right
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class VerticalPageTransformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            if (position <= 0) {
                view.setAlpha(1);
                view.setTranslationY((float) (-view.getHeight() * (1 - Math.pow(0.9f, -position))));
                //设置缩放中点
                view.setPivotX(view.getWidth() / 2f);
                view.setPivotY(view.getHeight() / 2f);
                //设置缩放的比例 此处设置两个相邻的卡片的缩放比率为0.9f
                float Scale = (float) Math.pow(0.9f, -position);
                if (Scale > 0.7f) {
                    view.setScaleX(Scale);
                    view.setScaleY(Scale);
                } else {
                    view.setAlpha(0);
                }
            } else {//(0,++)
                view.setPivotY(view.getHeight());
                setCameraDistance(view);
                view.setRotationX(180 * -position);
                view.setAlpha(1 - position);
            }
            view.setTranslationX(view.getWidth() * -position);

        }
    }

    /**
     * 改变视角距离, 贴近屏幕
     */
    private void setCameraDistance(View view) {
        int distance = 10000;
        float scale = getResources().getDisplayMetrics().density * distance;
        view.setCameraDistance(scale);
    }

    /**
     * Swaps the X and Y coordinates of your touch event.
     */
    private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;

        ev.setLocation(newX, newY);

        return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev); // return touch coordinates to original reference frame for any child views
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }

}