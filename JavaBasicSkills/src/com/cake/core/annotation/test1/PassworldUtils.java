package com.cake.core.annotation.test1;

import java.util.List;

public class PassworldUtils{
	
	@UseCase(id = 47,description=
			"Password must contain at least one numeric")
	public static boolean validatePassword(String password){
		System.out.println("validatePassword:"+password.matches("\\w*\\d\\w*"));
		return password.matches("\\w*\\d\\w*");
	}
	
	@UseCase(id=48)
	public String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id=49,description=
			"New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords, String password){
		
		return !prevPasswords.contains(password);
	}
	
}
