package com.ballistic;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> list = new ArrayList<>();
        list.add("Alan Alda stops racecar, spots ad: \"Lana-L.A.\"");
        list.add("Amaryllis sillyrama.");
        list.add("An Elenna call: \"Eek! I let a rapper name 'DeMan Reppa' rate like Ella.\" Can Elena? uuuu");
        System.out.println(new PalindromeProcess().getTotalSpace(list));
    }

}
