package com.sup.itg.base;

import android.util.Log;

import com.sup.itg.base.de.ItgDate;
import com.sup.itg.base.fl.ItgSd;

public class ItgL {
    private static String className = "";
    private static String methodName = "";
    private static int lineNumber;
    private static boolean print = true;

    public static void setPrint(boolean p){
        print = p;
    }

    private static boolean isDebuggable() {
        return print;
    }

    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(methodName);
        buffer.append("(").append(className).append(":").append(lineNumber).append(")");
        buffer.append(log);
        return buffer.toString();

    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(message));
    }


    public static void i(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.i(className, createLog(message));
    }

    public static void d(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(message));
    }

    public static void v(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(message));
    }

    public static void w(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(message));
    }


    public static void txt(String message, String path) {
        String today = ItgDate.getToday();
        ItgSd.writeAppend(today + ": " + message + "\r\n", path);
    }

    public static void txt(String message) {
        String today = ItgDate.getToday();
        ItgSd.writeAppend(today + ": " + message + "\r\n", ItgApp.getApp().getExternalFilesDir("log/" + ItgDate.getToday("yyyy-MM-dd")).getAbsolutePath());
    }
}
