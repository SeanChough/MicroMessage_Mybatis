package com.imooc.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *�������ݿ���
 */
public class DBAccess {

	/**
	 * ��ȡSqlSession�����ݿ�Ự
	 * @return SqlSession
	 * @throws IOException
	 */
	public SqlSession getSqlSession() throws IOException{//���ܵ��쳣�����׸�DAO�㣬DAO�㽫�Ჶ���쳣����finally�����йر�SqlSession
		//ͨ��������Ϣ��ȡ���ݿ����������Ϣ
		Reader reader = Resources.getResourceAsReader("com/imooc/config/Configuration.xml");//ע��·��
		//ͨ�����ݿ����������Ϣ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//ͨ��SqlSessionFactory�����ݿ�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
}
