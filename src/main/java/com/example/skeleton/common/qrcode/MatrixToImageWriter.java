package com.example.skeleton.common.qrcode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.google.zxing.common.BitMatrix;

/**
 * 用于二维码的生成
 * @author joker
 *
 */
public class MatrixToImageWriter {


    private final static int BLACK=0XFF000000;

    private final static int WHITE=0XFFFFFFFF;

    public MatrixToImageWriter() {
    }

    /**
     * 生成二维码图片
     * @param matrix
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        for(int x=0;x<width;x++) {
            for(int y=0;y<height;y++) {
                image.setRGB(x, y, matrix.get(x, y)?BLACK:WHITE);
            }
        }

        return image;
    }

    /**
     * 将图片写入到某个文件中
     * @param matrix
     * @param format
     * @param file
     * @throws IOException
     */
    public static void whiteToFile(BitMatrix matrix,String format,File file) throws IOException{
        BufferedImage image = toBufferedImage(matrix);
        if(!ImageIO.write(image, format, file)) {
            System.out.println("could not white an image of format "+format+" to "+file);
        }
    }

    /**
     * 将一个图片写成输出流的形式
     * @param matrix
     * @param format
     * @param stream
     * @throws IOException
     */
    public static void whiteToStream(BitMatrix matrix,String format,OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if(!ImageIO.write(image, format, stream)) {
            System.out.println("could not white an image of format "+format);
        }
    }
}
