package com.modelssm.pageutil;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**
 * 分页处理
 * 
 * @author zxy
 *
 */
public class PageUtil {
	
	public static PageRequest pageDealwith(int pageNumber, 
			int pagzSize, String sortType){
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		} else if ("favorCnt".equals(sortType)) {
			sort = new Sort(Direction.DESC, "favorCnt");//按收藏数量
		} else if ("browserCnt".equals(sortType)) {
			sort = new Sort(Direction.DESC, "browserCnt");//按浏览次数
		} else if ("currentAmount".equals(sortType)) {
			sort = new Sort(Direction.DESC, "currentAmount");//按投资金额
		} else if ("currentMember".equals(sortType)) {
			sort = new Sort(Direction.DESC, "currentMember");//按参与人数
		}
		return new PageRequest(pageNumber-1, pagzSize, sort);
	}

}
