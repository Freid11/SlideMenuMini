package porter.medsafe.com.menuformedsafedoctor;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MySlidingPane extends SlidingPaneLayout {

    public static boolean SIDE_LEFT = true;
    public static boolean SIDE_RIGHT = false;
    private boolean mSide = SIDE_LEFT;
    private float mFirstTouch;
    private int mMargin = 150;
    private int mWidth ;

    public MySlidingPane(Context context) {
        super(context);
    }

    public MySlidingPane(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySlidingPane(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!this.isOpen()) {
            mWidth = MainActivity.width;
            if (ev.getAction() == MotionEvent.ACTION_DOWN) mFirstTouch = ev.getX();
            if (mSide) {
                if (mFirstTouch < mMargin) return super.onTouchEvent(ev);
                else return false;
            } else {
                if (mFirstTouch > (mWidth - mMargin)) return super.onTouchEvent(ev);
                else return false;
            }
        }
        else return false;
    }

    public void setSide(boolean side) {
        mSide = side;
    }
}
