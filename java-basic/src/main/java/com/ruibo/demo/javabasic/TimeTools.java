package com.ruibo.demo.javabasic;

import java.text.SimpleDateFormat;

public class TimeTools {

    public static String getTime(){
        return  new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SSS").format(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        System.out.println(getTime());
    }
}
