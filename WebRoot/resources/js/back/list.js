/**
 * �����ύ��DeleteBatchServlet
 * @param basePath
 */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatch.action");//������ʱ����Ŀ��action
	$("#mainForm").submit();//ʹ��JavaScript�����������ύ����
}