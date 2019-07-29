package com.sup.itg.base;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class ItgHandler extends Handler {

    private WeakReference<ItgHandlerActivity> mWeakA;
    private WeakReference<ItgFragment> mWeakF;

    public ItgHandler(ItgHandlerActivity activity) {
        mWeakA = new WeakReference<>(activity);
    }

    public ItgHandler(ItgFragment fragment) {
        mWeakF = new WeakReference<>(fragment);
    }

    @Override
    public void handleMessage(Message msg) {
        if (mWeakA != null && mWeakA.get() != null) {
            mWeakA.get().handleMessage(msg);
        }

        if (mWeakF != null && mWeakF.get() != null) {
            mWeakF.get().handleMessage(msg);
        }
    }

}
