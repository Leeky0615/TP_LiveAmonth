package com.liveamonth.liveamonth.entity.dto;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class S3UploaderDTO {

    private final AmazonS3Client amazonS3Client;

    @Value("${aws.s3.image.bucket}")
    public String bucket;  // S3 버킷 이름

    public String upload(String dirName, String originalFilename, byte[] bytes) throws Exception {
        UUID uid = UUID.randomUUID();
        String savedName = "/"+uid.toString() + "_" + originalFilename;
        String uploadedFileName = (savedName).replace(File.separatorChar, '/');
        fileUpload(dirName + uploadedFileName, bytes);
        return uploadedFileName;
    }

    public String uploadProfileImg(String dirName, String userID, String originalFilename, byte[] bytes) throws Exception {
        String extension = FilenameUtils.getExtension(originalFilename);
        String fileName = userID +"."+extension;
        String saveFileName = dirName + fileName; // S3에 저장된 파일 이름
        String uploadedFileName = (saveFileName).replace(File.separatorChar, '/');
        fileUpload(saveFileName, bytes);
        return fileName;
    }

    public void fileUpload(String fileName, byte[] fileData) throws FileNotFoundException {

        String filePath = (fileName).replace(File.separatorChar, '/');
        ObjectMetadata metaData = new ObjectMetadata();

        metaData.setContentLength(fileData.length);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileData);

        amazonS3Client.putObject(bucket, filePath, byteArrayInputStream, metaData);
    }

    public void delete(String key) {
        try {
            //Delete 객체 생성
            DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(this.bucket, key);
            //Delete
            this.amazonS3Client.deleteObject(deleteObjectRequest);
            System.out.println(String.format("[%s] deletion complete", key));
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }
}