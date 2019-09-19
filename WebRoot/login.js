document.getElementById("username").onblur=function(){
      var username=document.getElementById("username").value;
      var reg = /^[a-zA-Z]{2,6}$/;
     if(!reg.test(username)){
      	alert("用户名错误，请重新输入！");
      }
}

document.getElementById("password").onblur=function(){
      var password=document.getElementById("password").value;
     
     // alert("haha");//正则表达式,定义一个匹配字符串的规则
      var reg = /^[a-zA-Z0-9]{2,6}$/;//代表3-12位的任意字符
      
      if(!reg.test(password)){
            alert("密码错误，请重新输入！");
      }
}
function aclick(){

      var username=document.getElementById("username").value;
      if(username==""||username==null){
            alert("用户名不能为空");
      }
      var password=document.getElementById("password").value;
      if(password==""||password==null){
            alert("密码不能为空！");
      }

}