package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;


/**
 *关于message数据表的操作
 */
public class MessageDAO {

	/**
	 * 批量删除信息
	 * @param paramList
	 */
	public void deleteBatch(List<Integer> paramList){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch",paramList);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	/**
	 * 删除单条信息
	 * @param id
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			//增删改的操作，最后要手动提交事务
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	/*
	 * 根据条件查询消息列表
	 */
	public List<Message> queryMessageList(String command,String description){
		List<Message> messageList = new ArrayList<Message>();
		/*
		 * ####版本V2.0 使用Mybatis代替JDBC来实现########
		 */
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			//拿到了数据库会话
			sqlSession = dbAccess.getSqlSession();
			//执行SQL语句查找数据
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);//因为动态传递参数只能传递一个，所以有多个参数需要传递时，需要进行封装成一个参数
			messageList = sqlSession.selectList("Message.queryMessageList",message);//在Message.xml配置文件中有唯一的SQL语句id
			//最后返回结果，在最后面
		} catch (IOException e) {
			e.printStackTrace();
		}finally{//正常执行完毕后要关闭sqlSession
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		/*
		 * ########V2.0 The End###############
		 */
		
//***********************************************************************************************
//***********************************************************************************************
		/*
		 * ####下面的是前版本V1.0，使用JDBC来完成####
		 * 
		 * try{
			
			 * JDBC执行数据库连接
			 
			Class.forName("com.mysql.jdbc.Driver");//获取到的参数容易出现中文乱码；也可以在JDBC连接时设置编码方式
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","scott","tiger");
			
			
			//使用String不断拼接新的字符串会产生很多资源垃圾，建议使用StringBuilder或StringBuffer（多线程）
			StringBuilder prepareSql = new StringBuilder("SELECT ID,COMMAND,DESCRIPTION,CONTENT FROM message WHERE 1=1"); //不要使用SELECT *，数据库引擎还要去解析列名，效率会低
			if(command != null && !"".equals(command.trim())){//如果传入的参数存在并且不为空字符串
				prepareSql.append(" AND COMMAND='"+command+"'");
			}
			if(description != null && !"".equals(description.trim())){
				prepareSql.append(" AND DESCRIPTION LIKE '%"+description+"%'");
			}
			//打印SQL语句
//			System.out.println("======="+prepareSql.toString()+"=======");
			//使用预编译SQL语句
			PreparedStatement state = conn.prepareStatement(prepareSql.toString());
			ResultSet results = state.executeQuery();
			while(results.next()){
				//新建了JavaBean类，将查找到的数据封装到JavaBean中
				Message message = new Message();
				message.setId(results.getInt("ID"));
				message.setCommand(results.getString("COMMAND"));
				message.setDescription(results.getString("DESCRIPTION"));
				message.setContent(results.getString("CONTENT"));
				
				messageList.add(message);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//以下三项均需要手动关闭
			conn.close();
			state.close();
			results.close();
		}
		#########V1.0 The End##############
		*/
		
		return messageList;//最外层返回，如果抛出异常，还可以返回空的结果
	}
}
