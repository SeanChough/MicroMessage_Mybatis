package com.imooc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Message;
import com.imooc.service.QueryService;

/*
 * 页面跳转的控制
 */
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//接收表单提交过来的参数
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		
		//业务需要，调用Service层
		QueryService listService = new QueryService();
		List<Message> messageList = listService.queryMessageList(command, description);
			
		//往页面传数据
		req.setAttribute("messageList",messageList);
		//为了使搜索时输入的关键字可以常驻显示，也要把这两个参数传递过去
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		
		//实现页面跳转：将页面展示出来
		//dispatcher:调度程序
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);//使用forward方式进行跳转//跳转到list.jsp页面
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
