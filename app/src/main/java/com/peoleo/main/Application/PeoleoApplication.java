package com.peoleo.main.Application;

import android.app.Application;
import android.content.Context;

/**
 * Created by hu on 14-11-4.
 */
public class PeoleoApplication extends Application {
    private static Context context;

    public void onCreate(){
        super.onCreate();
        PeoleoApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return PeoleoApplication.context;
    }
}
