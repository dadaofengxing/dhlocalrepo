package com.dh.ddfx.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by duh on 2018/5/23 16:38.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
public class Test {
    private static String getListStringWithQuotationmarks(List<String> list){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        int i = 0;
        for(String str : list){
            sb.append("\"").append(str).append("\"");
            if(i++ < list.size()-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    private static double getYmin(double min){
        double doubleMin = Math.floor(min);
        double result = 1;
        if(doubleMin > 50){
            result = ((int)doubleMin/50) * 50;
        }else if (doubleMin > 5){
            result = ((int)doubleMin/5) * 5;
        }else if(doubleMin > 0.5){
            result = ((int)doubleMin/0.5) * 0.5;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Float> floatList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            float f = random.nextFloat()*1000;
            floatList.add(f);
            System.out.print(f+" min =");
            System.out.println(getYmin(f));
        }
    }
    public static void main2(String[] args) {
        List<String> list = Arrays.asList("1","2","3");
        String[] strs = {"4","5","6"};
        System.out.println(Arrays.toString(strs));
        System.out.println(list);
        System.out.println(getListStringWithQuotationmarks(list));
    }
}
