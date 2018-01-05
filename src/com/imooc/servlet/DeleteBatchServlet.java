package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

public class DeleteBatchServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String[] ids = req.getParameterValues("ids");
		MaintainService maintainService = new MaintainService();
		maintainService.deleteBatch(ids);
		
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
}
