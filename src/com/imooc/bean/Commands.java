package com.imooc.bean;

import java.util.List;
/**
 * 对应父表commands的Bean类
 *
 */
public class Commands {

	private int id;
	private String command;
	private String description;
	private List<CommandContent> commandContent;
	
	public Commands(){
		
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

	public List<CommandContent> getCommandContent() {
		return commandContent;
	}

	public void setCommandContent(List<CommandContent> commandContent) {
		this.commandContent = commandContent;
	}
	
	
}
