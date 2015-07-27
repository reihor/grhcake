package com.cake.core.annotation.database;

@DBTable(name = " MEMBER")
public class Member {
	@SQLString(30)//如果自己的注解中定义了名为value的元素,如果该元素是唯一需要赋值的元素，则可以不遵守键值对的规则
	String firstName;
	@SQLString(50)
	String lastName;
	@SQLInteger
	Integer age;
	@SQLString(value=30,
			constraints = @Constraints(primaryKey=true))
	String handle;
	static int memberCount;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getAge() {
		return age;
	}
	public String getHandle() {
		return handle;
	}
	@Override
	public String toString() {
		return handle;
	}
}
