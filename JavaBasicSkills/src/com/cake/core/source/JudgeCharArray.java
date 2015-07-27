package com.cake.core.source;
/**
 * 判断char[]是不是基本类型
 * @author horsttop
 *
 */
public class JudgeCharArray {
	public static void main(String[] args) {
		char chars[] = new char[5];
		int i = 0;
		if(chars instanceof Object){
			System.out.println("char-array is not a basic type");
			
		}
		
	}
}
