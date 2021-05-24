//package com.liveamonth.liveamonth.entity.dto;
//
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.SdkClientException;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.DeleteObjectRequest;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.swing.filechooser.FileNameExtensionFilter;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Optional;
//import java.util.UUID;
//
//import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewImage.*;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class S3UploaderDTO {
//
//    private final AmazonS3Client amazonS3Client;
//
//    @Value("${aws.s3.image.bucket}")
//    public String bucket;  // S3 버킷 이름
//
//    public String upload(MultipartFile multipartFile, String dirName) throws IOException {
//        File uploadFile = convert(multipartFile)  // 파일 변환할 수 없으면 에러
//                .orElseThrow(() -> new IllegalArgumentException(FILE_CONVERT_ERROR_MESSAGE.getText()));
//
//        return upload(uploadFile, dirName);
//    }
//
//    // S3로 파일 업로드하기
//    private String upload(File uploadFile, String dirName) {
//        String fileName = UUID.randomUUID() + uploadFile.getName();
//        String saveFileName = dirName + "/" + fileName; // S3에 저장된 파일 이름
//        String uploadImageUrl = putS3(uploadFile, saveFileName); // s3로 업로드
//        removeNewFile(uploadFile);
//        return fileName;
//    }
//
//    public String uploadProfileImg(MultipartFile multipartFile, String dirName, String userID) throws IOException {
//        File uploadFile = convert(multipartFile)  // 파일 변환할 수 없으면 에러
//                .orElseThrow(() -> new IllegalArgumentException(FILE_CONVERT_ERROR_MESSAGE.getText()));
//
//        return uploadProfileImg(uploadFile, dirName, userID);
//    }
//
//    // S3로 파일 업로드하기
//    private String uploadProfileImg(File uploadFile, String dirName, String userID) {
//        String extension = FilenameUtils.getExtension(uploadFile.getName());
//        String fileName = userID + "." + extension;
//        String saveFileName = dirName + fileName; // S3에 저장된 파일 이름
//        String uploadImageUrl = putS3(uploadFile, saveFileName); // s3로 업로드
//        removeNewFile(uploadFile);
//        return fileName;
//    }
//
//    // S3로 업로드
//    private String putS3(File uploadFile, String fileName) {
//        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
//        return amazonS3Client.getUrl(bucket, fileName).toString();
//    }
//
//    // 로컬에 저장된 이미지 지우기
//    private void removeNewFile(File targetFile) {
//        if (targetFile.delete()) {
//            log.info(FILE_DELETE_SUCCESS_MESSAGE.getText());
//            return;
//        }
//        log.info(FILE_DELETE_FAIL_MESSAGE.getText());
//    }
//
//    // 로컬에 파일 업로드 하기
//    private Optional<File> convert(MultipartFile file) throws IOException {
//        File convertFile = new File(System.getProperty("user.dir") + "/" + file.getOriginalFilename());
//        if (convertFile.createNewFile()) { // 바로 위에서 지정한 경로에 File이 생성됨 (경로가 잘못되었다면 생성 불가능)
//            try (FileOutputStream fos = new FileOutputStream(convertFile)) { // FileOutputStream 데이터를 파일에 바이트 스트림으로 저장하기 위함
//                fos.write(file.getBytes());
//            }
//            return Optional.of(convertFile);
//        }
//
//        return Optional.empty();
//    }
//
//    public void delete(String key) {
//        try {
//            //Delete 객체 생성
//            DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(this.bucket, key);
//            //Delete
//            this.amazonS3Client.deleteObject(deleteObjectRequest);
//            System.out.println(String.format("[%s] deletion complete", key));
//        } catch (AmazonServiceException e) {
//            e.printStackTrace();
//        } catch (SdkClientException e) {
//            e.printStackTrace();
//        }
//    }
//}