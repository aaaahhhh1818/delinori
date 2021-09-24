package com.noriteo.delinori.saleboard.controller;

import com.noriteo.delinori.saleboard.dto.UploadResponseDTO;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
public class UploadController {

    @GetMapping("/sample/upload")
    public void uploadGET() {

    }

    @ResponseBody
    @PostMapping("/upload")
    public List<UploadResponseDTO> uploadPost(MultipartFile[] uploadFiles) {

        log.info("-----------------------------------");

        if (uploadFiles != null && uploadFiles.length > 0) {

            List<UploadResponseDTO> uploadedList = new ArrayList<>();

            for (MultipartFile multipartFile : uploadFiles) {
                try {
                    uploadedList.add(uploadProcess(multipartFile));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }//for

            return uploadedList;

        }//end

        return null;

    }

    private UploadResponseDTO uploadProcess(MultipartFile multipartFile) throws Exception {

        String uploadPath = "C:\\upload";

        String folderName = makeFolder(uploadPath);

        //log.info(multipartFile.getContentType()); //MIME 타입
        //log.info(multipartFile.getOriginalFilename());
        log.info(multipartFile.getSize());
        log.info("-----------------------------------");

        String fileName = multipartFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String originalFileName = fileName;

        fileName = uuid + "_" + fileName; //uuid

        File savedFile = new File(uploadPath+File.separator+folderName, fileName);

        //실제 upload
        FileCopyUtils.copy(multipartFile.getBytes(), savedFile);

        //Thumbnail 처리
        String mimeType = multipartFile.getContentType();
        boolean checkImage = mimeType.startsWith("image");

        if(checkImage) { //이미지 여부
            File thumbnailFile = new File(uploadPath+File.separator+folderName, "s_" + fileName);
            Thumbnailator.createThumbnail(savedFile, thumbnailFile, 100, 100);
        }

        return UploadResponseDTO.builder()
                .uuid(uuid)
                .uploadPath(folderName.replace(File.separator,"/"))
                .fileName(originalFileName)
                .image(checkImage)
                .build();

    }

    private String makeFolder(String uploadPath) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        String folderName = str.replace("-", File.separator);
        File uploadFolder = new File(uploadPath, folderName);

        if(uploadFolder.exists() == false) {
            uploadFolder.mkdirs();
        }

        return folderName;

    }

}
