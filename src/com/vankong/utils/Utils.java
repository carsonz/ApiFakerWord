package com.vankong.utils;

import com.alibaba.fastjson.util.UTF8Decoder;
import sun.nio.cs.StandardCharsets;

import java.io.*;
import java.net.URLEncoder;

/**
 * @项目名称：ApiFakerWord
 * @类名称：Utils
 * @创建人：cailiang
 * @创建时间：16/9/8 21:47
 * @修改人：
 * @修改时间：16/9/8 21:47
 * @修改备注：
 */
public class Utils {
    public static String readFile(String path) {
        try {
            createFile(path);
            FileInputStream fis = new FileInputStream(path);
            int count = fis.available();
            int ready = 0;
            byte[] tempBuf = new byte[count];
            StringBuffer sb = new StringBuffer();
            while (ready < count) {
                int readCount = fis.read(tempBuf);
                if (readCount > 0) {
                    ready += readCount;
                } else {
                    break;
                }
                String tmp = new String(tempBuf, 0, readCount,"UTF-8");
                sb.append(tmp);
            }
            fis.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean writeFile(String path,String data) {
        try {
            createFile(path);
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(data.getBytes("UTF-8"));
            fos.flush();
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean createFile(String destFileName) {
        File file = new File(destFileName);
        if (file.exists()) {
            return true;
        }
        if (destFileName.endsWith(File.separator)) {
            return false;
        }
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                //创建目录失败
                return false;
            }
        }
        // 创建目标文件
        try {
            if (file.createNewFile()) {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
