package com.countervalorantapex.contractmanagement.sys.controller;


import com.countervalorantapex.contractmanagement.exception.AppException;
import com.countervalorantapex.contractmanagement.exception.AppExceptionCodeMsg;
import com.countervalorantapex.contractmanagement.exception.response.Resp;
import com.countervalorantapex.contractmanagement.sys.entity.Files;
import com.countervalorantapex.contractmanagement.sys.mapper.FilesMapper;
import com.countervalorantapex.contractmanagement.sys.service.impl.FilesServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * 文件上传接口
 */

@RestController
@RequestMapping("/sys/file")
public class FileController {

    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Autowired
    private FilesServiceImpl filesService;
    @Resource
    private Environment environment;
    @Resource
    private FilesMapper filesMapper;

    @GetMapping("/getFileByName")
    @ApiOperation(value = "通过文件名返回文件信息")
    public Resp<Files> getFile(@RequestParam(value = "fileName")String fileName){
        return Resp.success(filesService.getFileByName(fileName));
    }

    @PostMapping("/upload")
    @ApiOperation(value = "上传文件接口")
    public synchronized String upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = StringUtils.getFilenameExtension(originalFilename);
        long size = file.getSize();
        // 创建文件夹
        File uploadParentFile = new File(fileUploadPath);
        if (!uploadParentFile.exists()) {
            uploadParentFile.mkdirs();
        }
        // 生成唯一的文件名
        String uniqueFilename = UUID.randomUUID().toString();
        String finalName = uniqueFilename + "." + type;
        File uploadFile = new File(fileUploadPath + finalName);
        // 存入磁盘
        file.transferTo(uploadFile);
        // 存储到数据库
        String url = "http://localhost:" + environment.getProperty("server.port") + "/sys/file/" + finalName;
        Files saveFile = new Files();
        saveFile.setFileName(uniqueFilename);
        saveFile.setOriginName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size / 1024);
        saveFile.setUrl(url);
        filesMapper.insert(saveFile);
        return uniqueFilename;
    }



    @GetMapping("/{finalName}")
    @ApiOperation(value = "预览或下载文件接口")
    public void download(@PathVariable String finalName, HttpServletResponse response)throws IOException {
        //fileUploadPath 为文件的
        File file = new File(fileUploadPath + finalName);
        if (file.exists()) {
            String fileExtension = StringUtils.getFilenameExtension(finalName);
            String contentType = getContentType(fileExtension);

            response.setContentType(contentType);
            response.setHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode(finalName, "UTF-8"));
            try (FileInputStream fis = new FileInputStream(file); OutputStream os = response.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.flush();
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @GetMapping("/delete/{finalName}")
    @ApiOperation(value = "文件删除接口")
    public Resp<Boolean> delete(@PathVariable String finalName){
        File file = new File(fileUploadPath + finalName);
        if (!file.exists()) {
            throw new AppException(AppExceptionCodeMsg.FILE_NO_EXISTS);
        }
        else {
            file.delete();
            Files files = new Files();
            filesService.deleteFileByName(file.getName());
            return Resp.success(true);
        }
    }

    private String getContentType(String fileExtension) {
        // 根据文件扩展名返回对应的 MIME 类型
        switch (fileExtension.toLowerCase()) {
            case "pdf":
                return "application/pdf";
            case "txt":
                return "text/plain";
            case "png":
                return "image/png";
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            default:
                return "application/octet-stream";
        }
    }
}
