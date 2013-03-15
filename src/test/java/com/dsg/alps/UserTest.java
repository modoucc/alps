/**
 * BaseTest.java
 * com.dsg.dnf
 * Function： TODO 
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.dsg.alps;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.dsg.alps.model.Account;
import com.dsg.alps.service.AccountRepository;
import com.dsg.alps.service.AccountService;
import com.dsg.alps.util.Digest;

/**
 * 
 * @class com.dsg.alps.UserTest
 * @description 不含事务的test,执行的sql语句在test方法执行结束后不会回滚
 * 
 * @author Simon.Cong(modoucc@gmail.com)
 * @date 2013-3-15 上午12:12:53
 */
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRepository accountRepository;

	private String passport = "deby";

	@Test
	public void addUsers() throws Exception {

		Account account = new Account();
		// String passport = "test";
		account.setPassport(passport);

		String passwd_hac = Digest.SHA1("121");
		account.setPasswdHac(passwd_hac);

		account.setNickName(passport);
		account.setEmail(passport + "@163.com");
		account.setMobile("18612341234");
		Date date = new Date();
		account.setCreatedTime(date);
		account.setUpdatedTime(date);
		account.setLastLoginTime(date);
		accountService.signup(account, "192.168.1.1");

	}

	@Test
	public void findUserByPassport() throws Exception {
		Account account = accountRepository.findAccountByPassport(passport);
		assertEquals(account.getPassport(), passport);
	}
}
