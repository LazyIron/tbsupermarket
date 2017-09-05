package com.ucaitop.tb.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Message {
	private final static String SUCCSE= "succse";
	private final static String ERROR = "error";
	
	//创建一个map集合
	protected static Map<String,String> mesMap;
	//返回一个成功的信息
	public static String getSuccse(){
		//创建一个map集合存放信息
		mesMap = new HashMap<>();
		//将信息存放起来
		mesMap.put("mes", SUCCSE);
		//创建转换成json的对象
		Gson gson = new Gson();
		String mesJson = gson.toJson(mesMap);
		return mesJson;
	}
	
	//返回一个错误的信息
	public static String getError(){
		//创建一个map集合存放信息
		mesMap = new HashMap<>();
		//将信息存放起来
		mesMap.put("mes", ERROR);
		//创建转换成json的对象
		Gson gson = new Gson();
		String mesJson = gson.toJson(mesMap);
		return mesJson;
	}
}
