package com.jayplabs.fibonacciservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class FibonacciService extends Service {

    private static final String TAG = FibonacciService.class.getCanonicalName();

    private IFibonacciServiceImpl mService;

    @Override
    public void onCreate() {
        super.onCreate();
        mService = new IFibonacciServiceImpl();
        Log.d(TAG, "onCreate()'ed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()'ed");
        return mService;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind()'ed");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()'ed");
        mService = null;
        super.onDestroy();
    }
}
