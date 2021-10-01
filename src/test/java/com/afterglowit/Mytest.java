package com.afterglowit;

import com.afterglowit.utils.MD5Util;
import org.junit.Test;

public class Mytest {
    @Test
    public void testMD5(){
        String mi = MD5Util.getMD5("000000");
        System.out.println(mi);
    }



}
