package com.shilm.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * <p>Description: </p>
 * 上下文
 * @author shilm
 * @date 2016年4月27日
 * 联系方式：shilm@carnation.com.cn
 */
public class ApplicationContext {

	private static Properties configProps = new Properties();
	public static final String CONFIGFILE = "conf.properties";
	private static String currentPath = System.getProperty("user.dir");
	private static Logger log = Logger.getLogger(ApplicationContext.class);
	
	public static final int MYSQL = 1;
	public static final int ORCALE = 2;
	public static final int SQLSERVER = 3;
	
	private static void loadProperFile() {
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get(currentPath+"/conf/"+CONFIGFILE));
			configProps.load(reader);
			reader.close();
		} catch (IOException e) {
			log.error(" configration load failure, please sure your conf.properties in your conf dir");
		}
	}
	
	public static String getProperty(String name) {
		if(configProps.isEmpty()) {
			loadProperFile();
		}
		return configProps.getProperty(name);
	}
	
}
