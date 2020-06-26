package fun.observe.touchy;

import android.util.Log;
import android.view.MotionEvent;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

public class MotionEventBroadcaster {

    private static final String TAG = MotionEventBroadcaster.class.getSimpleName();

    private static MutableLiveData<MotionEvent> motionEventMutableLiveData = new MutableLiveData<>();

    static void broadcast(MotionEvent motionEvent) {
        Log.d(TAG, motionEvent.toString());
        motionEventMutableLiveData.setValue(motionEvent);
    }

    public static void registerReceiver(MotionEventReceiver motionEventReceiver) {
        motionEventMutableLiveData.observeForever(motionEventReceiver);
    }

    public static void registerReceiver(LifecycleOwner owner, MotionEventReceiver motionEventReceiver) {
        motionEventMutableLiveData.observe(owner, motionEventReceiver);
    }

}
