package com.zxy.test;

public class Test {

	public static void main(String[] args) {
		String s="1|2|5";
		String[] split = s.split("\\|");
		for (String string : split) {
			System.out.println(string);
		}
	}

}
