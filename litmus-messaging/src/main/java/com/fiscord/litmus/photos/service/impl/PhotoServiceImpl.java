package com.fiscord.litmus.photos.service.impl;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiscord.litmus.photos.service.api.PhotoService;
import com.fiscord.litmus.photos.service.api.RestService;

@Service
public class PhotoServiceImpl implements PhotoService{

	
	public static final String RANDOM_PHOTO_GENERATOR_URL="https://api.unsplash.com/photos/random/";
	
	public static final String SPLASH_CLIENT_ID="Y9dK-xqp8mG88CT_-gQdmsDpabT4u_Y5DEXV-oS4sHU";
	
	@Autowired
	private RestService restService;
	
	@Override
	public String getRandomPhotoUrl(int id) {
		String url = RANDOM_PHOTO_GENERATOR_URL;
		return getImageDetailsFromSplash();
	}
	
	private Image readImage(String url) {
		
		Image image=null;
		
		try {
		URL url2=new URL(url);
		image = ImageIO.read(url2);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return image;
	}
	
	private String getImageDetailsFromSplash() {
		String jsonResult="";
		try {
			jsonResult= restService.getImageAsPlainJson(RANDOM_PHOTO_GENERATOR_URL+"?client_id="+SPLASH_CLIENT_ID);
			System.out.println(jsonResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String requrl="";
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(
				    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			PhotoDetails pd = objectMapper.readValue(jsonResult, PhotoDetails.class);
			requrl=pd.getUrls().get("full");
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("Url genereated is :"+  requrl);
		return requrl;
	}
	
	
	public static class PhotoDetails{
		String id;
		String desccription;
		Map<String, String> urls;
		public PhotoDetails() {
			super();
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getDesccription() {
			return desccription;
		}
		public void setDesccription(String desccription) {
			this.desccription = desccription;
		}
		public Map<String, String> getUrls() {
			return urls;
		}
		public PhotoDetails(String id, String desccription, Map<String, String> urls) {
			super();
			this.id = id;
			this.desccription = desccription;
			this.urls = urls;
		}
		public void setUrls(Map<String, String> urls) {
			this.urls = urls;
		}
	}

}
