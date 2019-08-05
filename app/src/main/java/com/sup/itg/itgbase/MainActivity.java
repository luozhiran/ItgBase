package com.sup.itg.itgbase;

import android.content.Intent;
import android.os.Message;
import android.view.View;

import com.sup.itg.base.ItgHandlerActivity;

import java.util.ArrayList;

import lzr.bn.ApiAnnotation;


@ApiAnnotation(author = "罗志然",date = "2019",version = 1)
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
