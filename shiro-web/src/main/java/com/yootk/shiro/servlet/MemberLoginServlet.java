package com.yootk.shiro.servlet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.servlet")
public class MemberLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String path = "/login.jsp" ;    // 设置一个跳转路径
        String mid = request.getParameter("mid") ;
        String password = request.getParameter("password") ;
        // 在Shiro里面如果要进行认证处理则一定要提供有一个认证的Token信息
        AuthenticationToken token = new UsernamePasswordToken(mid,password) ;
        try {
            SecurityUtils.getSubject().login(token);
            path = "/pages/welcome.jsp" ; // 登录成功不出现异常
        } catch (Exception e) {
            request.setAttribute("errors",e.getMessage());
        }
        request.getRequestDispatcher(path).forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
