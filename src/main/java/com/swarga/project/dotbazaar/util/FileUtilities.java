package com.swarga.project.dotbazaar.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtilities {

	private static void createDirectory(String directoryPath)
	{
		if(!new File(directoryPath).exists() || !new File(directoryPath).isDirectory())
		{
			new File(directoryPath).mkdirs();
		}
	}
	
	public static void saveFile(String directoryPath, MultipartFile file)
	{
		createDirectory(directoryPath);
		FileOutputStream fOS=null;
		try {
			fOS=new FileOutputStream(directoryPath+File.separator+file.getOriginalFilename());
			fOS.write(file.getBytes());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.err.println("ERROR in saving the file");
		}
		finally {
			if(null!=fOS)
			{
				try {
					fOS.close();
				} catch (IOException e) {
					System.out.println("Resource Closing Failed!!");
				}
			}
		}
	}
}
