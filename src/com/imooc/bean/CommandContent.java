package com.imooc.bean;

/**
 *��Ӧ�ӱ�command_content��Bean�� 
 *
 */
public class CommandContent {

	private int id;
	private String content;
	private int commandId;
	
	public CommandContent(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}
	
}
