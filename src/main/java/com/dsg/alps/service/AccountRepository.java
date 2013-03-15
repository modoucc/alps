package com.dsg.alps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dsg.alps.model.Account;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
/**
 * 
 * @class com.dsg.alps.service.AccountRepository
 * @description 这是直接使用EntityManager的例子，在service层直接操作sql语句,不使用dao层
 *
 * @author Simon.Cong(modoucc@gmail.com)
 * @date 2013-3-15 上午9:18:40
 */
public class AccountRepository {

	@PersistenceContext
	private EntityManager em;

	public Account findAccountByPassport(String passport) {
		TypedQuery<Account> query = em.createQuery(
				"select a from Account a where a.passport = ?1", Account.class);
		query.setParameter(1, passport);
		// java.util.List<X> getResultList()
		// 返回一个list<X>结果集
		// X getSingleResult()
		// 返回一个X对象结果
		return query.getSingleResult();
	}
}
