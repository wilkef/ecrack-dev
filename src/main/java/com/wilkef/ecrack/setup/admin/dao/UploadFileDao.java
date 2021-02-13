package com.wilkef.ecrack.setup.admin.dao;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileDao {

	public String uploadFile(MultipartFile multipartFile, String dir);

	public String deleteFileFromBucket(String fileName);

}
