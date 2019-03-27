package com.example.skeleton.common.ImageUtil;

import java.io.IOException;

/**
 * <p>
 * 图片压缩工具类 ImgCompressUtil
 * </p>
 */
public class ImgCompressUtil {
	
	private ImgCompressUtil(){
		
	}
	
    /**
     * @param filePath 源图片路径【图片全路径】
     * @param compressionPath 生成图片路径【图片全路径】
     * @param width 宽度
     * @param height 高度
     */
    public static void comparess(String filePath,String compressionPath,int width,int height) {
        try{
            ImgCompress imgCom = new ImgCompress(filePath,compressionPath);
            imgCom.resizeFix(width, height);
        }catch (IOException e){
            throw new RuntimeException("压缩图片失败",e);
        }
    }
}
