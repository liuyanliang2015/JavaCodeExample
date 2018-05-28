package com.test.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;



public class SendMailUtils {
	public static void sendMailToAndCC(MailInfo mailInfo) {
		Properties props = System.getProperties();
		String host = "smtp.exmail.qq.com";
		// 设置邮件服务器的域名或IP
		props.put("mail.smtp.host", host);
		// 授权邮件,mail.smtp.auth必须设置为true
		props.put("mail.smtp.auth", "true");
		props.put("mail.transport.protocol", "smtp");
		// 发送人账号
		String username = "xxxxxxxx@qq.com";
		// 发送人密码
		String password = "xxxxxxx";
		// 发送人邮件地址
		String from = username;
		
		
		try {
			// 如果密码经过加密用此方法对密码进行解密
			password = Encrypt.DoDecrypt(password);
		} catch (NumberFormatException e1) {
			// 如果密码未经过加密,则对密码不做任何处理
		}
		// 传入发件人的用户名和密码,构造MyAuthenticator对象
		MyAuthenticator myauth = new MyAuthenticator(username, password);
		// 传入props、myauth对象,构造邮件授权的session对象
		Session session = Session.getDefaultInstance(props, myauth);
//		session.setDebug(true);//是否在控制台显示debug信息
		// 将Session对象作为MimeMessage构造方法的参数传入构造message对象
		MimeMessage message = new MimeMessage(session);
		try {
			// 发件人邮件地址
			message.setFrom(new InternetAddress(from));
			// 对多个收件人的情况进行处理,配置文件SendMail.xml中每个收件人之间必须用逗号隔开的
			if (mailInfo.getTo() != null && !"".equals(mailInfo.getTo())) {
				String to[] = mailInfo.getTo().split(",");
				for (int i = 0; i < to.length; i++) {
					message.addRecipient(Message.RecipientType.TO,
							new InternetAddress(to[i]));// 收件人
				}
			}
			// 对多个抄送人的情况进行处理,每个抄送人之间用逗号隔开的
			if (mailInfo.getCc() != null && !"".equals(mailInfo.getCc())) {
				String cc[] = mailInfo.getCc().split(",");
				for (int j = 0; j < cc.length; j++) {
					message.addRecipient(Message.RecipientType.CC,
							new InternetAddress(cc[j]));// 抄送
				}
			}
			
			message.setSubject(MimeUtility.encodeText(mailInfo.getTitle(),"gb2312","B"));
			//内容
			message.setContent(mailInfo.getContent(), "text/html;charset=gb2312");
//			Transport.send(message, message.getAllRecipients());
			Transport transport = session.getTransport("smtp");
	        transport.connect(host, from, password);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	/***
	 * 为了方便直接用main方法测试
	 * 
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public static void main(String args[]) throws Exception {
		SendMailUtils mail = new SendMailUtils();
		MailInfo info = new MailInfo();
		info.setTitle("javaMailTest");
		StringBuffer content = new StringBuffer();
		  content.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")  
	        .append("<html>")  
	        .append("<head>")  
	        .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")  
	        .append("<title>活动报名</title>")  
	        .append("<style type=\"text/css\">")  
	        .append(".test{font-family:\"Microsoft Yahei\";font-size: 18px;color: red;}")  
	        .append("</style>")  
	        .append("</head>")  
	        .append("<body>")  
	        .append("<table border=1>")  
			.append("<tr>")
			.append("<td width=232><span>学校名称:</span>English</td>")
			.append("<td colspan=2><span>学校地址:</span>US</td>")
			.append("</tr>")
			.append("</table>") 
	        .append("</body>")  
	        .append("</html>"); 
	        content.toString();
		
		
		
		info.setContent(content.toString());
		info.setTo("185650123@qq.com,1306161717@qq.com");
		info.setCc("1059472075@qq.com");
		// mail.sendMailTo(info);
		mail.sendMailToAndCC(info);

	}
}
