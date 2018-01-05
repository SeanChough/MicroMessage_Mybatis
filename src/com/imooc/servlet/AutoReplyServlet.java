package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

/**
 * �Զ��ظ�
 */
public class AutoReplyServlet extends HttpServlet{

	/**
	 * ���ҳ���Ajax����
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		QueryService queryService = new QueryService();
		//ʵ�ֵ��ǽ����ҵ������ݽ����������������ת
		out.write(queryService.autoReplyQuery(req.getParameter("content")));
		out.flush();
		out.close();
	}
}
