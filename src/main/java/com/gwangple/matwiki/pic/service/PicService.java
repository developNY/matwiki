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
 * ?��? service
 * @author sukhwan
 *
 */
@Service("PicService")
public class PicService {

	@Autowired
	PicDao picDao;
	
	// ?��?��? 경�?
	String imgPath = "";
	
	/** 
	 * ?��? ????
	 * @param picDto : ?��? ??�?
	 * @param image  : ?��? ????
	 * @throws IOException 
	 */
	public void insertPic(PicDto picDto,MultipartFile image) throws IOException{
		// ?��? ??�??? ????
        savePic(picDto, image);
        
        
        picDao.insertPic(picDto);
        picDao.insertPicHistory(picDto);
	}
	
	/**
	 * ?��? ??�??? ???? 
	 * @param image : ?��? ????
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public void savePic(PicDto picDto,MultipartFile image) throws IOException{
		FileOutputStream fos;
		
		byte fileData[] = image.getBytes();
        
		String path = imgPath + "\\" + UUID.randomUUID().toString();
        
		fos = new FileOutputStream(path);
        fos.write(fileData);
        
        // ???? 경�? ????
        picDto.setPicPath(path);
	}
	
	/**
	 * ?��?��?? �??�기
	 * @param picDto
	 * @param path
	 */
	public void saveThumb(PicDto picDto){
		
	}
	
	/**
	 * ?��? ????
	 * @param picSeq : ?��?�???
	 */
	public void deleteImage(String picSeq){
		// ?��? ??�? 조�??
		Map<String,Object> pic = picDao.selectPic(picSeq);
		
		// ??�????? ???? ????
		File file = new File(pic.get("pic_path").toString());
		file.delete();
		
		// ?��? ??�? ????
		picDao.deletePic(picSeq);
	}
}
