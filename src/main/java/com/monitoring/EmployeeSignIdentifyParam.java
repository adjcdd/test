package com.monitoring;

import java.io.Serializable;

/**
 * Created by zhangweihua on 2018/1/16.
 */
public class EmployeeSignIdentifyParam implements Serializable{
    private String image;
    private String device_no;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDevice_no() {
        return device_no;
    }

    public void setDevice_no(String device_no) {
        this.device_no = device_no;
    }
}
