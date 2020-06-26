package fun.observe.touchy;

import android.view.MotionEvent;
import android.view.View;


class OnTouchListenerWrapper implements View.OnTouchListener {

    private View.OnTouchListener onTouchListener;

    OnTouchListenerWrapper(View.OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        MotionEventBroadcaster.broadcast(event);
        if (onTouchListener != null) {
            return onTouchListener.onTouch(v, event);
        }
        return false;
    }
}
