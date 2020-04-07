package com.xierw.practical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则表达式隐藏电话号码
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-03-12
 */
public class PhoneRegularExpression {
    public static void main(String[] args){
        /**
         * 隐藏电话号码中间四位
         * 第一种写法，String.replaceAll()方法
         * $1表示正则表达式 (\d{3})\d*([0-9a-zA-Z]{4}) 的第一个括号内的表达式匹配到的内容，
         * 在本例中，$1表示182，$2表示6293，故最终结果为$1****$2，即182****6293
         */
        String phoneNum = "18251486293";
        phoneNum = phoneNum.replaceAll("(\\d{3})\\d*([0-9a-zA-Z]{4})","$1****$2");
        System.out.println("phoneNum的结果为：" + phoneNum);

        /**
         * 隐藏身份证中间四位
         * 第二种写法，Matcher.replaceAll方法
         * String.replaceAll()的内部实现就是Pattern.compile(regex).matcher(this).replaceAll(replacement)
         */
        String credentialsNum = "420222199704138888";
        Pattern credentialsPattern = Pattern.compile("(\\d{6})\\d*([0-9a-zA-Z]{4})");
        Matcher credentialsMatch = credentialsPattern.matcher(credentialsNum);
        credentialsNum = credentialsMatch.replaceAll("$1********$2");
        System.out.println("credentialsNum的结果为：" + credentialsNum);
    }
}
