package com.cake.core.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.cake.core.reflect.Action");
			Field[] feilds = cls.getFields();
			//Field[] feilds = cls.getDeclaredFields();
			//Method[] methods = cls.getMethods();
			Method[] methods = cls.getDeclaredMethods();
			int feildsLength = feilds.length;
			int f=0;
			while (feildsLength--<0) {
				System.out.printf("Main: Feilds %s.\n",feilds[f]);
				f++;
			}
			for(int i=0;i<methods.length;i++){
				System.out.printf("Main: method %s.\n",methods[i]);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
