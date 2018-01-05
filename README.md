# MicroMessage_Mybatis
### 介绍<br>
本Demo使用的案例是仿照微信公众号的部分功能实现信息的自动回复。<br>
### 详细功能<br>
①后台管理：查询后台数据（指令和对应的回复内容）；<br>
②后台管理：删除和批量删除数据；<br>
③后台管理：使用关键字查找指令和描述；<br>
④自动回复：一对一的信息回复>>>指令和回复内容是唯一对应关系，存储在同一张数据表中进行查询；<br>
⑤自动回复：一对多的信息回复>>>新建专门的存储指令和存储回复内容的两张表，使用连接查询获取一条指令对应多个回复内容，并随机取一个返回到聊天界面中。<br>
### 本Demo的版本V1.0中<br>
①使用了JDBC来实现后台数据的查询（即查询某条指令对应的回复信息），在版本V2.0中使用Mybatis重构了该功能。<br>
### 本Demo的版本V2.0中<br>
①使用log4j来打印SQL语句，便于调试；<br>
②在JSP页面中使用JSTL、EL表达式处理数据获取问题；<br>
③在Mybatis的SQL操作配置XML文件中搭配使用OGNL获取传递到SQL中的参数。<br>
### 案例预览<br>
![](https://github.com/SeanChough/MicroMessage_Mybatis/blob/master/Mybatis1.png) <br> 
▲查询后台数据（指令和对应的回复内容）/删除和批量删除数据<br>
![](https://github.com/SeanChough/MicroMessage_Mybatis/blob/master/%E6%A3%80%E7%B4%A2.png)<br> 
▲使用关键字模糊检索<br>
![](https://github.com/SeanChough/MicroMessage_Mybatis/blob/master/%E8%87%AA%E5%8A%A8%E5%9B%9E%E5%A4%8D.png)<br>
▲仿照微信公众好的信息自动回复<br>
![](https://github.com/SeanChough/MicroMessage_Mybatis/blob/master/%E4%B8%80%E5%AF%B9%E5%A4%9A%E7%9A%84%E5%9B%9E%E5%A4%8D.png)<br>
▲一对多的信息自动回复（统一指令随机有不同的回复内容）
