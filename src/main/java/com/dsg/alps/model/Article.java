package com.dsg.alps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @class com.dsg.alps.model.Post
 * @description 文章model
 * 
 *              ------------ 字段较验的注解
 * @Null 被注释的元素必须为 null
 * @NotNull 被注释的元素必须不为 null
 * @AssertTrue 被注释的元素必须为 true
 * @AssertFalse 被注释的元素必须为 false
 * @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max, min) 被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction) 被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past 被注释的元素必须是一个过去的日期
 * @Future 被注释的元素必须是一个将来的日期
 * @Pattern(value) 被注释的元素必须符合指定的正则表达式hibernate对这个规范做了实现和扩展；
 * 
 * @Email 被注释的元素必须是电子邮箱地址
 * @Length 被注释的字符串的大小必须在指定的范围内
 * @NotEmpty 被注释的字符串的必须非空
 * @Range 被注释的元素必须在合适的范围内 ------------
 * 
 * -------
 * jpa @Column说明
 * name 可选,字段名(默认值是属性名) 
 * unique 可选,是否在该字段上设置唯一约束(默认值false) 
 * nullable 可选,是否设置该字段的值可以为空(默认值false) 
 * insertable 可选,该字段是否作为生成的insert语句中的一个字段(默认值true) 
 * updatable 可选,该字段是否作为生成的update语句中的一个字段(默认值true)
 * columnDefinition 可选: 为这个特定字段覆盖sql DDL片段 （这可能导致无法在不同数据库间移植）
 * table 可选,定义对应的表(默认为主表)
 * length 可选,字段长度(默认值255)
 * precision 可选,字段数字精精度(默认值0)
 * scale 可选,如果字段数字刻度可用,在此设置(默认值0)
 * -------
 * 
 * 
 * @author Simon.Cong(modoucc@gmail.com)
 * @date Mar 23, 2013 12:26:39 AM
 */
@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "标题不能为空")
	
	private String title; // 标题

	private String arthur; // 作者

	private String source; // 来源

	@Size(min = 2, message = "正文不能为空")
	private String content; // 正文

	@Column(columnDefinition="bigint default 0",nullable=false,insertable=false,updatable=false)
	private Long visit; // 访问次数

	@Column(name = "created_time",updatable=false)
	private Date createdTime;

	@Column(name = "updated_time")
	private Date updatedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArthur() {
		return arthur;
	}

	public void setArthur(String arthur) {
		this.arthur = arthur;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getVisit() {
		return visit;
	}

	public void setVisit(Long visit) {
		this.visit = visit;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

}
