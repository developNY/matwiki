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
 * ?科? service
 * @author sukhwan
 *
 */
@Service("PicService")
public class PicService {

	@Autowired
	PicDao picDao;
	
	// ?渠?賄? 窶趟?
	String imgPath = "";
	
	/** 
	 * ?科? ????
	 * @param picDto : ?科? ??貐?
	 * @param image  : ?科? ????
	 * @throws IOException 
	 */
	public void insertPic(PicDto picDto,MultipartFile image) throws IOException{
		// ?科? ??貒??? ????
        savePic(picDto, image);
        
        
        picDao.insertPic(picDto);
        picDao.insertPicHistory(picDto);
	}
	
	/**
	 * ?科? ??貒??? ???? 
	 * @param image : ?科? ????
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public void savePic(PicDto picDto,MultipartFile image) throws IOException{
		FileOutputStream fos;
		
		byte fileData[] = image.getBytes();
        
		String path = imgPath + "\\" + UUID.randomUUID().toString();
        
		fos = new FileOutputStream(path);
        fos.write(fileData);
        
        // ???? 窶趟? ????
        picDto.setPicPath(path);
	}
	
	/**
	 * ?賈?木?? 諤??曰萼
	 * @param picDto
	 * @param path
	 */
	public void saveThumb(PicDto picDto){
		
	}
	
	/**
	 * ?科? ????
	 * @param picSeq : ?科?貒???
	 */
	public void deleteImage(String picSeq){
		// ?科? ??貐? 魽堅??
		Map<String,Object> pic = picDao.selectPic(picSeq);
		
		// ??貒????? ???? ????
		File file = new File(pic.get("pic_path").toString());
		file.delete();
		
		// ?科? ??貐? ????
		picDao.deletePic(picSeq);
	}
}
