package dk.stbn.myfirstapp;

import android.app.Application;

public class MySingleton extends Application {

    static MySingleton app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        System.out.println("Android singleton");
    }

}
