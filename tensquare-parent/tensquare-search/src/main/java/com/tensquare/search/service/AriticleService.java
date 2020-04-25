package com.tensquare.search.service;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tensquare.search.dao.ArticleRpository;
import com.tensquare.search.pojo.Article;

@Service
public class AriticleService {
	@Resource
	private ArticleRpository articleRepository;
	
	public void add(Article article) {
		//执行增加
		articleRepository.save(article);
	}
	
	public Page<Article> findByTitleOrContent(String title,String content,int page,int size){
		//page
		PageRequest request = PageRequest.of(page-1, size);
		return articleRepository.findByTitleOrContent(title, content, request);
	}
	

}	
