package com.assigment.utils;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileUtils {

	public File handleUploadFile(MultipartFile uploadedFile) {
		String folder = "G:\\Java5\\JavaSpring\\Assigment\\src\\main\\webapp\\img";
		File myUploadFolder = new File(folder);
		if (!myUploadFolder.exists()) {
			myUploadFolder.mkdirs();
		}
		File saveFile = null;
		try {
			String fileName = uploadedFile.getOriginalFilename();
			System.out.println(fileName);
			saveFile = new File(myUploadFolder, fileName);
			uploadedFile.transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFile;
	}

}
