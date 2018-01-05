package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

/**
 * 自动回复
 */
public class AutoReplyServlet extends HttpServlet{

	/**
	 * 针对页面的Ajax请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		QueryService queryService = new QueryService();
		//实现的是将查找到的数据进行输出，而不是跳转
		out.write(queryService.autoReplyQuery(req.getParameter("content")));
		out.flush();
		out.close();
	}
}
