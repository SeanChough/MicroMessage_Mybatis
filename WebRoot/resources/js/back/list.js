/**
 * 将表单提交到DeleteBatchServlet
 * @param basePath
 */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatch.action");//更改临时表单的目标action
	$("#mainForm").submit();//使用JavaScript方法出发表单提交动作
}