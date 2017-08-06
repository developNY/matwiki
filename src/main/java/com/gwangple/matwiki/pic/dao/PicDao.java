package com.gwangple.matwiki.pic.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gwangple.matwiki.common.dao.AbstDao;
import com.gwangple.matwiki.pic.dto.PicDto;

@Repository("PicDao")
public class PicDao extends AbstDao{
	
	/**
	 * 사진 추가
	 * @param picDto : 사진 DTO
	 */
	public void insertPic(PicDto picDto){
		this.insert("Pic.insertPic", picDto);
	}
	
	/**
	 * 사진 이력 추가
	 * @param picDto : 사진 DTO
	 */
	public void insertPicHistory(PicDto picDto){
		this.insert("Pic.insertPicHistory", picDto);
	}
	
	/**
	 * 사진 조회
	 * @param picSeq : 사진 번호
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> selectPic(String picSeq){
		return (Map<String, Object>) this.selectList("Pic.selectPic", picSeq);
	}
	
	/**
	 * 사진 삭제
	 * @param picSeq : 사진 번호 
	 */
	public void deletePic(String picSeq){
		this.delete("Pic.deletePic", picSeq);
	}
}
