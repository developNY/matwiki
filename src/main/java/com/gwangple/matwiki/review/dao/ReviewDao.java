package com.gwangple.matwiki.review.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gwangple.matwiki.review.dto.ReviewDTO;

@Repository
public class ReviewDao{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "review";
	
	public List<?> list_review(ReviewDTO reviewdto){
		
		return session.selectList(namespace+"list_review",reviewdto);
		
	}
	
	public int saveNew_review(ReviewDTO reviewdto){
		
		return session.insert(namespace+"saveNew_review",reviewdto);
	}
	
	public int saveUpd_review(ReviewDTO reviewdto){
		
		return session.update(namespace+"saveUpd_review",reviewdto);
	}

}
