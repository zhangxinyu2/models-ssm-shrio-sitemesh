package com.modelssm.jsonresult;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * json返回数据封装
 * @author 860105
 *
 */
public class JsonResult {
	
	public final static int SUCCESS=200;
	public final static int ERROR=500;
	public final static String REQUEST_SUCCESS="请求成功";
	public final static String REQUEST_ERROR="请求失败";
	
	private int code;
	private String msg;
	@JsonInclude(Include.NON_NULL)		//object 转json 并且为空不展示
	private Object obj;
	
	public JsonResult() {
	}
	
	public JsonResult(int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

}
