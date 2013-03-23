package com.dsg.alps.util;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: Page
 * @Description:
 * @author proteus modoucc_gmail_com
 * @date 2011-7-28 下午6:43:19
 * 
 */
@SuppressWarnings("serial")
public class Page<T> implements Serializable {

	public static int SIZE_PER_PAGE = 15;

	private int pageSize = SIZE_PER_PAGE;

	private List<T> content; // 当前页中存放的记录,类型一般为List

	private long size; // 总记录数

	public static int getSIZE_PER_PAGE() {
		return SIZE_PER_PAGE;
	}

	public static void setSIZE_PER_PAGE(int sIZE_PER_PAGE) {
		SIZE_PER_PAGE = sIZE_PER_PAGE;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	
}