package com.cake.core.annotation.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//如果省去@Target则表示适用于所有的ElementType,不过这并不常见
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
	/**
	 * 该注解通过这个元素为处理器创建数据库表提供表的名字
	 * @return
	 */
	public String name() default "";
}

