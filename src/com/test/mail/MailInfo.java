/**
 * MailInfo.java
 * 版权所有(C) 2015 北京智慧云享网络科技有限公司
 * 创建:刘彦亮 2015年5月27日
 */
package com.test.mail;



public class MailInfo {
	private String to;// 收件人
	private String cc;// 抄送人
	private String title;// 邮件的主题
	private String content;// 邮件的内容
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
