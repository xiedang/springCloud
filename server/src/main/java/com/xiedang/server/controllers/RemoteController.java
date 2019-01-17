package com.xiedang.server.controllers;

import com.xiedang.server.vo.FilesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author xiedang
 * @date 2017/2/9
 */
@Controller
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class RemoteController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/index")
    public Object index() {
        return "index";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object showUsers() {
        Object object = restTemplate.getForObject("http://client_001:8082/userList", Object.class);
        return object;
    }

    @RequestMapping(value = "/upload", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object up(HttpServletRequest request, FilesVo filesVo, MultipartFile file_data) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        String filePath = request.getSession().getServletContext().getRealPath("/") + file_data.getOriginalFilename();
        File files = new File(filePath);
        // 转存文件  
        file_data.transferTo(files);
        FileSystemResource resource = new FileSystemResource(files);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("filesVo", filesVo);
        form.add("file_data", resource);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(form, headers);
        ResponseEntity<Object> exchange = restTemplate.exchange("http://localhost:8083/uploadFile", HttpMethod.POST, httpEntity, Object.class);
        Files.delete(files.toPath());
        System.out.println(exchange);
        return exchange;
    }

}
