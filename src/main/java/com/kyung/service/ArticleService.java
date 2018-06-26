package com.kyung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.dto.Article;
import com.kyung.mapper.ArticleMapper;
import com.kyung.model.ArticleRegistrationModel;

@Service
public class ArticleService {
	@Autowired ArticleMapper articleMapper;

	public void create(int boardId, int userId, ArticleRegistrationModel articleModel)
	{
		String title = articleModel.getTitle();
		String contents = articleModel.getContents();
		int category = articleModel.getCategory();
		articleMapper.insert(boardId, userId, title, contents, category);
	}

	public Article findOne(int boardId, int articleId)
	{
		Article article = new Article();
		article = articleMapper.findOne(boardId, articleId);
		return article;
	}

	public void edit(int articleId, ArticleRegistrationModel articleModel){
		String title = articleModel.getTitle();
		String contents = articleModel.getContents();
		int category = articleModel.getCategory();
		articleMapper.update(articleId, title, contents, category);
	}

	public void delete(int articleId){
		articleMapper.delete(articleId);
	}

	public List<Article> findNotice(){
		return articleMapper.findNotice();
	}
}
