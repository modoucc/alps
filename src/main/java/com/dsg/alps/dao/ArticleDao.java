package com.dsg.alps.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.dsg.alps.model.Article;

/**
 * 
 * @class com.dsg.alps.dao.ArticleDao
 * @description 文章的DAO
 * 
 * ------
 * And --- 等价于 SQL 中的 and 关键字，比如 findByUsernameAndPassword(String user, Striang pwd)；
 * Or --- 等价于 SQL 中的 or 关键字，比如 findByUsernameOrAddress(String user, String addr)；
 * Between --- 等价于 SQL 中的 between 关键字，比如 findBySalaryBetween(int max, int min)；
 * LessThan --- 等价于 SQL 中的 "<"，比如 findBySalaryLessThan(int max)；
 * GreaterThan --- 等价于 SQL 中的">"，比如 findBySalaryGreaterThan(int min)；
 * IsNull --- 等价于 SQL 中的 "is null"，比如 findByUsernameIsNull()；
 * IsNotNull --- 等价于 SQL 中的 "is not null"，比如 findByUsernameIsNotNull()；
 * NotNull --- 与 IsNotNull 等价；
 * Like --- 等价于 SQL 中的 "like"，比如 findByUsernameLike(String user)；
 * NotLike --- 等价于 SQL 中的 "not like"，比如 findByUsernameNotLike(String user)；
 * OrderBy --- 等价于 SQL 中的 "order by"，比如 findByUsernameOrderBySalaryAsc(String user)；
 * Not --- 等价于 SQL 中的 "！ ="，比如 findByUsernameNot(String user)；
 * In --- 等价于 SQL 中的 "in"，比如 findByUsernameIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；
 * NotIn --- 等价于 SQL 中的 "not in"，比如 findByUsernameNotIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；
 * ---------
 *
 * @author Simon.Cong(modoucc@gmail.com)
 * @date Mar 23, 2013 12:30:12 AM
 */
public interface ArticleDao extends CrudRepository<Article, Long> {
	
	public Page<Article> findAll(Pageable pageable);

}