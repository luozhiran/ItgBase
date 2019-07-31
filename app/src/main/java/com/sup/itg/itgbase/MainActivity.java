package com.sup.itg.itgbase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.sup.itg.base.ItgHandlerActivity;
import com.sup.itg.base.an.intent.IntentKey;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ItgHandlerActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InjIntentActivity.class);
                intent.putExtra("name", "luozhiran");
                intent.putExtra("time", 13454);
                intent.putExtra("array", new String[]{"1","2","3"});
                ArrayList<String> list= new ArrayList<>();
                list.add("33");
                list.add("fasdf");
                list.add("f342432");
                intent.putStringArrayListExtra("listArray",list);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void handleMessage(Message msg) {

    }
}
