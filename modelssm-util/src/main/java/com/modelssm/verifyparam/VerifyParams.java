package com.modelssm.verifyparam;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 各种参数获取验证
 * @author zxy
 *
 */
public class VerifyParams {
	
	public static final String USER="user";

	//-------------每一个不同的form请求参数不同时添加-------------
	
	public static Map<String, Object> verify(Map<String, Object> param, String user) {
		Map<String,Object> map=new HashMap<String, Object>();
		if(USER.equals(user)){
			if(param.containsKey("realName")&&
					StringUtils.isNotEmpty((CharSequence) param.get("realName"))){
				map.put("realName", param.get("realName"));
			}
			if(param.containsKey("age")&&
					StringUtils.isNotEmpty((CharSequence) param.get("age"))){
				map.put("age", param.get("age"));
			}
		}
		return map;
	}

	public static Map<String, Object> verify(Map<String, Object> params) {
		Map<String,Object> map=new HashMap<String, Object>();
		if(params.containsKey("param1")&&
				StringUtils.isNotEmpty((CharSequence) params.get("param1"))){
			map.put("param1", params.get("param1"));
		}
		if(params.containsKey("param2")&&
				StringUtils.isNotEmpty((CharSequence) params.get("param2"))){
			map.put("param2", params.get("param2"));
		}
		if(params.containsKey("param3")&&
				StringUtils.isNotEmpty((CharSequence) params.get("param3"))){
			map.put("param3", params.get("param3"));
		}
		if(params.containsKey("param4")&&
				StringUtils.isNotEmpty((CharSequence) params.get("param4"))){
			map.put("param4", params.get("param4"));
		}
		return map;
	}
}
