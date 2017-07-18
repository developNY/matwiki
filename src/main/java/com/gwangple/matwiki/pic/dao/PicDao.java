package com.gwangple.matwiki.pic.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gwangple.matwiki.common.dao.AbstDao;
import com.gwangple.matwiki.pic.dto.PicDto;

@Repository("PicDao")
public class PicDao extends AbstDao{
	
	/**
	 * ���� �߰�
	 * @param picDto : ���� DTO
	 */
	public void insertPic(PicDto picDto){
		this.insert("Pic.insertPic", picDto);
	}
	
	/**
	 * ���� �̷� �߰�
	 * @param picDto : ���� DTO
	 */
	public void insertPicHistory(PicDto picDto){
		this.insert("Pic.insertPicHistory", picDto);
	}
	
	/**
	 * ���� ��ȸ
	 * @param picSeq : ���� ��ȣ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> selectPic(String picSeq){
		return (Map<String, Object>) this.selectList("Pic.selectPic", picSeq);
	}
	
	/**
	 * ���� ����
	 * @param picSeq : ���� ��ȣ 
	 */
	public void deletePic(String picSeq){
		this.delete("Pic.deletePic", picSeq);
	}
}
