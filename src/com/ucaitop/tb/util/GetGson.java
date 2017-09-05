package com.ucaitop.tb.util;



import com.google.gson.Gson;

/**
 * 方便转化json数据的工具类！
 * @author AZTQ
 *
 */
public class GetGson {
	

	
	public static String getJson(Object obj){
		//创建一个Gson对象
		Gson gson = new Gson();
		//将传入的参数转换成json数据
		String json = gson.toJson(obj);
		//将得到的json数据返回
		return json;
	}
}	
