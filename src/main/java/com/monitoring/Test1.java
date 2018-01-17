package com.monitoring;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by zhangweihua on 2018/1/16.
 */
public class Test1 {
    public static void main(String[] args){
        File file = new File("G:\\123\\000014.jpg");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            byte[] buffer = bos.toByteArray();
            fis.close();
            bos.close();
            EmployeeSignIdentifyParam employeeSignIdentifyParam = new EmployeeSignIdentifyParam();
            employeeSignIdentifyParam.setDevice_no("001");
            employeeSignIdentifyParam.setImage(Base64Util.encodeBase64Byte2Str(buffer));
            String url = "http://192.168.1.22:8088/face/monitoring";
            String param = "{\"image\":\"" + employeeSignIdentifyParam.getImage() + "\",\"device_no\":\"" + employeeSignIdentifyParam.getDevice_no() +"\"}";
            String respStr = OkHttp3Utils.postJson(url, param, null);
            System.out.print(respStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
