/**
 * user.jsp  js代码处理
 */
	
	$(function(){
		 var form = $('#formvalidator');
		 form.bootstrapValidator({
	        message: 'This value is not valid',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            name: {
	                message: '用户名无效',
	                validators: {
	                    notEmpty: {
	                        message: '用户姓名不能为空'
	                    },
                        stringLength: {
                            min: 2,
                            max: 10,
                            message: '用户姓名长度必须在2到10位之间'
                        }
	                }
	            },
	            age: {
	                validators: {
	                    notEmpty: {
	                        message: '年龄不能为空'
	                    },
	                    regexp: {
                            regexp: /^[0-9]+$/,
                            message: '年龄只能是整数'
                        }
	                }
	            }
	        }
	    }) 
	  
		$("#addUser").click(function(){
			//表单验证
			var bv =form.data('bootstrapValidator');
			bv.validate();
			if (!bv.isValid()) {
				return ; 
			}
			var name=$("#name").val();
			var age=$("#age").val();
			$.ajax({
				url:path+"/user/addUser",
				type:"POST",
				async:false,
				data:{
					"name":name,
					"age":age
				},
				success:function(data){
					if(data.code==200){
						alert(data.msg);
						window.location.href=path+"/user/queryUserList"
						
					}else{
						alert(data.msg);
					}
				}
			})
		})
		$("#queryUser").click(function(){
			$.ajax({
				url:path+"/user/queryUserList",
				data:"",
				async:false,
				type:"POST",
				success:function(date){
					alert("成功");
				},
				error: function(){
				    alert(arguments[1]);
				}
			})
		})
	});

	