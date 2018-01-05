# MicroMessage_Mybatis
学习## Mybatis 基础版## 的  Demo。<br>
本Demo使用的案例是仿照微信公众号的部分功能实现信息的自动回复、后台数据管理（查询、删除）。<br>
【本Demo的版本V1.0中】<br>
①使用了JDBC来实现后台数据的查询（即查询某条指令对应的回复信息），在版本V2.0中使用Mybatis重构了该功能。<br>
【本Demo的版本V2.0中】<br>
①使用log4j来打印SQL语句，便于调试；<br>
②在JSP页面中使用JSTL、EL表达式处理数据获取问题；<br>
③在Mybatis的SQL操作配置XML文件中搭配使用OGNL获取传递到SQL中的参数。<br>
【案例预览】
