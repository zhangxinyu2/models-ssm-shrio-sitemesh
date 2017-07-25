package com.modelssm.controller.shiroadmin;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modelssm.adminuser.entity.AdminUser;
import com.modelssm.shiroadmin.service.IAdminUserService;
import com.modelssm.verifyparam.VerifyParams;
import com.modelssm.web.Requests;

/**
 * 权限管理用户
 * @author zxy
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {
	private Logger log=LoggerFactory.getLogger(AdminUserController.class);
	
	@Autowired
	private IAdminUserService iAdminUserService;
	
	@RequestMapping("/quaryAdminUserList")
	public String QuaryAdminUserList(@RequestParam(value="page",defaultValue="1") int pageNumber,
			@RequestParam(value="page.size",defaultValue="10") int pageSize,
			@RequestParam(value="sortType",defaultValue="auto") String sortType,
			Model model,HttpServletRequest request){
		//截取参数
		Map<String, Object> params = Requests.getParameters2HashMap(request, Requests.PARAMS);
		//参数去空
		params=VerifyParams.verify(params);
		//分页查询返回数据
		PageRequest(model,params,pageNumber,pageSize);
		log.info("---------查询权限管理用户列表------");
		return "admin/adminUserList";
	}
	@RequestMapping("/delete")
	public String delete(Integer id,@RequestParam(value="page",defaultValue="1") int pageNumber,
			@RequestParam(value="page.size",defaultValue="10") int pageSize,
			@RequestParam(value="sortType",defaultValue="auto") String sortType,
			Model model,HttpServletRequest request){
		Map<String, Object> params = Requests.getParameters2HashMap(request, Requests.PARAMS);
		//参数去空
		params=VerifyParams.verify(params);
		boolean b =iAdminUserService.deleteById(id);
		if(b){
			model.addAttribute("error", "删除用户成功！！");
		}else{
			model.addAttribute("error", "删除用户失败！！");
		}
		//分页查询返回数据
		PageRequest(model,params,pageNumber,pageSize);
		return "admin/adminUserList";
	}
	@RequestMapping("/addAdmin")
	public String addAdmin(@RequestParam(value="page",defaultValue="1") int pageNumber,
			@RequestParam(value="page.size",defaultValue="10") int pageSize,
			@RequestParam(value="sortType",defaultValue="auto") String sortType,
			Model model,HttpServletRequest request){
		log.info("---添加权限用户开始---");
		Map<String, Object> params = Requests.getParameters2HashMap(request, Requests.PARAMS);
		AdminUser au=	iAdminUserService.queryAdminUser(params);
		if(au!=null){
			model.addAttribute("error","用户名已存在，无法重复添加");
		}else{
			au=new AdminUser();
			au.setCreatetime(new Date());
			au.setName((String) params.get("param1"));
			au.setRealname((String) params.get("param2"));
			au.setPassword("123456");
			au.setSalt("sasdf sss");
			iAdminUserService.addUser(au);
			model.addAttribute("error","用户添加添加成功");
		}
		//分页查询返回数据
		PageRequest(model,params,pageNumber,pageSize);
		return "admin/adminUserList";
	}
	/**
	 * 更新用户真实姓名
	 * @param request
	 * @return
	 */
	
	@RequestMapping("/update")
	@ResponseBody
	public boolean update(HttpServletRequest request){
		String id=request.getParameter("id");
		String realName=request.getParameter("realName");
		AdminUser au=new AdminUser();
		au.setId(Integer.valueOf(id));
		au.setRealname(realName);
		iAdminUserService.updateRealName(au);
		return true;
	}
	/**
	 * 分页数据返回查询
	 * @param model
	 * @param params
	 * @param pageNumber
	 * @param pageSize
	 */
	private void PageRequest(Model model, Map<String, Object> params,
			int pageNumber, int pageSize) {
		Page<AdminUser> adminPage=iAdminUserService.queryAdminUserList(params, pageNumber, pageSize);
		model.addAttribute("adminPage",adminPage);
		model.addAttribute("params", Requests.
				encodeParameterStringWithPrefix(params, Requests.PARAMS));
	}
}
