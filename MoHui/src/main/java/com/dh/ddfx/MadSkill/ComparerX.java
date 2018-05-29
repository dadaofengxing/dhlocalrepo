package com.dh.ddfx.MadSkill;

import com.dh.ddfx.utils.FileWriterUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ComparerX {

	/**
	 * @param args
	 * @throws SelfException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SelfException, IOException {
		List<String> sourceImageFileNameList = new ArrayList<String>();
		List<String> targetImageFileNameList = new ArrayList<String>();
		ImageCompareInterface imageCompare = new ImageCompareImpl();
		InvocationHandler handler = new Handler(imageCompare);
		
//创建动态代理对象
		ImageCompareInterface proxy= (ImageCompareInterface) Proxy.newProxyInstance(ImageCompareImpl.class.getClassLoader(), 
				ImageCompareImpl.class.getInterfaces(), 
				handler);
		if(proxy != null){
			sourceImageFileNameList = ImageReader.getSourceImageFileNameList();
			targetImageFileNameList = ImageReader.getTargetImageFileNameList();
			 
			if(sourceImageFileNameList.isEmpty()){
				throw new SelfException("No images in source image folder!");
			}else if(targetImageFileNameList.isEmpty()){
				throw new SelfException("No images in target image folder!");
			}else{
				int sourceImageFileNums = sourceImageFileNameList.size();
				int targetImageFileNums = targetImageFileNameList.size();
				
				if(sourceImageFileNums >= targetImageFileNums){
					for(String ImageName:sourceImageFileNameList){			
						if(targetImageFileNameList.contains(ImageName)){
							InputStream sourceIs = ImageReader.getImageInputStream(ImageName, 1);
							InputStream targetIs = ImageReader.getImageInputStream(ImageName, 2);
							int[][] a1 = proxy.getPiexRgbArray(sourceIs);
//							printArray(a1);
							int[][] a2 = proxy.getPiexRgbArray(targetIs);
//							printArray(a2);
							int[][] c = compareIntArray(a1,a2);
							printArray(c);

                            int[][] result = new int[2][2];
                            for(int i = 0;i<c.length;i++){
                                for(int j = 0;j<c[0].length;j++)
                                if( c[i][j] != 0){
                                    if(result[0][0] == 0){
                                        result[0][0] = i;
                                        result[0][1] = j;
                                    }else {
                                        result[0][0] = result[0][0]<i?result[0][0]:i;
                                        result[0][1] = result[0][1]<j?result[0][1]:j;
                                    }
                                    result[1][0] = result[1][0]>i?result[1][0]:i;
                                    result[1][1] = result[1][1]>j?result[1][1]:j;
                                }
                            }

                            try {
                                copyTarget(ImageName,result);
//                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else{
							throw new SelfException("Can't find the image named="+ImageName+" in target image folder or using the different expand name!");
						}
						
					}
				}else if(sourceImageFileNums < targetImageFileNums){
					for(String ImageName:targetImageFileNameList){			
						if(sourceImageFileNameList.contains(ImageName)){
							InputStream sourceIs = ImageReader.getImageInputStream(ImageName, 1);
							InputStream targetIs = ImageReader.getImageInputStream(ImageName, 2);
							String sourceImageHashStr = proxy.getImageHASHString(sourceIs,ImageName,1);
							String targetImageHashStr = proxy.getImageHASHString(targetIs,ImageName,2);
							int diffs = proxy.HanMingDistance(sourceImageHashStr, targetImageHashStr);
							CompareResultRangeHelper.compareResult(diffs, ImageName, ImageName);
						}else{
							throw new SelfException("Can't find the image named="+ImageName+" in source image folder or using the different expand name!");
						}
						
					}
				}
			}
			
		}
	}

    private static void copyTarget(String imageName, int[][] result) throws Exception {
//        InputStream in = new FileInputStream(ImageReader.targetFolderPath+imageName);//图片路径
        BufferedImage image = ImageIO.read(new File(ImageReader.targetFolderPath+imageName));
        Graphics g = image.getGraphics();
        g.setColor(Color.RED);//画笔颜色
        System.out.println(Arrays.toString(result));
        int width = image.getWidth();
        int heigh = image.getHeight();
        System.out.println(width+"  "+heigh);
        int beginX = width*result[0][0]/64;
        int beginY = heigh*result[0][1]/64;
        int endX = width*result[1][0]/64;
        int endY = heigh*result[1][1]/64;
        System.out.println(beginX+" "+beginY+" "+endX+" "+endY);
        g.drawRect(beginX,beginY,endX-beginX,endY-beginY);//矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
        //g.dispose();
        FileOutputStream out = new FileOutputStream(ImageReader.newImages+imageName.substring(0,imageName.lastIndexOf("."))+"2.png");//输出图片的地址
        ImageIO.write(image, "png", out);
    }
    public static void printArray(int[][] array){
	    List<String> list = new ArrayList<>();
	    for (int i = 0;i<array[0].length;i++){
	        StringBuffer sb = new StringBuffer();
	        for(int j = 0;j<array.length;j++){
                sb.append(array[i][j]);
            }
            list.add(sb.toString());
        }
        try {
            FileWriterUtils.write2File(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printArray(double[][] array){
        List<String> list = new ArrayList<>();
        for (int i = 0;i<array[0].length;i++){
            StringBuffer sb = new StringBuffer();
            for(int j = 0;j<array.length;j++){
                sb.append(array[i][j]);
            }
            list.add(sb.toString());
        }
        try {
            FileWriterUtils.write2File(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int[][] compareDoubleArray(double[][] a, double[][] b){
	    int[][] c = new int[a.length][a[0].length];
	    for(int i = 0;i<a.length;i++){
	        for(int j = 0;j<a[0].length;j++){
	            c[i][j] = compareDouble(a[i][j],b[i][j]);
            }
        }
        return c;
    }
    public static int compareDouble(double a,double b){
	    if(b/a < 5 && b/a > 0.2){
	        return 0;
        }
	    return 1;
    }
    public static int[][] compareIntArray(int[][] a,int[][] b){
	    int[][] c = new int[a.length][a[0].length];
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                c[i][j] = compareRgb(a[i][j],b[i][j],25);
            }
        }
        return c;
    }
    public static int compareRgb(int a,int b,int offset){
        int[] rgba = RGB(a);
        int[] rgbb = RGB(b);
        for(int i = 0;i<rgba.length;i++){
            if(rgba[i]>rgbb[i]+offset || rgba[i]<rgbb[i]-offset){
                return 1;
            }
        }
        return 0;
    }
    static int[] RGB(int color)
    {
        int[] rgb = new int[3];
        int r = 0xFF & color;
        int g = 0xFF00 & color;
        g >>= 8;
        int b = 0xFF0000 & color;
        b >>= 16;
        rgb[0] = r;
        rgb[1]=g;
        rgb[2]=b;
        return rgb;
    }

}
