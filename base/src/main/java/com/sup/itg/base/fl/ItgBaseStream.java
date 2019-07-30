package com.sup.itg.base.fl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ItgBaseStream {
    protected static String readString(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try {
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) break;
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }


    protected static void write(String content, OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        try {
            bufferedWriter.write(content);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected static boolean createFile(File file) {
        if (file.isDirectory()) {
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(file, System.currentTimeMillis() + ".txt");
            try {
                file.createNewFile();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.mkdirs();
                }
                try {
                    return file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } else {
                return true;
            }
        }

    }

}
