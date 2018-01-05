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
 *����message���ݱ�Ĳ���
 */
public class MessageDAO {

	/**
	 * ����ɾ����Ϣ
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
	 * ɾ��������Ϣ
	 * @param id
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			//��ɾ�ĵĲ��������Ҫ�ֶ��ύ����
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	/*
	 * ����������ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageList(String command,String description){
		List<Message> messageList = new ArrayList<Message>();
		/*
		 * ####�汾V2.0 ʹ��Mybatis����JDBC��ʵ��########
		 */
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			//�õ������ݿ�Ự
			sqlSession = dbAccess.getSqlSession();
			//ִ��SQL����������
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);//��Ϊ��̬���ݲ���ֻ�ܴ���һ���������ж��������Ҫ����ʱ����Ҫ���з�װ��һ������
			messageList = sqlSession.selectList("Message.queryMessageList",message);//��Message.xml�����ļ�����Ψһ��SQL���id
			//��󷵻ؽ�����������
		} catch (IOException e) {
			e.printStackTrace();
		}finally{//����ִ����Ϻ�Ҫ�ر�sqlSession
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
		 * ####�������ǰ�汾V1.0��ʹ��JDBC�����####
		 * 
		 * try{
			
			 * JDBCִ�����ݿ�����
			 
			Class.forName("com.mysql.jdbc.Driver");//��ȡ���Ĳ������׳����������룻Ҳ������JDBC����ʱ���ñ��뷽ʽ
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","scott","tiger");
			
			
			//ʹ��String����ƴ���µ��ַ���������ܶ���Դ����������ʹ��StringBuilder��StringBuffer�����̣߳�
			StringBuilder prepareSql = new StringBuilder("SELECT ID,COMMAND,DESCRIPTION,CONTENT FROM message WHERE 1=1"); //��Ҫʹ��SELECT *�����ݿ����滹Ҫȥ����������Ч�ʻ��
			if(command != null && !"".equals(command.trim())){//�������Ĳ������ڲ��Ҳ�Ϊ���ַ���
				prepareSql.append(" AND COMMAND='"+command+"'");
			}
			if(description != null && !"".equals(description.trim())){
				prepareSql.append(" AND DESCRIPTION LIKE '%"+description+"%'");
			}
			//��ӡSQL���
//			System.out.println("======="+prepareSql.toString()+"=======");
			//ʹ��Ԥ����SQL���
			PreparedStatement state = conn.prepareStatement(prepareSql.toString());
			ResultSet results = state.executeQuery();
			while(results.next()){
				//�½���JavaBean�࣬�����ҵ������ݷ�װ��JavaBean��
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
			//�����������Ҫ�ֶ��ر�
			conn.close();
			state.close();
			results.close();
		}
		#########V1.0 The End##############
		*/
		
		return messageList;//����㷵�أ�����׳��쳣�������Է��ؿյĽ��
	}
}
