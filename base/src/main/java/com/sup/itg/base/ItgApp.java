package com.sup.itg.base;

import android.app.Application;

public class ItgApp extends Application {
    private static ItgApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }


    public static ItgApp getApp() {
        return app;
    }
}
