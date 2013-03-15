package com.dsg.alps.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dsg.alps.model.Account;

/**
 * 
 * @class com.dsg.alps.dao.jpa.AccountDao
 * @description 用户基本信息DAO
 * 
 * @author Simon.Cong(modoucc@gmail.com)
 * @date 2013-3-13 上午12:40:22
 */
public interface AccountDao extends CrudRepository<Account, Long> {
	
	@Modifying
	@Query("update User u set u.mobile = ?1 where u.passport = ?2") 
	int modifyMobileByPassport(String Mobile, String passport);

	Account findByPassport(String passport);

	Account findByNickName(String nickName);

	List<Account> findByMobile(String mobile);

	List<Account> findByEmail(String email);

	Page<Account> findByMobile(String mobile, Pageable pageable);

}