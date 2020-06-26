package fun.observe.touchy;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;


class WindowManagerGlobalInfiltrator {

    static void infiltrate() {

        try {

            Class classWindowManagerGlobal = Class.forName("android.view.WindowManagerGlobal");

            Field mViewsField = classWindowManagerGlobal.getDeclaredField("mViews");

            ReflectionUtils.makeFieldNonFinal(mViewsField);

            Method getInstanceMethod = classWindowManagerGlobal.getDeclaredMethod("getInstance");

            Object windowManagerGlobalObject = getInstanceMethod.invoke(null);

            List<View> mViews = new AdHocListForInfiltration();

            mViewsField.set(windowManagerGlobalObject, mViews);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
