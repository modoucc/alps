package com.dsg.alps.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dsg.alps.dao.ArticleDao;
import com.dsg.alps.model.Article;
import com.dsg.alps.util.SystemConstant;

@Service
// 设置默认的事务管理策略，即没有标注@Transactional的方法的事务处理方式，意思为不要求方法必须在一个事务中运行
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
/**
 * 
 * @class com.dsg.alps.service.ArticleService
 * @description 文章的service层
 *
 * @author Simon.Cong(modoucc@gmail.com)
 * @date Mar 23, 2013 12:32:44 AM
 */
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;

	/**
	 * 
	 * @param article
	 * @return
	 * @description 创建文章，并更新创建时间和上一次更新时间
	 * @author Simon.Cong(modoucc@gmail.com)
	 * @date Mar 23, 2013 12:39:22 AM
	 */
	@Transactional(readOnly = false)
	// 这里重新定义该方法的事务策略
	public Article create(Article article) {
		article.setCreatedTime(new Date());
		article.setUpdatedTime(new Date());
		Article pArticle = articleDao.save(article);
		return pArticle;

	}

	/**
	 * 
	 * @param article
	 * @return
	 * @description 更新文章内容，并更新上一次更新时间
	 * @author Simon.Cong(modoucc@gmail.com)
	 * @date Mar 23, 2013 4:28:44 PM
	 */
	@Transactional(readOnly = false)
	public Article update(Article article) {
		article.setUpdatedTime(new Date());
		Article pArticle = articleDao.save(article);
		return pArticle;
	}

	/**
	 * 
	 * @param articleId
	 * @return
	 * @description 根据ID查找文章
	 * @author Simon.Cong(modoucc@gmail.com)
	 * @date Mar 23, 2013 4:29:43 PM
	 */
	public Article findOne(Long articleId) {
		return articleDao.findOne(articleId);
	}

	/**
	 * 
	 * @return
	 * @description 查看所有的文章，不分页
	 * @author Simon.Cong(modoucc@gmail.com)
	 * @date Mar 23, 2013 12:39:39 AM
	 */
	public List<Article> findAll() {
		return (List<Article>) articleDao.findAll();
	}

	/**
	 * 
	 * @param offset
	 * @param pageSize
	 * @return
	 * @description 不带任何查询条件的分页
	 * @author Simon.Cong(modoucc@gmail.com)
	 * @date Mar 24, 2013 2:01:14 AM
	 */
	public Page<Article> findArticles(int offset, int pageSize) {
		Pageable pagealbe = new PageRequest(offset/pageSize, pageSize);
		return articleDao.findAll(pagealbe);
	}

	/**
	 * 
	 * @param offset
	 * @return
	 * @description 不带任何查询条件的分页，采用page中定义的每页条数
	 * @author Simon.Cong(modoucc@gmail.com)
	 * @date Mar 24, 2013 2:01:32 AM
	 */
	public Page<Article> findArticles(int offset) {
		return findArticles(offset, SystemConstant.SIZE_PER_PAGE);
	}
}
