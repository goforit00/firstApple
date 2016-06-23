package com.goforit.firstapple.common.utils;

import java.util.Date;
import java.util.Random;

/**
 * Created by junqingfjq on 16/6/23.
 */
public class StringGenerator {

    //TODO
    private static char [] arr={'a','b','c','d'};

    public static String generator(int num){

        int len=arr.length;
        Random r=new Random(new Date().getTime());
        int index=r.nextInt(len);
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<num;i++){
            sb.append(arr[index]);
        }

        return sb.toString();
    }
}
