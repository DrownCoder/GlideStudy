package com.study.glidestudy.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Uses a combination of a PageTransformer and swapping X & Y coordinates
 * of touch events to create the illusion of a vertically scrolling ViewPager.
 * <p>
 * Requires API 11+
 */
public class VerticalViewPager extends ViewPager {

    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // The majority of the magic happens here
        setPageTransformer(true, new VerticalPageTransformer());
        // The easiest way to get rid of the overscroll drawing that happens on the left and right
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class VerticalPageTransformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            Log.e("position", String.valueOf(position));
            // Counteract the default slide transition
            view.setTranslationX(view.getWidth() * -position);
            //设置缩放中点
            view.setPivotX(view.getWidth() / 2f);
            view.setPivotY(view.getHeight() / 2f);
            //设置缩放的比例 此处设置两个相邻的卡片的缩放比率为0.9f
            view.setScaleX((float) Math.pow(0.9f, position));
            view.setScaleY((float) Math.pow(0.9f, position));
            //set Y position to swipe in from top
            float yPosition =  -view.getHeight() * position + (view.getHeight() * 0.5f) * (1 - (float) Math.pow(0.9f, position));
            view.setTranslationY(yPosition);
            view.setRotationX(180 * -position);
            /*if (position < -1) { // [-Infinity,-1)
                // This view is way off-screen to the left.
                view.setAlpha(1);
                view.setScaleX(0.8f*(-position));
                view.setScaleY(0.8f*(-position));
                view.setTranslationX(view.getWidth() * -position);

            } else if (position <= 1) { // [-1,1]
                view.setAlpha(1);

                // Counteract the default slide transition
                view.setTranslationX(view.getWidth() * -position);

                //set Y position to swipe in from top
                float yPosition = position * view.getHeight();
                view.setTranslationY(yPosition);

                if (position >= -1 && position < 0) {
                    view.setScaleX(0.8f + 0.2f*(1 + position));
                    view.setScaleY(0.8f + 0.2f*(1 + position));
                }

                if (position > 0) {
                    view.setRotationX(180 * -position);
                    view.setAlpha(1 - position);
                }
            } else { // (1,+Infinity]
                // This view is way off-screen to the right.
                view.setAlpha(1);
            }*/
        }
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