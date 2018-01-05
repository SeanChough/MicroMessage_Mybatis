package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

/**
 *一对多查询commads的Servlet
 */
public class AutoReplyOneToMoreServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		QueryService queryService = new QueryService();
		PrintWriter out = resp.getWriter();
		String content = queryService.queryCommands(req.getParameter("command"), req.getParameter("description"));
		out.write(content);
		out.flush();
		out.close();
	}
}
