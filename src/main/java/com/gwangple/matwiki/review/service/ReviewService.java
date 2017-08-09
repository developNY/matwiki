package com.gwangple.matwiki.review.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gwangple.matwiki.review.dao.ReviewDao;
import com.gwangple.matwiki.review.dto.ReviewDTO;

@Service
public class ReviewService {
	
	@Inject
	ReviewDao reviewdao;
	
	public List<?> list_review(ReviewDTO reviewdto){
		return reviewdao.list_review(reviewdto);
	}
	
	public int save_review(ReviewDTO reviewdto){
		
		int resultval = 0;

		if(reviewdto.getMode().equals("I")){
			
			resultval= reviewdao.saveNew_review(reviewdto);
		    
		}else if((reviewdto.getMode().equals("U"))){
			
			resultval=reviewdao.saveUpd_review(reviewdto);
			
		}
		
		return resultval;
	}

}
