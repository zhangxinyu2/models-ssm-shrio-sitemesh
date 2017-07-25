package com.modelssm.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletRequest;

import org.apache.commons.lang3.Validate;

/**
 * form 参数 处理问题
 * @author zxy
 *
 */
public class Requests {
	
	public static final String PARAMS="request_";
	
	@SuppressWarnings("rawtypes")
	public static HashMap<String, Object> getParameters2HashMap(ServletRequest request, String prefix) {
		Validate.notNull(request, "Request must not be null");
		Enumeration paramNames = request.getParameterNames();
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (prefix == null) {
			prefix = "";
		}
		while ((paramNames != null) && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if ((values == null) || (values.length == 0)) {
					// Do nothing, no values found at all.
				} else if (values.length > 1) {
					params.put(unprefixed, values);
				} else {
					params.put(unprefixed, values[0]);
				}
			}
		}
		return params;
	}
	
	/**
	 * 组合Parameters生成Query String的Parameter部分, 并在paramter name上加上prefix.
	 * 
	 * @see #getParametersStartingWith
	 */
	public static String encodeParameterStringWithPrefix(Map<String, Object> params, String prefix) {
		if (params==null || params.isEmpty()) {
			return "";
		}

		if (prefix == null) {
			prefix = "";
		}

		StringBuilder queryStringBuilder = new StringBuilder();
		Iterator<Entry<String, Object>> it = params.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			
			if ( entry.getValue() instanceof   String[] ){
				
				for (String obj : (String[]) entry.getValue()) {
					queryStringBuilder.append(prefix).append(entry.getKey()).append('=').append(obj);
					queryStringBuilder.append('&');
				}
			}else{
				queryStringBuilder.append(prefix).append(entry.getKey()).append('=').append(entry.getValue());
				if (it.hasNext()) {
					queryStringBuilder.append('&');
				}
			}
		}
		return queryStringBuilder.toString();
	}

}
