package com.epam.lab.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.epam.lab.log.MyLogger;

public class UploadMyFile {

	private final int maxFileSize = 1024 * 1024 * 3;
	private final int maxMemSize = 1024 * 1024 * 3;
	private final int threshold_size = 1024 * 1024 * 4;

	private String uploadPath = null;
	private ServletFileUpload upload;

	public String uploadFile(Part part, ServletContext servletContext)
			throws IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(threshold_size);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(maxFileSize);
		upload.setSizeMax(maxMemSize);

		
		uploadPath = servletContext.getInitParameter("file-upload");

		String fileName = extractFileName(part);
		
		
		OutputStream out = null;
		InputStream input = null;
		try {

			File f = new File(uploadPath + File.separator + fileName);

			out = new FileOutputStream(f);
			input = part.getInputStream();

		
			int read = 0;
			byte[] bytes = new byte[1024];

			
			while ((read = input.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			return fileName;
		} catch (FileNotFoundException e) {
			MyLogger.log.error(e);
			return null;
		} finally {
			try {
				input.close();
				out.close();
			} catch (Exception e) {
				MyLogger.log.error(e);
				return null;
			}
		}
		
	}

	public static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return new Random().nextInt(Integer.MAX_VALUE)
						+ s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
