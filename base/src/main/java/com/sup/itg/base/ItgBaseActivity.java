package com.sup.itg.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class ItgBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        createBefore();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        addClick();
    }


    /**
     * {@inheritDoc}
     */
    public void createBefore() {

    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    /**
     * {@inheritDoc}
     */
    public void addClick() {
    }
}
