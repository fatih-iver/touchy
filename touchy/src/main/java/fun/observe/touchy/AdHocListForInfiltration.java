package fun.observe.touchy;

import android.view.View;

import java.util.ArrayList;


class AdHocListForInfiltration extends ArrayList<View> {

    @Override
    public boolean add(View view) {
        DecorViewInfiltrator.infiltrateFor(view);
        return super.add(view);
    }
}
