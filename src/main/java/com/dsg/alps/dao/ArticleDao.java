package com.dsg.alps.dao;

import org.springframework.data.repository.CrudRepository;

import com.dsg.alps.model.Article;

/**
 * 
 * @class com.dsg.alps.dao.ArticleDao
 * @description 文章的DAO
 *
 * @author Simon.Cong(modoucc@gmail.com)
 * @date Mar 23, 2013 12:30:12 AM
 */
public interface ArticleDao extends CrudRepository<Article, Long> {
	
}