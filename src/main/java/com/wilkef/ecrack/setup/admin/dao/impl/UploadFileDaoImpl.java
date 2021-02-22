package com.wilkef.ecrack.setup.admin.dao.impl;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.wilkef.ecrack.setup.admin.dao.UploadFileDao;

@Service
public class UploadFileDaoImpl implements UploadFileDao {

	private AmazonS3 amazonS3;

	@Value("${s3EndpointUrl}")
	private String endpointUrl;
	@Value("${s3BucketName}")
	private String bucketName;
	@Value("${s3AccessKey}")
	private String accessKey;
	@Value("${s3SecretKey}")
	private String secretKey;

	@SuppressWarnings("deprecation")
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.amazonS3 = new AmazonS3Client(credentials);
	}

	@Override
	public String uploadFile(MultipartFile multipartFile, String dir) {
		String fileURL = "";
		try {
			File file = convertMultipartFileToFile(multipartFile);
			String fileName = multipartFile.getOriginalFilename();
			fileURL = "https://wilkefprod.s3.ap-south-1.amazonaws.com/Instructors/Good-Morning-poppy-flower-500x500.jpg";
			fileURL = endpointUrl + "/" + bucketName + "/" + dir + "/" + fileName;
			uploadFileToBucket(dir, fileName, file);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileURL;
	}

	private File convertMultipartFileToFile(MultipartFile file) throws IOException {
		File convertedFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convertedFile);
		fos.write(file.getBytes());
		fos.close();
		return convertedFile;
	}

	private void uploadFileToBucket(String dir, String fileName, File file) {
		amazonS3.putObject(new PutObjectRequest(bucketName, dir + "/" + fileName, file)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}

	public String deleteFileFromBucket(String fileName) {
		amazonS3.deleteObject(new DeleteObjectRequest(bucketName, fileName));
		return "Deletion Successful";
	}

}
