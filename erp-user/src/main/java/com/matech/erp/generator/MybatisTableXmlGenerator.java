package com.matech.erp.generator;

import java.sql.SQLException;
import java.util.List;

import com.matech.erp.database.DatabaseSchema;
import com.matech.erp.utils.StringUtil;

public class MybatisTableXmlGenerator {

    /*** 
     * 将表名转成驼峰命名的类名 
     * @param tableName 数据库表名
     * @return 类名
     */ 
	static public String getDomainObjectName(String tableName) {
    	// 去掉表名有前缀xxx_
    	String className = tableName;
    	int prefix = tableName.indexOf('_');
    	if (prefix > 0) {
    		className = tableName.substring(prefix+1);
    	}
    	// 将表名转成驼峰命名    	
    	return StringUtil.toCapitalizeCamelCase(className);
	}
	
	public static void main(String[] args) {
		DatabaseSchema schema = new DatabaseSchema();
		try {
			List<String> tableNames = schema.getTableNames();			
			for (int i=0; i<tableNames.size(); i++) {
				String tableName = (String)tableNames.get(i);
				String objectName = getDomainObjectName(tableName);
				String xml="<table tableName=\"" + tableName +
						"\" domainObjectName=\"" + objectName +
						"\" ><generatedKey column=\"id\" sqlStatement=\"Mysql\" identity=\"true\" /></table>";
				System.out.println(xml);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
