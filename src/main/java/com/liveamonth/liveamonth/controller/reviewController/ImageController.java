package com.liveamonth.liveamonth.controller.reviewController;

import com.google.gson.JsonObject;
import com.liveamonth.liveamonth.entity.dto.S3UploaderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewImage.*;

@RequiredArgsConstructor
@RestController
public class ImageController {

    private final S3UploaderDTO s3Uploader;

    @PostMapping(value="/uploadSummernoteImageFile", produces = "application/json")
    @ResponseBody
    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {

        JsonObject jsonObject = new JsonObject();
        try {
            String savedFileName = s3Uploader.upload(S3_UPLOAD_FOLDER.getText(), multipartFile.getOriginalFilename(), multipartFile.getBytes());
            jsonObject.addProperty(TEMP_IMAGE_URL.getText(), TEMP_IMAGE_PATH.getText()+savedFileName);
            jsonObject.addProperty(RESPONSECODE.getText(), "success");
        } catch (IOException e) {
            jsonObject.addProperty(RESPONSECODE.getText(), "error");
            e.printStackTrace();
        } catch (Exception e) {
            jsonObject.addProperty(RESPONSECODE.getText(), "error");
            e.printStackTrace();
        }
        return jsonObject;
    }
}
