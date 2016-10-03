package com.jayplabs.fibonaccicommon;

import android.os.Parcel;
import android.os.Parcelable;


public class FibonacciResponse implements Parcelable {

    private final long result;

    private final long timeInMills;

    public FibonacciResponse(long result, long timeInMills) {
        this.result = result;
        this.timeInMills = timeInMills;
    }

    public long getResult() {
        return result;
    }

    public long getTimeInMills() {
        return timeInMills;
    }

    public static final Creator<FibonacciResponse> CREATOR = new Creator<FibonacciResponse>() {
        @Override
        public FibonacciResponse createFromParcel(Parcel in) {

            return new FibonacciResponse(in.readLong(), in.readLong());
        }

        @Override
        public FibonacciResponse[] newArray(int size) {
            return new FibonacciResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.result);
        parcel.writeLong(this.timeInMills);
    }
}
