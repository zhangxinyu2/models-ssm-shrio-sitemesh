/**
 * 权限管理 用户添加
 * 
 */
  $(function(){
	  var form=$("#roleForm");
	  form.bootstrapValidator({
		  message: 'This value is not valid',
		  feedbackIcons:{
			  valid:"glyphicon glyphicon-ok",
			  invalid:'glyphicon glyphicon-remove',
			  validating:'glyphicon glyphicon-refresh'
		  },
		  fields:{
			  request_param1:{
				  validators:{
					  notEmpty:{
						  message:"角色名称不能为空"
					  }
				  }
			  }
		  }
	  });
	  //添加用户
	  $("#addRole").click(function(){
		  //点击添加获取form验证
		  var bv= form.data("bootstrapValidator");
		  //手动启动验证
		  bv.validate();
		  //验证通过往下进行，不通过结束进程
		  if(!bv.isValid()){
			  return ;
		  }
		  //提交表单
		  document.getElementById("roleForm").submit();
		  //$("#formValidator").submit();
	  });
	  //重置按钮
	  $("#reset").click(function(){
		  $("#param1").val("");
	  });
  })
