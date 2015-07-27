//:com/cake/core/annotations/database/TableCreator.java
//Reflect-based annotation processor.
//{Args:annotations.database.Member}
package com.cake.core.annotation.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
	public static void main(String[] args) {
		/*if (args.length<1) {
			System.out.println("arguments: annotated classes");
			System.exit(0);
		}*/
		String[] myArgs = {"com.cake.core.annotation.database.Member"};
		for(String className:myArgs){
			try {
				Class<?> cl = Class.forName(className);
				DBTable dbTable = cl.getAnnotation(DBTable.class);
				if(dbTable==null){
					System.out.println("NO DBTable annotations in class:"+className);
					continue;
				}
				//获取表名
				String tableName = dbTable.name();
				if(tableName.length()<1)
					tableName = cl.getName().toUpperCase();
				//获取字段名
				List<String> columnDefs = new ArrayList<String>();
				//getDeclaredFields()可以取得所有fields,而getFields()受访问权限限制
				for(Field field:cl.getDeclaredFields()){
					String columnName = null;
					Annotation[] anns = field.getDeclaredAnnotations();
					if(anns.length<1)
						continue;// 表里没有字段
					if(anns[0] instanceof SQLInteger){
						SQLInteger sInt = (SQLInteger) anns[0];
						if(sInt.name().length()<1)
							columnName = field.getName().toUpperCase();
						else
							columnName = sInt.name();
						columnDefs.add(columnName+" INT"+getConstraints(sInt.constraints()));
					}
					if(anns[0] instanceof SQLString){
						SQLString sString = (SQLString) anns[0];
						if(sString.name().length()<1)
							columnName = field.getName().toUpperCase();
						else
							columnName = sString.name();
						columnDefs.add(columnName+" VARCHAR("+sString.value()+")"+getConstraints(sString.constraints()));
					}
					StringBuilder createCommand = new StringBuilder("CREATE TABLE"+tableName+"(");
					for(String columnDef:columnDefs)
						createCommand.append("\n"+columnDef+",");
					String tableCreate = createCommand.substring(0, createCommand.length()-1)+");";
					System.out.println("Table Creation SQL for"+ className + "is:\n"+tableCreate);
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static String getConstraints(Constraints con) {
		String constraints =" ";
		if(!con.allowNumber()){
			constraints+=" NOT NULL";
		}
		if(con.primaryKey()){
			constraints+=" PRIMARY KEY";
		}
		if(con.unique()){
			constraints+=" UNIQUE";
		}
		return constraints;
	}
}
