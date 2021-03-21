package com.wcig.app.buildin;

import org.springframework.core.io.*;

public class BuildInResource {
    public static void test() {
        try {
            UrlResource urlResource = new UrlResource("https://baidu.com");
            ClassPathResource classPathResource = new ClassPathResource("application.properties");
            FileSystemResource fileSystemResource = new FileSystemResource("/tmp/a.txt");
            PathResource pathResource = new PathResource("/tmp/a.txt");
            InputStreamResource inputStreamResource = new InputStreamResource(urlResource.getInputStream());
            ByteArrayResource byteArrayResource = new ByteArrayResource("hello world".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
