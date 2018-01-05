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
 * ҳ����ת�Ŀ���
 */
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ձ��ύ�����Ĳ���
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		
		//ҵ����Ҫ������Service��
		QueryService listService = new QueryService();
		List<Message> messageList = listService.queryMessageList(command, description);
			
		//��ҳ�洫����
		req.setAttribute("messageList",messageList);
		//Ϊ��ʹ����ʱ����Ĺؼ��ֿ��Գ�פ��ʾ��ҲҪ���������������ݹ�ȥ
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		
		//ʵ��ҳ����ת����ҳ��չʾ����
		//dispatcher:���ȳ���
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);//ʹ��forward��ʽ������ת//��ת��list.jspҳ��
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
