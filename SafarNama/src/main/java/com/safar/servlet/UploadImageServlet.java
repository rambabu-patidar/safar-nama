package com.safar.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.safar.utils.GenerateRandomId;
import com.safar.utils.GetDirectory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadImage")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class UploadImageServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part filePart = req.getPart("image");
		
//		String fileName = filePart.getSubmittedFileName();
		String fileName = GenerateRandomId.generateRandomString();
		
		String uploadPath = GetDirectory.getImageDir() + fileName + ".jpg";
		
		
		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			
			InputStream is = filePart.getInputStream();
			
			byte [] data = new byte[is.available()];
			
			is.read(data);
			fos.write(data);
			fos.close();
			is.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
