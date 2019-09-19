document.getElementById("username").onblur=function(){
      var username=document.getElementById("username").value;
      var reg = /^[a-zA-Z]{2,6}$/;
      
      if(!reg.test(username)){
      	
      	alert("请输入2-6位的字母！");
      }
}
document.getElementById("password1").onblur=function(){
	var password1=document.getElementById("password1").value;
	var reg=/^[a-zA-Z0-9]{6}$/;
	if(!reg.test(password1)){
		alert("请输入6位的字母和数字组合");
	}
}
document.getElementById("password2").onblur=function(){
	var password1=document.getElementById("password1").value;
	var password2=document.getElementById("password2").value;
	if (password1!=password2) {
		alert("两次密码输入不一致！");
	}
}
document.getElementById("submit1").onclick=function(){
	 var username=document.getElementById("username").value;
      if(username==""||username==null){
            alert("用户名不能为空");
      }
      var password1=document.getElementById("password1").value;
      if(password1==""||password1==null){
            alert("密码不能为空！");
      }
     var password2=document.getElementById("password2").value;
     if (password1!=password2) {
		alert("两次密码输入不一致！");
	}

}