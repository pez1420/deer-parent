package com.longlydeer.deer.portal.entity;

import com.longlydeer.deer.common.annotation.EntityInfo;
import com.longlydeer.deer.common.annotation.Meaning;
import com.longlydeer.deer.common.entity.BaseEntity;

@EntityInfo("日志")
public class Log extends BaseEntity{
	
	private static final long serialVersionUID = -2211077559972187773L;
	public static final String LOG_CONTENT_ATTRIBUTE_NAME = Log.class.getName() + ".CONTENT";

	@Meaning("操作:增删改查")
	private String operation;
	@Meaning("操作者")
	private String operator;
	@Meaning("操作内容")
	private String content;
	@Meaning("参数信息")
	private String parameter;
	@Meaning("操作者IP")
	private String ip;
	
	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getParameter() {
		return parameter;
	}
	
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}

	
	  
}
