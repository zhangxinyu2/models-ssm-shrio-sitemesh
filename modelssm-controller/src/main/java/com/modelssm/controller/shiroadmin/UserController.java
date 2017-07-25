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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modelssm.jsonresult.JsonResult;
import com.modelssm.shiroadmin.service.IUserService;
import com.modelssm.user.entity.User;
import com.modelssm.web.Requests;

@Controller
@RequestMapping("/user")
class UserController {
	
	private Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService iUserServer;
	
	@RequestMapping("/queryUser")
	public String queryUser(){
		log.info("---查看用户添加信息开始---");
		return "user/user";
	}
	
	@ResponseBody
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public JsonResult addUser(Model model,HttpServletRequest request){
		log.info("---添加用户开始---");
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		log.info("name="+name+",age="+age);
		User user=new User();
		Date date=new Date();
		user.setName(name);
		user.setAge(Integer.valueOf(age));
		user.setCreateTime(date);
		user.setEditTime(date);
		JsonResult json=new JsonResult(JsonResult.SUCCESS);
		try {
			if(iUserServer.addUser(user)!=0){
				json.setCode(JsonResult.SUCCESS);
				json.setMsg(JsonResult.REQUEST_SUCCESS);
			}else{
				json.setCode(JsonResult.ERROR);
				json.setMsg(JsonResult.REQUEST_ERROR);
			}
		} catch (Exception e) {
			log.info("message",e);
			e.printStackTrace();
		}
		return json;
	}
	@RequestMapping("/queryUserList")
	public String queryUserList(@RequestParam(value="page",defaultValue="1") int pageNumber,
			@RequestParam(value="page.size",defaultValue="10") int pageSize,
			@RequestParam(value="sortType",defaultValue="auto") String sortType,
			Model model,HttpServletRequest request){
		log.info("---查询用户列表开始---");
		Map<String, Object> params = Requests.getParameters2HashMap(request, Requests.PARAMS);
		Page<User> userPage=iUserServer.queryUserList(params,pageNumber,pageSize);
		model.addAttribute("userPage",userPage);
		model.addAttribute("params", Requests.
					encodeParameterStringWithPrefix(params, Requests.PARAMS));
		return "user/userList";
	}
}
