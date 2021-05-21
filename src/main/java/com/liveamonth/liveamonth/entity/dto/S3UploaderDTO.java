package com.liveamonth.liveamonth.entity.dto;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class S3UploaderDTO {

    private final AmazonS3Client amazonS3Client;

    @Value("${aws.s3.image.bucket}")
    public String bucket;  // S3 버킷 이름

    public String uploadProfileImg(MultipartFile multipartFile, String dirName, String userID) throws IOException {
//        File uploadFile = convert(multipartFile)  // 파일 변환할 수 없으면 에러
//                .orElseThrow(() -> new IllegalArgumentException(FILE_CONVERT_ERROR_MESSAGE.getText()));

//        return uploadProfileImg(uploadFile, dirName,userID);
        return null;
    }


    // S3로 파일 업로드하기
    private String uploadProfileImg(File uploadFile, String dirName, String userID) {
//        try {
//            String extension = FilenameUtils.getExtension(uploadFile.getName());
//            String fileName = userID +"."+extension;
//            String saveFileName = dirName + "/" +  fileName; // S3에 저장된 파일 이름
//            String uploadImageUrl = putS3(uploadFile, saveFileName); // s3로 업로드
//            removeNewFile(uploadFile);
//            return fileName;
//        } catch (AmazonServiceException e) {
//            e.printStackTrace();
//        } catch (SdkClientException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public String uploadTest(String dirName, String originalFilename, byte[] bytes) throws Exception {
        UUID uid = UUID.randomUUID();
        String savedName = "/"+uid.toString() + "_" + originalFilename;
        String uploadedFileName = (savedName).replace(File.separatorChar, '/');
        fileUpload(dirName + uploadedFileName, bytes);
        return uploadedFileName;
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