package com.ruandao.springbootwebpack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 默认Controller，定义页面跳转
 */
@Controller
public class UiController {
    private static final Logger logger = LoggerFactory.getLogger(UiController.class);

    // /ui/path/to/test<-param1-param2-...>?querystring#...
    // 视图直接解析到 path/to/test.html，不再搜索path.html、path/to.html等。
    // 目的是用相对路径准确定位html所要引用的js、css等资源。
    // 应该仅仅处理html，忽略掉/ui/.../*.js等静态资源。
    @RequestMapping("/ui/**/*.html")
    public String view(HttpServletRequest request) throws FileNotFoundException {
        String path = request.getServletPath();

        boolean isOk;
        do {
            isOk = true;
            try {
                ClassPathResource classPathResource = new ClassPathResource("templates" + path);
                InputStream inputStream = classPathResource.getInputStream();
            } catch (IOException ex) {
                isOk = false;
                int endIndex = path.lastIndexOf("/");
                if (endIndex == 0)
                    throw new FileNotFoundException("View File Not Found: " + request.getServletPath() + ".html");
                path = path.substring(0, endIndex);
            }
        } while (!isOk);

        String viewPathFile = path.substring(1, path.length() - 5);  // 去掉打头的"/"和结尾的".html"。
        return viewPathFile;
    }
}