package fun.observe.touchy;

import android.view.MotionEvent;

import androidx.lifecycle.Observer;

public abstract class MotionEventReceiver implements Observer<MotionEvent> {

    @Override
    public final void onChanged(MotionEvent motionEvent) {
        onReceive(motionEvent);
    }

    protected abstract void onReceive(MotionEvent motionEvent);

}
