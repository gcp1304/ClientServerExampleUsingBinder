package com.jayplabs.fibonacciservice;

import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

import com.jayplabs.fibonaccicommon.FibonacciRequest;
import com.jayplabs.fibonaccicommon.FibonacciResponse;
import com.jayplabs.fibonaccicommon.IFibonacciService;
import com.jayplabs.fibonaccinative.FibLib;


public class IFibonacciServiceImpl extends IFibonacciService.Stub {

    private static final String TAG = IFibonacciService.class.getCanonicalName();

    @Override
    public long fibJR(long n) throws RemoteException {
        Log.d(TAG, String.format("fibJR(%d)", n));
        return FibLib.fibJR(n);
    }

    @Override
    public long fibJI(long n) throws RemoteException {
        Log.d(TAG, String.format("fibJI(%d)", n));
        return FibLib.fibJI(n);
    }

    @Override
    public long fibNR(long n) throws RemoteException {
        Log.d(TAG, String.format("fibNR(%d)", n));
        return FibLib.fibNR(n);
    }

    @Override
    public long fibNI(long n) throws RemoteException {
        Log.d(TAG, String.format("fibNI(%d)", n));
        return FibLib.fibNI(n);
    }

    @Override
    public FibonacciResponse fib(FibonacciRequest request) throws RemoteException {
        Log.d(TAG,
                String.format("fib(%d, %s)", request.getN(), request.getType()));

        long timeInMillis = SystemClock.uptimeMillis();
        long result;
        switch (request.getType()) {
            case ITERATIVE_JAVA:
                result = this.fibJI(request.getN());
                break;
            case RECURSIVE_JAVA:
                result = this.fibJR(request.getN());
                break;
            case ITERATIVE_NATIVE:
                result = this.fibNI(request.getN());
                break;
            case RECURSIVE_NATIVE:
                result = this.fibNR(request.getN());
                break;
            default:
                return null;
        }
        timeInMillis = SystemClock.uptimeMillis() - timeInMillis;
        return new FibonacciResponse(result, timeInMillis);
    }
}
