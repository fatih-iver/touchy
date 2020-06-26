package fun.observe.touchy;


import android.content.Context;

class Touchy {

    static void start() {
        WindowManagerGlobalInfiltrator.infiltrate();
    }

}
