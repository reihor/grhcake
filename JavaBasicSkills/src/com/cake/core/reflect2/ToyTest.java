package com.cake.core.reflect2;
/**
 * 
 * @author horsttop
 *
 */
public class ToyTest {
	static void printInfo(Class<?> cc){
		System.out.printf("ToyTest: Class name: %s, is interface %s.\n",cc.getName(),cc.isInterface());
		System.out.printf("ToyTest: Simple name: %s.\n",cc.getSimpleName());
		System.out.printf("ToyTest: Canonical name: %s.\n",cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("com.cake.core.reflect2.FancyToy");//全名
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class<?> face:c.getInterfaces())
			printInfo(face);
		Class<?> up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Cannot instance");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Cannot access");
		}
		printInfo(obj.getClass());
	}
}
