package com.imooc.bean;
//在实践中不断加深知识的认知，以及通过对问题的思考发现更深层次的东西
//--sean_chou

/**
 *JavaBean
 *与数据库中的message数据表相对应的实体类
 */
public class Message {

	private int id;
	private String command;
	private String description;
	private String content;
	
	public Message(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
