package com.sup.itg.base.fl;

import android.os.Environment;

import com.sup.itg.base.ItgApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ItgSd extends ItgBaseStream {

    public static boolean hasSd() {
        if (Environment.isExternalStorageEmulated()) {
            return true;
        } else {
            return false;
        }
    }


    public static String getAssert(String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = ItgApp.getApp().getAssets().open(fileName);
            return readString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeDataDataFile(String info, String fileName) {
        File dir = ItgApp.getApp().getExternalFilesDir("info");
        File file = new File(dir.getAbsoluteFile(), fileName);
        if (createFile(file)) {
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                write(info, outputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getDataDataFile(String fileName) {
        File dir = ItgApp.getApp().getExternalFilesDir("info");
        File file = new File(dir.getAbsoluteFile(), fileName);
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                return readString(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static String getString(String path) {
        File file = new File(path);
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                return readString(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static void write(String content, String path) {
        File file = new File(path);
        if (createFile(file)) {
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                write(content, outputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeAppend(String content, String path) {
        File file = new File(path);
        if (createFile(file)) {
            try {
                FileOutputStream outputStream = new FileOutputStream(file, true);
                write(content, outputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
