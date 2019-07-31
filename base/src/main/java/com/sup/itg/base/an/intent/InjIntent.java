package com.sup.itg.base.an.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InjIntent {

    private static void InjValue(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null) return;
        Field[] fields = activity.getClass().getDeclaredFields();
        try {
            Object v = null;
            IntentKey intentKey;
            boolean accessible;
            for (Field fl : fields) {
                if (fl.isAnnotationPresent(IntentKey.class)) {
                    intentKey = fl.getAnnotation(IntentKey.class);
                    String key = intentKey.value();
                    Class<?> clazz = fl.getType();
                    fl.setAccessible(true);
                    accessible = fl.isAccessible();
                    v = null;
                    if (clazz.isAssignableFrom(String.class)) {
                        v = intent.getStringExtra(key);
                    } else if (clazz.isAssignableFrom(int.class)) {
                        v = intent.getIntExtra(key, intentKey.defaultInt());
                    } else if (clazz.isAssignableFrom(float.class)) {
                        v = intent.getFloatExtra(key, intentKey.defaultFloat());
                    } else if (clazz.isAssignableFrom(double.class)) {
                        v = intent.getDoubleExtra(key, intentKey.defaultDouble());
                    } else if (clazz.isAssignableFrom(String[].class)) {
                        v = intent.getStringArrayExtra(key);
                    } else if (clazz.isAssignableFrom(int[].class)) {
                        v = intent.getIntArrayExtra(key);
                    } else if (clazz.isAssignableFrom(float[].class)) {
                        v = intent.getFloatArrayExtra(key);
                    } else if (clazz.isAssignableFrom(double[].class)) {
                        v = intent.getDoubleArrayExtra(key);
                    } else if (clazz.isAssignableFrom(Parcelable.class)) {
                        v = intent.getParcelableExtra(key);
                    } else if (clazz.isAssignableFrom(ArrayList.class)) {
                        Type type = fl.getGenericType();
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        Type[] types = parameterizedType.getActualTypeArguments();
                        Class<?> parClass = (Class<?>) types[0];
                        if (parClass.isAssignableFrom(String.class)) {
                            v = intent.getStringArrayListExtra(key);
                        } else if (parClass.isAssignableFrom(int.class)) {
                            v = intent.getIntegerArrayListExtra(key);
                        } else if (parClass.isAssignableFrom(Parcelable.class)) {
                            v = intent.getParcelableArrayListExtra(key);
                        }
                    }
                    if (v != null) {
                        fl.set(activity, v);
                    }
                    fl.setAccessible(accessible);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void injIntentUtil(Activity activity){
        InjValue(activity);
    }


}
