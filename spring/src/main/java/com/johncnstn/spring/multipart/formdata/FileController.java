package com.johncnstn.spring.multipart.formdata;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/files")
public class FileController {

    @GetMapping
    public ResponseEntity<InputStreamResource> getBytes() {
        InputStream stream = getClass().getResourceAsStream("/static/jjk.png");
        InputStreamResource resourceStream = new InputStreamResource(stream);
        return ResponseEntity.ok(resourceStream);
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Void> upload(@RequestParam("name") String name,
                                       @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("name = " + name);
        System.out.println("filename = " + file.getOriginalFilename());
        System.out.println("contentType = " + file.getContentType());
        System.out.println("size = " + file.getSize());
        String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
        System.out.println("content = " + fileContent);
        return ResponseEntity.ok().build();
    }

}
