package com.sup.itg.base;


import android.os.Bundle;
import android.os.Message;

import androidx.annotation.Nullable;

public abstract class ItgHandlerActivity extends ItgBaseActivity {

    protected ItgHandler mItgHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mItgHandler = new ItgHandler(this);
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        mItgHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public abstract void handleMessage(Message msg);
}
