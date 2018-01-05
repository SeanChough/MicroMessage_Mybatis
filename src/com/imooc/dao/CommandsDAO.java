package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Commands;
import com.imooc.db.DBAccess;

/**
 * һ�Զ�Ĳ�ѯcommands
 * �ࣺCommandsContent.java,Commands.java
 * SQL�����ļ���CommandsContent.xml,Commands.xml
 * ���ݱ�commands�������� command_content���ӱ�
 */
public class CommandsDAO {

	public List<Commands> queryCommands(String command,String description){
		DBAccess dbAccess = new DBAccess();
		Commands commands = new Commands();
		SqlSession sqlSession = null;
		List<Commands> commandsList =  new ArrayList<Commands>();
		commands.setCommand(command);
		commands.setDescription(description);
		try {
			sqlSession = dbAccess.getSqlSession();
			commandsList = sqlSession.selectList("Commands.queryCommandsList", commands);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return commandsList;
	}
}
