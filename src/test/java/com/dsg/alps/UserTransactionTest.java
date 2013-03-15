package com.dsg.alps;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.dsg.alps.model.Account;
import com.dsg.alps.service.AccountService;
import com.dsg.alps.util.Digest;

/**
 * 
 * @class com.dsg.alps.UserTransactionTest
 * @description 包含事务的test，执行的sql语句在执行结束后都会回滚,存储引擎为innoDB时有效
 * 
 * @author Simon.Cong(modoucc@gmail.com)
 * @date 2013-3-14 下午9:55:12
 */
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTransactionTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private AccountService accountService;
	
	private String passport = "simon";

	@Test
	public void addUsers() throws Exception {

		Account account = new Account();
		// String passport = "test";
		account.setPassport(passport);

		String passwd_hac = Digest.SHA1("121");
		account.setPasswdHac(passwd_hac);

		account.setNickName(passport);
		account.setEmail(passport + "@163.com");
		account.setMobile("18612342234");
		Date date = new Date();
		account.setCreatedTime(date);
		account.setUpdatedTime(date);
		account.setLastLoginTime(date);
		accountService.signup(account, "192.168.1.1");

	}

	// @Test
	// public void modifyUsers() throws Exception {
	// Account account = accountDao.findByPassport(passport);
	// account.setNickName("噬月墨斗");
	// accountDao.saveAndFlush(account);
	// Account account2 = accountDao.findByNickName("噬月墨斗");
	// Assert.assertEquals(account2.getPassport(), passport);
	// }
	//
	// @After
	// public void deleteUsers() throws Exception {
	// Account account = accountDao.findByPassport(passport);
	// accountDao.delete(account);
	// accountDao.flush();
	// }

}
