package com.gopikrishna.jobportal.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
	public static void saveFile(String uploadDir,String fileName,MultipartFile multipartfile) throws IOException {
		Path uploadPath=  Paths.get(uploadDir);
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try(InputStream inputStream= multipartfile.getInputStream()) {
			Path path=uploadPath.resolve(fileName);
			System.out.println("FilePath "+path);
			System.out.println("File name "+fileName);
			Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
			
		}
		catch (IOException e) {
			// TODO: handle exception
			throw new IOException("Could not save image file : "+fileName,e);
		}
	}

}