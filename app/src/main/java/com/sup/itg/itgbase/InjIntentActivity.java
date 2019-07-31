package com.sup.itg.itgbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sup.itg.base.ItgL;
import com.sup.itg.base.an.intent.InjIntent;
import com.sup.itg.base.an.intent.IntentKey;

import java.util.List;
//https://www.jianshu.com/p/aeb93a3d33d1?from=timeline
//https://www.cnblogs.com/cfas/p/11186701.html
public class InjIntentActivity extends AppCompatActivity {

    @IntentKey(value = "name")
    private String name;
    @IntentKey(value = "time")
    private int time;
    @IntentKey(value = "array")
    private String array[];
    @IntentKey(value = "listArray")
    private List<String> intentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inj_intent);
        InjIntent.injIntentUtil(this);
        ItgL.e(name + "  " + time);
        if (array != null) {
            for (String s : array) {
                ItgL.e(s);
            }
        }

        for (String s : intentList) {
            ItgL.e(s);
        }
    }
}
