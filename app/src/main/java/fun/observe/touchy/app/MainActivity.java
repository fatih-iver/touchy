package fun.observe.touchy.app;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import fun.observe.touchy.MotionEventBroadcaster;
import fun.observe.touchy.MotionEventReceiver;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private MotionEventReceiver motionEventReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(fun.observe.touchy.app.R.layout.activity_main);

        motionEventReceiver = new MotionEventReceiver() {
            @Override
            protected void onReceive(MotionEvent motionEvent) {
                Log.d(TAG, motionEvent.toString());
            }
        };

        MotionEventBroadcaster.registerReceiver(this, motionEventReceiver);

    }

    @Override
    protected void onDestroy() {
        if(motionEventReceiver != null){
            MotionEventBroadcaster.removeReceiver(motionEventReceiver);
        }
        super.onDestroy();
    }
}
