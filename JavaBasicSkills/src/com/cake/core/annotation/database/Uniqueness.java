package com.cake.core.annotation.database;


public @interface Uniqueness {
	//使嵌入的@Constraints注解中的unique()元素为true
	Constraints constraints() default @Constraints(unique = true);
}
