package com.tensquare.search.controller;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.AriticleService;

@RestController
@RequestMapping("/search")
//进行跨域处理
@CrossOrigin
public class AriticleController {
	@Resource
	private AriticleService ariticleService;
	
	@PostMapping("/add")
	public Result add(@RequestBody Article article) {
		ariticleService.add(article);
		return new Result(true,StatusCode.OK,"新增成功");
	}
	
	@GetMapping(value = "search/{key}/{page}/{size}")
	public PageResult<Article> findByTitleOrContent(@PathVariable String key,@PathVariable int page,@PathVariable int size){
		PageRequest request = PageRequest.of(page-1,size);
//		Page<Article> pages = ariticleService.findByTitleOrContent(key, key, page, size);
//		return new PageResult(pages.getTotalElements(),pages.getContent());
		Page<Article> pages = ariticleService.findByTitleOrContent(key,key,page,size);
		 
		 return new PageResult<Article>(pages.getTotalElements(),pages.getContent());
	}
	
}
