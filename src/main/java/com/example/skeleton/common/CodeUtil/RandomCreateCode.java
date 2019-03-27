package com.example.skeleton.common.CodeUtil;

/**
 * @Author: yebing
 * @Date: 2018-9-20 15:12
 * @Version 1.0.0
 */
public class RandomCreateCode {
    /**
     * 生成N位字符算法
     * @Param num
     * @return rands
     */
    public static String getCode(int num){
        String chars = "abcdefghijklmmopqrstuvwxyz1234567890";
        char[] rands = new char[num];
        for (int i = 0; i < num; i++)
        {
            int rand = (int) (Math.random() * 36);
            rands[i] = chars.charAt(rand);
        }
        StringBuffer sb = new StringBuffer();
        for(int j = 0; j < rands.length; j++){
            sb. append(rands[j]);
        }
        String rand = sb.toString();
        return rand;
    }
}
