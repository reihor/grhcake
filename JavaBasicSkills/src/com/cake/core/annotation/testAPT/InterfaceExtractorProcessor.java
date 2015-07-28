package com.cake.core.annotation.testAPT;

import java.util.ArrayList;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
/**
 * 导入lib文件下tools.jar包
 * apt:annotation processing tools
 * 这里apt过时了,目前尚未发现取代的类,这边例子暂时不写了
 * @author horsttop
 *
 */
public class InterfaceExtractorProcessor implements AnnotationProcessor {
	
	private final AnnotationProcessorEnvironment env;
	private ArrayList<MethodDeclaration> interfacesMethods = new ArrayList<MethodDeclaration>();
	public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env) {
		this.env = env;
	}
	@Override
	public void process() {
		
	}

}
