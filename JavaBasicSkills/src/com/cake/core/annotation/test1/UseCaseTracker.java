package com.cake.core.annotation.test1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 注解处理器：读取PassworldUtils.class
 * 这类注解用法比普通的注释更有用
 * @author horsttop
 *
 */
public class UseCaseTracker {
	
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases,47,48,49,50);
		trackUserCases(useCases, PassworldUtils.class);
	}
	public static void trackUserCases(List<Integer> useCases,Class<?> cl) {
		for(Method m:cl.getDeclaredMethods()){
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc!=null){
				System.out.println("Found use case:"+uc.id()+":"+uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for(int i:useCases){
			System.out.println("Warning: Missing use case:"+i);
		}
	}
}
