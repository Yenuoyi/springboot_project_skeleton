package com.example.skeleton.controller;

import com.example.skeleton.common.qrcode.MakeQRCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二维码生成
 * @author yebing
 */
@Controller
public class QrController {
    @RequestMapping("/parseService/Code")
    public void parseService(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            // 生成二维码码实例
            OutputStream stream = (OutputStream)response.getOutputStream();
            MakeQRCodeUtils.generateQRCodeToStream("hello",100,100,"jpg",stream);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            System.out.println("验证码生成失败");
        }
    }
}
