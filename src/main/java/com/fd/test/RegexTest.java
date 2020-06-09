package com.fd.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {


        String regex = "^a";
        String input = "abcdef21356asdfas";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        boolean b = matcher.find();
        System.out.println(b);


        int end = matcher.end();
        System.out.println(end);


        System.out.println(matcher.toString());

        System.out.println((-11 % 5 + 5 )%5);


    }


}
