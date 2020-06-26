package fun.observe.touchy;

import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;

import java.lang.reflect.Field;


class DecorViewInfiltrator {

    private static Class classDecorView;
    private static Class classPopupDecorView;

    static {
        try {
            classDecorView = Class.forName("com.android.internal.policy.DecorView");
            classPopupDecorView = Class.forName("android.widget.PopupWindow$PopupDecorView");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void useWindowCallbackWrapper(Object decorViewObject) throws NoSuchFieldException, IllegalAccessException {

        Field mWindowField = classDecorView.getDeclaredField("mWindow");

        mWindowField.setAccessible(true);

        Window mWindowObject = (Window) mWindowField.get(decorViewObject);

        Window.Callback callback = mWindowObject.getCallback();

        Window.Callback windowCallbackWrapper = new WindowCallbackWrapper(callback);

        mWindowObject.setCallback(windowCallbackWrapper);

    }

    private static void useTouchListenerWrapper(Object decorViewObject) throws NoSuchFieldException, IllegalAccessException {

        Field this$0Field = classPopupDecorView.getDeclaredField("this$0");

        this$0Field.setAccessible(true);

        Object popupWindowObject = this$0Field.get(decorViewObject);

        Class classPopupWindow = PopupWindow.class;

        Field mTouchInterceptorField = classPopupWindow.getDeclaredField("mTouchInterceptor");

        mTouchInterceptorField.setAccessible(true);

        View.OnTouchListener mTouchInterceptorObject = (View.OnTouchListener) mTouchInterceptorField.get(popupWindowObject);

        View.OnTouchListener onTouchListenerWrapper = new OnTouchListenerWrapper(mTouchInterceptorObject);

        mTouchInterceptorField.set(popupWindowObject, onTouchListenerWrapper);

    }

    static void infiltrateFor(Object objectDecorView) {

        try {

            if (classDecorView.isInstance(objectDecorView)) {

                useWindowCallbackWrapper(objectDecorView);

            } else if (classPopupDecorView.isInstance(objectDecorView)) {

                useTouchListenerWrapper(objectDecorView);

            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}
