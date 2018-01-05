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
 *�Ͳ�ѯ��ص�ҵ���
 */
public class QueryService {

	/**
	 * һ�Զ��ѯcommands���Զ��ظ�ʹ��
	 * @param command
	 * @param description
	 * @return
	 */
	public String queryCommands(String command,String description){
		CommandsDAO commandsDao = new CommandsDAO();
		//description is null
		List<Commands> commandsList = commandsDao.queryCommands(command, description);
		List<CommandContent> contentList = commandsList.get(0).getCommandContent();
//		double i = Math.random();//��������������ȡ��һ��content�������ظ����ʽϸ�
		int i = new Random().nextInt(contentList.size());//Ҳ�����������������
		String content = contentList.get(i).getContent();
		return content;
	}
	
	/**
	 * ����DAO��ķ�������ȡ�鵽�����ݷ��ظ�Servlet��
	 */
	public List<Message> queryMessageList(String command,String description){
		MessageDAO messageDao = new MessageDAO();
		return messageDao.queryMessageList(command, description);
	}
	
	/**
	 * �Զ��ظ��Ĳ�ѯ��������DAO���ѯ������Ϣ�ķ���queryMessageList
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
				s.append("�ظ���"+queryList.get(i).getCommand()+"�����Բ鿴��"+queryList.get(i).getDescription()+"��");
				if(i != 0)
					s.append("<br/>");
			}
			return s.toString();
		}
		//�ڶ����������Ϊnull����ô��Message.xml�ļ��оͲ���ƴ���������
		queryList = messageDao.queryMessageList(queryCommand,null);
		if(queryList.size()>0){
			return queryList.get(0).getContent();
		}
		else{
			return Iconst.NO_MATCH_MESSAGE;
		}
	}
}
