package com.modelssm.controller.shiroadmin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modelssm.adminrole.entity.AdminRole;
import com.modelssm.shiroadmin.service.IAdminRoleService;
import com.modelssm.verifyparam.VerifyParams;
import com.modelssm.web.Requests;

@Controller
@RequestMapping("/adminRole")
public class AdminRoleController {
	
	private Logger log =LoggerFactory.getLogger(AdminRoleController.class);
	
	@Autowired
	private IAdminRoleService iAdminRoleService;
	
	@RequestMapping("/queryRole")
	public String queryRole(HttpServletRequest request,Model model){
		log.info("---查询所有的角色信息----");
		Map<String,Object> params= Requests.getParameters2HashMap(request, Requests.PARAMS);
		params=VerifyParams.verify(params);
		PageResponse(params,model);
		return "adminrole/adminRoleList";
	}

	@RequestMapping("/addRole")
	public String addRole(HttpServletRequest request,Model model){
		log.info("---添加角色信息----");
		Map<String,Object> params= Requests.getParameters2HashMap(request, Requests.PARAMS);
		params=VerifyParams.verify(params);
		if(StringUtils.isNotBlank((CharSequence) params.get("param1"))){
			if(iAdminRoleService.queryExist(params)){
				model.addAttribute("error", "已存在角色无效添加！！");
			}else{
				AdminRole ar=new AdminRole();
				ar.setCreatetime(new Date());
				ar.setName((String) params.get("param1"));
				iAdminRoleService.saveRole(ar);
				model.addAttribute("error", "角色添加成功！！");
			}
		}
		params.remove("param1");
		PageResponse(params,model);
		return "adminrole/adminRoleList";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id,HttpServletRequest request,Model model){
		log.info("---删除角色信息----");
		Map<String,Object> params= Requests.getParameters2HashMap(request, Requests.PARAMS);
		params=VerifyParams.verify(params);
		
		if(iAdminRoleService.deleteById(id)){
			model.addAttribute("error", "角色删除成功！！");
		}else{
			model.addAttribute("error", "角色删除失败！！");
		}
		PageResponse(params,model);
		return "adminrole/adminRoleList";
	}
	
	/**
	 * 页面数据返回
	 * @param params
	 * @param model
	 */
	private void PageResponse(Map<String, Object> params, Model model) {
		List<AdminRole> arList=	iAdminRoleService.queryRole(params);
		model.addAttribute("arList", arList);
		model.addAttribute("params",Requests.encodeParameterStringWithPrefix(params, Requests.PARAMS));		
	}
	
}
