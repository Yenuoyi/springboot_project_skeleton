package com.example.skeleton.common.CodeUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Author: yebing
 * @Date: 2018-9-20 15:09
 * @Version 1.0.0
 */
public class CodeImageUtil {
    private BufferedImage image; // 图像
    private String str; // 验证码
    public BufferedImage getImage() {
        return this.image;
    }

    public String getStr() {
        return this.str;
    }

    /**
     * 图像初始化
     * @param width 图像宽度
     * @param height 图像高度
     */
    public void init(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics graphics = image.getGraphics();
        setBackground(graphics,width,height);
        // 取随机产生的认证码(4位数字)
        StringBuffer sRand = new StringBuffer();
        // 设定字体
        graphics.setFont(new Font("宋体", Font.PLAIN, height - 5));
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand.append(rand);
            // 将认证码显示到图象中
            graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            graphics.drawString(rand, 20 * i, height-10);
        }
        graphics.dispose();
        this.str = sRand.toString();
        this.image = image;
    }

    /**
     * 设置图片背景
     * @param graphics
     * @param width
     * @param height
     */
    private void setBackground(Graphics graphics, int width, int height){
        // 生成随机类
        Random random = new Random();
        // 设定背景色
        graphics.setColor(getRandColor());
        graphics.fillRect(0, 0, width, height);
        // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < 155; i++) {
            graphics.setColor(getRandColor());
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(20);
            int yl = random.nextInt(20);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
    }
    /**
     * 给定范围获得随机颜色
     * @return
     */
    private Color getRandColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r, g, b);
    }
}
