package edu.gsu.httpscs.rogueproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpscs.rogueproject.fragment.BlueFragment;
import edu.gsu.httpscs.rogueproject.util.UtilLog;

//activity_gesture_activity
public class GestureActivity extends BaseActivity implements View.OnTouchListener {


    @BindView(R.id.activity_gesture_tv)
    TextView tv;

    private GestureDetector gestureDectector;
    private int sumX = 0;
    private int sumY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        ButterKnife.bind(this);

        gestureDectector = new GestureDetector(this, new GestureActivity.simpleGestureLister());
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);

        if (sumX>200){
            sumX=0;
        }
        if (sumY>200){
            sumY=0;
        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event){
        return gestureDectector.onTouchEvent(event);
    }
    private class simpleGestureLister extends
            GestureDetector.SimpleOnGestureListener{
        /*******onDOwn-> onShowPress->onLongPress*********/
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapUp");
            return super.onSingleTapUp(e);
        }
        @Override
        public void onLongPress(MotionEvent e) {
            UtilLog.d("Gesture","onLongPress");
            super.onLongPress(e);
        }
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.d("Gesture","onScroll");
            UtilLog.d("Gesture","distanceX:"+distanceX);
            UtilLog.d("Gesture","distanceY:"+distanceY);
            sumX+=distanceX;
            sumY+=distanceY;

            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            UtilLog.d("Gesture","onFling");
            if(sumX<0){
                if(Math.abs(sumX)>200){
                    shortToast("You scroll from Left to Right");
                    gotoActivity(SubRotSingleTargetActivity.class);
                }
            }
            if(sumX>0){
                if(Math.abs(sumX)>200){
                    shortToast("You scroll from Right to Left");
                    gotoActivity(SubRotMultipeTargetActivity.class);
                }
            }
            if(sumY<0){
                if(Math.abs(sumY)>200){
                    shortToast("You scroll from Top to Bottom");
                }
            }
            if(sumY>0){
                if(Math.abs(sumY)>200){
                    shortToast("You scroll from Bottom to Top");
                    gotoActivity(SubRotDeathFromAboveActivity.class);
                }
            }
            if (sumX>200){
                sumX=0;
            }
            if (sumY>200){
                sumY=0;
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
        @Override
        public void onShowPress(MotionEvent e) {
            UtilLog.d("Gesture","onShowPress");
            super.onShowPress(e);
        }
        @Override
        public boolean onDown(MotionEvent e) {
            UtilLog.d("Gesture","onDown");
            return super.onDown(e);
        }
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTap");
            return super.onDoubleTap(e);
        }
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTapEvent");
            return super.onDoubleTapEvent(e);
        }
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapConfirmed");
            return super.onSingleTapConfirmed(e);
        }
    }

}
