package com.dsg.alps.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dsg.alps.model.Article;

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
public class ArticleRepository {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @param offset
	 * @param pageSize
	 * @return
	 * @description TODO 该方法有问题，还得继续改善
	 * @author Simon.Cong(modoucc@gmail.com)
	 * @date Mar 24, 2013 4:20:31 AM
	 */
	public Page<Article> findArticlesByCondition(int offset, int pageSize) {
		List<Article> articles = findArticles(offset, pageSize);
		long total = getRecordCount();
		Pageable pageable = new PageRequest(offset / pageSize, pageSize,
				new Sort(Direction.DESC, "updatedTime"));
		Page<Article> page = new PageImpl<Article>(articles, pageable, total);
		return page;
	}

	private List<Article> findArticles(int offset, int pageSize) {
		StringBuffer queryString = new StringBuffer();
		queryString
				.append("select a from Article a order by a.createdTime desc");
		TypedQuery<Article> query = em.createQuery(queryString.toString(),
				Article.class);

		List<Article> articles = query.setFirstResult(offset)
				.setMaxResults(pageSize).getResultList();
		return articles;
	}

	private long getRecordCount() {
		StringBuffer queryString = new StringBuffer();
		queryString.append("select count(id) from article");
		Query query = em.createNativeQuery(queryString.toString());
		Object result = query.getSingleResult();
		long recordCount = 0L;
		if (result != null) {
			recordCount = ((Long) result).longValue();
		}
		return recordCount;
	}
}
