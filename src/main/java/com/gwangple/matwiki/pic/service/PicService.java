package com.gwangple.matwiki.pic.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gwangple.matwiki.pic.dao.PicDao;
import com.gwangple.matwiki.pic.dto.PicDto;

/**
 * 이미지 service
 * @author sukhwan
 *
 */
@Service("PicService")
public class PicService {

	@Resource(name = "picDao")
	PicDao picDao;
	
	// 이미지 경로
	private String imgPath = "";
	
	// 썸네일 가로 크기
	private Integer thumbWidth = 300;
	// 썸네일 세로 크기
	private Integer thumbHeight = 500;
	
	/**
	 * 이미지 저장
	 * @param picDto
	 * @param image
	 * @throws IOException
	 */
	public void insertPic(PicDto picDto,MultipartFile image,String picFrontPath) throws IOException{
        savePic(picDto, image,picFrontPath);
        
        
        picDao.insertPic(picDto);
        picDao.insertPicHistory(picDto);
	}
	
	/**
	 * 이미지 저장(서버에)
	 * @param picDto
	 * @param image
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void savePic(PicDto picDto,MultipartFile image,String picFrontPath) throws IOException{
		FileOutputStream fos;
		
		byte fileData[] = image.getBytes();
        
		String path ="\\" + UUID.randomUUID().toString();
        
		fos = new FileOutputStream(picFrontPath+path);
        fos.write(fileData);
        
        picDto.setPicFrontPath(picFrontPath);
        picDto.setPicBackPath(path);
	}
	
	/**
	 * 썸네일 저장
	 * @param picDto
	 */
	public void saveThumb(PicDto picDto){
		
		String path = "\\" + UUID.randomUUID().toString();
		
		File originFile = new File(picDto.getPicFrontPath()+picDto.getPicBackPath());
		
		File thumbFile  = new File("/thumb/"+path);
		
		try {
			BufferedImage bufferOriginalImage = ImageIO.read(originFile);
			BufferedImage bufferThumbFile = new BufferedImage(this.thumbWidth, this.thumbHeight, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = bufferThumbFile.createGraphics();
	        graphic.drawImage(bufferOriginalImage, 0, 0, this.thumbWidth, this.thumbHeight, null);
	        ImageIO.write(bufferThumbFile, "jpg", thumbFile);
	        
	        picDto.setThumbYn("Y");
	        picDto.setPicFrontPath("/thumb/");
	        picDto.setPicBackPath(path);
	        
	        picDao.insertPic(picDto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	/**
	 * 이미지 삭제
	 * @param picSeq
	 */
	public void deleteImage(String picSeq){
		Map<String,Object> pic = picDao.selectPic(picSeq);
		
		File file = new File(pic.get("pic_path").toString());
		file.delete();
		picDao.deletePic(picSeq);
	}
}
