package fun.observe.touchy.app;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import fun.observe.touchy.MotionEventBroadcaster;
import fun.observe.touchy.MotionEventReceiver;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();


    static {
        MotionEventBroadcaster.registerReceiver(new MotionEventReceiver() {
            @Override
            protected void onReceive(MotionEvent motionEvent) {
                Log.d(TAG, motionEvent.toString());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(fun.observe.touchy.app.R.layout.activity_main);

        MotionEventBroadcaster.registerReceiver(this, new MotionEventReceiver() {
            @Override
            protected void onReceive(MotionEvent motionEvent) {
                Log.d(TAG, motionEvent.toString());
            }
        });

    }

}
