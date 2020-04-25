package com.tensquare.search.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.tensquare.search.pojo.Article;

public interface ArticleRpository extends ElasticsearchRepository<Article,String>{//主键的 类型
		
	//搜索🔍 + 分页
	public Page<Article> findByTitleOrContent(String title,String content,Pageable pageable);
}
