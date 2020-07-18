package com.amazon.qa.hashmap;

import java.util.HashMap;

public class Data {
	
	public static HashMap<String, String> getUserLoginInfo() {
		
		HashMap<String, String> userMap = new HashMap<String, String>();
		userMap.put("customer", "vanjarisayali@gmail.com_Matterwave");
		userMap.put("admin", "vsay31@gmail.com_Happy123");
		
		return userMap;
		
	}

}
