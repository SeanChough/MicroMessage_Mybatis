package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDAO;

/**
 * ������ά����������ɾ�ģ��Ŀ��Ʋ�
 * @author micro
 * 
 */
public class MaintainService {

	/**
	 * ����ɾ����Ϣ
	 * @param paramList
	 */
	public void deleteBatch(String[] ids){
		if(ids != null && ids.length>0){
			MessageDAO messageDao = new MessageDAO();
			//Service������������ݵ�����ת������
			List<Integer> paramList = new ArrayList<Integer>(); 
			for (String string : ids) {
				paramList.add(Integer.parseInt(string));
			}
			messageDao.deleteBatch(paramList);
		}
	}
	/**
	 * ����DAO�㣺ɾ��������Ϣ��ͬʱʵ��ҵ����
	 * @param id
	 */
	public void deleteOne(String id){
		//Service����Ҫʵ��ҵ��������ܼ򵥵����Ӿ��ǶԲ������ͽ�����ת��
		if(id != null && !"".equals(id.trim())){
			MessageDAO messageDao = new MessageDAO();
			messageDao.deleteOne(Integer.valueOf(id));//��String��ת��Ϊint��
		}
	}
}
