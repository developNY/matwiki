package com.gwangple.matwiki.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwangple.matwiki.review.dto.ReviewDTO;
import com.gwangple.matwiki.review.service.ReviewService;


/**
 * ReviewController  리뷰관련 ReviewController 클래스 입니다.
 * @author 이루지
 * @since 2017.08.09
 * @version 1.0
 * <pre>
 * 2017.08.09 : 최초 작성
 * </pre>
 */

@RequestMapping("/review")
@Controller
public class ReviewController {
	
	@Inject
	ReviewService reviewService;
	
 /**
	*  리뷰 리스트 조회
	*
	* @param ReviewDTO
	* @return 맛집별 리뷰 목록을 리턴한다.
	* @throws Exception이 발생 했을 경우 화면에 Exception을  리턴 한다.
	* 
	*/	
	@RequestMapping(value="/review001", method=RequestMethod.GET)
	public String load_review()throws Exception{
		
		return "review/review001";
	}
	
  /**
	*  리뷰 리스트 조회
	*
	* @param ReviewDTO
	* @return 맛집별 리뷰 목록을 리턴한다.
	* @throws Exception이 발생 했을 경우 화면에 Exception을  리턴 한다.
	* 
	*/
	@RequestMapping(value="/list_review", method=RequestMethod.POST)
	public @ResponseBody List<?> list_review(ReviewDTO reviewdto)throws Exception{
		
		return reviewService.list_review(reviewdto);
		
	}
	
  /**
	*  리뷰 저장
	*
	* @param ReviewDTO
	* @return 리뷰를 저장한다.
	* @throws Exception이 발생 했을 경우 화면에 Exception을  리턴 한다.
	* 
	*/
	@RequestMapping(value="/save_Review", method=RequestMethod.POST)
	public @ResponseBody Map<?,?> save_Review(ReviewDTO reviewdto)throws Exception{
		
		
		Map<String,String> map = new HashMap<String,String>();
		
		try{
			
			int resultVal=reviewService.save_review(reviewdto);
			
			if(resultVal>0){
				map.put("MSG", "SUCC");
			}
			map.put("MSG", "FAIL");
			
		}catch(Exception e){
			map.put("MSG", "FAIL");
		}
		
		return map;
		
	}

}
