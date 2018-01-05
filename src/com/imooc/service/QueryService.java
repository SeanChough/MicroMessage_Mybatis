package com.imooc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.border.MatteBorder;

import org.apache.log4j.Logger;

import com.imooc.bean.CommandContent;
import com.imooc.bean.Commands;
import com.imooc.bean.Message;
import com.imooc.dao.CommandsDAO;
import com.imooc.dao.MessageDAO;
import com.imooc.util.Iconst;


/**
 *和查询相关的业务层
 */
public class QueryService {

	/**
	 * 一对多查询commands：自动回复使用
	 * @param command
	 * @param description
	 * @return
	 */
	public String queryCommands(String command,String description){
		CommandsDAO commandsDao = new CommandsDAO();
		//description is null
		List<Commands> commandsList = commandsDao.queryCommands(command, description);
		List<CommandContent> contentList = commandsList.get(0).getCommandContent();
//		double i = Math.random();//生成随机数来随机取得一个content，但是重复概率较高
		int i = new Random().nextInt(contentList.size());//也可以这样生成随机数
		String content = contentList.get(i).getContent();
		return content;
	}
	
	/**
	 * 调用DAO层的方法并获取查到的数据返回给Servlet层
	 */
	public List<Message> queryMessageList(String command,String description){
		MessageDAO messageDao = new MessageDAO();
		return messageDao.queryMessageList(command, description);
	}
	
	/**
	 * 自动回复的查询，利用了DAO层查询所有信息的方法queryMessageList
	 * @param queryCommand
	 * @return String
	 */
	public String autoReplyQuery(String queryCommand){
		MessageDAO messageDao = new MessageDAO();
		List<Message> queryList = new ArrayList<Message>();
		if(Iconst.HELP_COMMAND.equals(queryCommand)){
			StringBuilder s = new StringBuilder();
			queryList = messageDao.queryMessageList(null, null);
			for(int i=0;i<queryList.size();i++){
				s.append("回复【"+queryList.get(i).getCommand()+"】可以查看【"+queryList.get(i).getDescription()+"】");
				if(i != 0)
					s.append("<br/>");
			}
			return s.toString();
		}
		//第二个参数如果为null，那么在Message.xml文件中就不会拼接这个参数
		queryList = messageDao.queryMessageList(queryCommand,null);
		if(queryList.size()>0){
			return queryList.get(0).getContent();
		}
		else{
			return Iconst.NO_MATCH_MESSAGE;
		}
	}
}
