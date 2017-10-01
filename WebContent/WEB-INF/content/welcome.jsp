<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%  
String path = request.getContextPath(); /*  用于返回站点的根路径 */
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; /* 得到登陆界面的路径 */ 
%>  
  
<%   
      String url = basePath;   //设置跳转的地址  
%>  
<html>  
   <head>              
        <meta http-equiv=refresh content=10;url=<%=url %>> 
        <title>Welcome</title>
        <style type="text/css">
        a:hover{
        color:#FF4500;
        /* text-decoration:underline; */
        }
        h2{
         -moz-text-decoration:blink;
        }
        </style>            
   </head>   
       <body> 
      <%--  <%=request.getContextPath()%>  --%>
        <div align="center">  
            <h2 style=color:red>恭喜你！注册成功</h2>  
            <h3 style=color:red><span id=jump>10</span> 秒后将自动返回登录页面...</h3>  
            <h3 ><a href="javascript:void(0);" onclick="jumpToILoginin()">点击此处可立即返回</a></h3>  
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
                window.location.href='<%=url %>';  
            }  
       </script>  
</html>