/**
 * MyAuthenticator.java
 * 鐗堟潈鎵�湁(C) 2015 鍖椾含鏅烘収浜戜韩缃戠粶绉戞妧鏈夐檺鍏徃
 * 鍒涘缓:鍒樺溅浜�2015骞�鏈�7鏃�
 */
package com.test.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator  {
    private String strUser;
    private String strPwd;
    public MyAuthenticator(String user, String password) {
    	this.strUser = user;
    	this.strPwd = password;
    }
    protected PasswordAuthentication getPasswordAuthentication() {
    	return new PasswordAuthentication(strUser, strPwd);
    }
}
