<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%  
String path = request.getContextPath(); /*  用于返回站点的根路径 */
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; /* 得到登陆界面的路径 */ 
%>  
  
<%   
      String url = basePath;   //设置跳转的地址
      String issucc=(String) request.getAttribute("issucc");
%>  
<html>  
   <head>              
        <meta http-equiv=refresh content=10;url=<%=url %>> 
        <title>错误</title>
        <style type="text/css">
        a:hover{
        color:#FF4500;
        /* text-decoration:underline; */
        }
        </style>            
   </head>   
       <body> 
      <%--  <%=request.getContextPath()%>  --%>
        <div align="center">  
            <h3 style=color:red><%if(issucc!=null){ %>此帐号以存在<%}else{ %>请使用您的账号登陆系统<%} %></h3>  
            <h3 style=color:red><span id=jump>10</span> 秒钟后页面将自动返回登录页面...</h3>  
            <h3 style=color:red>若您尚无账户<a href="javascript:void(0);" onclick="jumpToILoginin()">点击此处前往注册</a></h3>  
        </div>       
      </body>  
        <script>  
             function countDown(secs){  
                       jump.innerText=secs; /*用来改变计数*/ 
                       if(--secs>0)  
                                setTimeout("countDown("+secs+" )",1000);  /*每秒执行一次countDown()*/
             }  
             countDown(10);
             
            function jumpToILoginin(){  
                window.location.href='register.jsp';  
            }  
       </script>  
</html>