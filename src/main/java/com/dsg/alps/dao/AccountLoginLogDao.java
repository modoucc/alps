package com.dsg.alps.dao;

import org.springframework.data.repository.CrudRepository;

import com.dsg.alps.model.AccountLoginLog;

/**
 * 
 * @class com.dsg.alps.dao.jpa.AccountLoginLogDao
 * @description 用户登录日志DAO
 *
 * @author Simon.Cong(modoucc@gmail.com)
 * @date 2013-3-13 上午12:41:12
 */
public interface AccountLoginLogDao extends CrudRepository<AccountLoginLog, Long> {

}