package com.imooc.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *访问数据库类
 */
public class DBAccess {

	/**
	 * 获取SqlSession：数据库会话
	 * @return SqlSession
	 * @throws IOException
	 */
	public SqlSession getSqlSession() throws IOException{//可能的异常向上抛给DAO层，DAO层将会捕获异常并在finally语句块中关闭SqlSession
		//通过配置信息获取数据库连接相关信息
		Reader reader = Resources.getResourceAsReader("com/imooc/config/Configuration.xml");//注意路径
		//通过数据库连接相关信息创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//通过SqlSessionFactory打开数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
}
