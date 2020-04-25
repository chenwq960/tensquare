package com.tensquare.search.pojo;

import java.io.Serializable;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @document : 一行记录 type : 属于那个类型 indexName 记录数据那个库
 * @author Administrator
 */
@Document(indexName = "articleindex", type = "article")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
	private String title;			//file 修饰的  该属性会呗保存到elsticsearch 库
									//index    属性会被索引
									//analyzer    		存入的时候ik分词器的什么分析器  来进行拆词  存入的时候 使用倒排索引
									//searchAnalyzer   输入的时候   随输入的搜索词用什么分析器查词
	
	private String state;

	@Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
	private String content;

	public Article() {
		super();
	}

	public Article(String id, String title, String state, String content) {
		super();
		this.id = id;
		this.title = title;
		this.state = state;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", state=" + state + ", content=" + content + "]";
	}

}