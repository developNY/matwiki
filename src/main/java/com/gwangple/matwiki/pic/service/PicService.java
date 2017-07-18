package com.gwangple.matwiki.pic.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gwangple.matwiki.pic.dao.PicDao;
import com.gwangple.matwiki.pic.dto.PicDto;

/**
 * 사진 service
 * @author sukhwan
 *
 */
@Service("PicService")
public class PicService {

	@Autowired
	PicDao picDao;
	
	// 이미지 경로
	String imgPath = "";
	
	/** 
	 * 사진 저장
	 * @param picDto : 사진 정보
	 * @param image  : 사진 파일
	 * @throws IOException 
	 */
	public void insertPic(PicDto picDto,MultipartFile image) throws IOException{
		// 사진 서버에 저장
        savePic(picDto, image);
        
        
        picDao.insertPic(picDto);
        picDao.insertPicHistory(picDto);
	}
	
	/**
	 * 사진 서버에 저장 
	 * @param image : 사진 파일
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public void savePic(PicDto picDto,MultipartFile image) throws IOException{
		FileOutputStream fos;
		
		byte fileData[] = image.getBytes();
        
		String path = imgPath + "\\" + UUID.randomUUID().toString();
        
		fos = new FileOutputStream(path);
        fos.write(fileData);
        
        // 파일 경로 수정
        picDto.setPicPath(path);
	}
	
	/**
	 * 썸네일 만들기
	 * @param picDto
	 * @param path
	 */
	public void saveThumb(PicDto picDto){
		
	}
	
	/**
	 * 사진 삭제
	 * @param picSeq : 사진번호
	 */
	public void deleteImage(String picSeq){
		// 사진 정보 조회
		Map<String,Object> pic = picDao.selectPic(picSeq);
		
		// 서버에서 파일 삭제
		File file = new File(pic.get("pic_path").toString());
		file.delete();
		
		// 사진 정보 삭제
		picDao.deletePic(picSeq);
	}
}
