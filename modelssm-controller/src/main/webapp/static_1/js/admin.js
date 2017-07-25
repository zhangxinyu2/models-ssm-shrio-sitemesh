/**
 * 权限管理 用户添加
 * 
 */
  $(function(){
	  var form=$("#formValidator");
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
						  message:"用户名不能为空"
					  }
				  }
			  },
			  request_param2:{
				  validators:{
					  notEmpty:{
						  message:"真实姓名不能为空"
					  }
				  }
			  }
		  }
	  });
	  //添加用户
	  $("#addAdmin").click(function(){
		  //点击添加获取form验证
		  var bv= form.data("bootstrapValidator");
		  //手动启动验证
		  bv.validate();
		  //验证通过往下进行，不通过结束进程
		  if(!bv.isValid()){
			  return ;
		  }
		  //提交表单
		  document.getElementById("formValidator").submit();
		  //$("#formValidator").submit();
	  });
	  //重置按钮
	  $("#reset").click(function(){
		  $("#param1").val("");
		  $("#param2").val("");
		  $("#param3").val("");
		  $("#param4").val("");
	  });
  })
  
  //更新用户真实姓名
  function updateAdmin(id){
	  var realName=	$("#"+id).val();
	  if(/^\s*$/.test(realName.trim())){
		  alert("更新的真实姓名不能为空!");
		  return;
	  }
	  $.post("update",{"id":id,"realName":realName},function(data){
		  if(data){
			  $("#error").text("更新成功");
		  }else{
			  $("#error").text("更新失败");
		  }
	  });
}