<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
   <head>              
        <meta http-equiv=refresh content=5;url="normalization.jsp"> 
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
            <h3 style=color:red>请选择要查看的表头</h3>  
            <h3 style=color:red><span id=jump>5</span> 秒钟后页面将发回到首页......</h3>  
            <h3 style=color:red><a href="javascript:void(0);" onclick="jumpToILoginin()">点击此处立即返回</a></h3>  
        </div>       
      </body>  
        <script>  
             function countDown(secs){  
                       jump.innerText=secs; /*用来改变计数*/ 
                       if(--secs>0)  
                                setTimeout("countDown("+secs+" )",1000);  /*每秒执行一次countDown()*/
             }  
             countDown(5);
             
            function jumpToILoginin(){  
                window.location.href='normalization.jsp';  
            }  
       </script>  
</html>