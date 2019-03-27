package com.example.skeleton.common.CodeUtil;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: yebing
 * @Date: 2018-9-20 15:43
 * @Version 1.0.0
 */
public class CodeImageUtilTest {
    public static void main(String[] args) throws IOException {
        CodeImageUtil codeImageUtil = new CodeImageUtil();
        codeImageUtil.init(120,50);
        BufferedImage bufferedImage = codeImageUtil.getImage();
        File file = new File("E://test.jpg");
        FileOutputStream out = new FileOutputStream(file); // 输出到文件流
        // 可以正常实现bmp、png、gif转jpg
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(bufferedImage); // JPEG编码
        out.close();
    }
}
