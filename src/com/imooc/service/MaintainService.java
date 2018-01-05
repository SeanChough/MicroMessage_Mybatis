package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDAO;

/**
 * 对数据维护操作（增删改）的控制层
 * @author micro
 * 
 */
public class MaintainService {

	/**
	 * 批量删除信息
	 * @param paramList
	 */
	public void deleteBatch(String[] ids){
		if(ids != null && ids.length>0){
			MessageDAO messageDao = new MessageDAO();
			//Service这里进行了数据的类型转换处理
			List<Integer> paramList = new ArrayList<Integer>(); 
			for (String string : ids) {
				paramList.add(Integer.parseInt(string));
			}
			messageDao.deleteBatch(paramList);
		}
	}
	/**
	 * 调用DAO层：删除单条信息，同时实现业务处理
	 * @param id
	 */
	public void deleteOne(String id){
		//Service层主要实现业务处理，这里很简单的例子就是对参数类型进行了转换
		if(id != null && !"".equals(id.trim())){
			MessageDAO messageDao = new MessageDAO();
			messageDao.deleteOne(Integer.valueOf(id));//将String型转化为int型
		}
	}
}
