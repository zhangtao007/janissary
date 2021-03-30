package com.lanjiu.im.storage.server.avatarUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageTools {

    //图片间隙
    private static final int SIDE=12;
    //画板尺寸
    private static final int CANVANS_H=412;

    private static final int CANVANS_W=412;

    //尺寸1（小）
    private static final int ONE_IMAGE_SIZE=CANVANS_H-(2*SIDE);

    //尺寸2（中）
    private static final int TWO_IMAGE_SIZE=(CANVANS_H-(3*SIDE))/2;

    //尺寸3（大）
    private static final int FIVE_IMAGE_SIZE=(CANVANS_H-(4*SIDE))/3;

    /**
     * 生成群头像接口
     * @return
     */
    public static boolean getCombinationOfhead(List<String> path, String dir, String groupId) throws IOException {

        List<BufferedImage>  list  = new ArrayList<>();
        int imageSize =0;
        if (path.size()<=1){
            imageSize=ONE_IMAGE_SIZE;
        }else if (path.size()>1 && path.size()<5){
            //若为2-4张
            imageSize=TWO_IMAGE_SIZE;
        }else {
            //若》=5张
            imageSize=FIVE_IMAGE_SIZE;
        }

        for (int i = 0; i <path.size() ; i++) {
            BufferedImage resize2 = ImageTools.resize2(path.get(i),imageSize,imageSize,true);
            list.add(resize2);
        }
        BufferedImage outImage = new BufferedImage(CANVANS_W,CANVANS_H,BufferedImage.TYPE_INT_RGB);
        //生成画布
        Graphics graphics = outImage.getGraphics();

        Graphics2D g2d = (Graphics2D)graphics;
        //设置背景色
        g2d.setBackground(new Color(219,223,224));
        //填充背景色在指定区域
        g2d.clearRect(0,0,CANVANS_W,CANVANS_H);

        for (int i = 1; i <=  list.size(); i++) {
            Integer size = list.size();
            switch (size){
                case 1:
                    g2d.drawImage(list.get(i-1),SIDE,SIDE,null);
                    break;
                case 2:
                    if (i==1){
                        g2d.drawImage(list.get(i-1),SIDE,(CANVANS_W-imageSize)/2,null);
                    }else {
                        g2d.drawImage(list.get(i-1),2*SIDE+imageSize,(CANVANS_W-imageSize)/2,null);
                    }
                    break;
                case 3:
                    if (i == 1) {
                        g2d.drawImage(list.get(i - 1), (CANVANS_W - imageSize) / 2, SIDE, null);
                    } else {
                        g2d.drawImage(list.get(i - 1), (i - 1) * SIDE + (i - 2) * imageSize, imageSize + (2 * SIDE), null);

                    }
                    break;
                case 4:
                    if (i <= 2) {
                        g2d.drawImage(list.get(i - 1), i * SIDE + (i - 1) * imageSize, SIDE, null);

                    } else {
                        g2d.drawImage(list.get(i - 1), (i - 2) * SIDE + (i - 3) * imageSize, imageSize + 2 * SIDE, null);

                    }
                    break;
                case 5:
                    if (i <= 2) {
                        g2d.drawImage(list.get(i - 1), (CANVANS_W - 2 * imageSize - SIDE) / 2 + (i - 1) * imageSize + (i - 1) * SIDE, (CANVANS_W - 2 * imageSize - SIDE) / 2, null);

                    } else {
                        g2d.drawImage(list.get(i - 1), (i - 2) * SIDE + (i - 3) * imageSize, ((CANVANS_W - 2 * imageSize - SIDE) / 2) + imageSize + SIDE, null);

                    }
                    break;
                case 6:
                    if (i <= 3) {
                        g2d.drawImage(list.get(i - 1), SIDE * i + imageSize * (i - 1), (CANVANS_W - 2 * imageSize - SIDE) / 2, null);
                    } else {
                        g2d.drawImage(list.get(i - 1), ((i - 3) * SIDE) + ((i - 4) * imageSize), ((CANVANS_W - 2 * imageSize - SIDE) / 2) + imageSize + SIDE, null);
                    }
                    break;
                case 7:
                    if (i <= 1) {
                        g2d.drawImage(list.get(i - 1), 2 * SIDE + imageSize, SIDE, null);
                    }
                    if (i <= 4 && i > 1) {
                        g2d.drawImage(list.get(i - 1), ((i - 1) * SIDE) + ((i - 2) * imageSize), 2 * SIDE + imageSize, null);
                    }
                    if (i <= 7 && i > 4) {
                        g2d.drawImage(list.get(i - 1), ((i - 4) * SIDE) + ((i - 5) * imageSize), 3 * SIDE + 2 * imageSize, null);
                    }
                    break;
                case 8:
                    if (i <= 2) {
                        g2d.drawImage(list.get(i - 1), (CANVANS_W - 2 * imageSize - SIDE) / 2 + (i - 1) * imageSize + (i - 1) * SIDE, SIDE, null);
                    }
                    if (i <= 5 && i > 2) {
                        g2d.drawImage(list.get(i - 1), ((i - 2) * SIDE) + ((i - 3) * imageSize), 2 * SIDE + imageSize, null);
                    }
                    if (i <= 8 && i > 5) {
                        g2d.drawImage(list.get(i - 1), ((i - 5) * SIDE) + ((i - 6) * imageSize), 3 * SIDE + 2 * imageSize, null);
                    }
                    break;
                case 9:
                    if (i <= 3) {
                        g2d.drawImage(list.get(i - 1), (i * SIDE) + ((i - 1) * imageSize), SIDE, null);
                    }
                    if (i <= 6 && i > 3) {
                        g2d.drawImage(list.get(i - 1), ((i - 3) * SIDE) + ((i - 4) * imageSize), 2 * SIDE + imageSize, null);
                    }
                    if (i <= 9 && i > 6) {
                        g2d.drawImage(list.get(i - 1), ((i - 6) * SIDE) + ((i - 7) * imageSize), 3 * SIDE + 2 * imageSize, null);
                    }
                    break;
                default:
                    break;
            }

        }

        StringBuffer outPath = new StringBuffer().append(dir).append(File.separatorChar).append(groupId).append(".jpg");
        String format ="JPG";
        File file =new File(outPath.toString());
        if (!file.exists()){
            file.mkdir();
        }
        return ImageIO.write(outImage,format,file);
    }

    /**
     * 图片缩放
     */
    public static BufferedImage resize2(String filePath,int height,int width,boolean bb){
        double ratio =0;

        try {
            BufferedImage bi = ImageIO.read(new File(filePath));
            Image itemp = bi.getScaledInstance(width,height,Image.SCALE_SMOOTH);
            //计算比例
            if ((bi.getHeight()>height) || (bi.getWidth()>width)){
                if (bi.getHeight()>bi.getWidth()){
                    ratio = (new Integer(height)).doubleValue()/bi.getHeight();
                }else {
                    ratio = (new Integer(width)).doubleValue()/bi.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(
                        AffineTransform.getScaleInstance(ratio,ratio),null);
                itemp = op.filter(bi,null);

            }
            if (bb){
                BufferedImage image = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, width, height);
                if (width == itemp.getWidth(null)) {
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                } else {
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                }
                g.dispose();
                itemp = image;
            }
            return (BufferedImage)itemp;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除文件
     */
    public  void delFile(String  path,String filename){
        File file = new File(path+"/"+filename);
        if (file.exists() && file.isFile()){
            file.delete();
        }
    }


    public static void main(String[] args) throws IOException {
//        Integer groupId =0;
//        for (int i = 1; i <10 ; i++) {
//            List<String> list = new ArrayList<>();
//            for (int j = 0; j <i ; j++) {
//                list.add("F:/ph/1.png");
//
//            }
//            File file = new File("");
//            String path = "F:/ph";
//            groupId++;
//            ImageTools.getCombinationOfhead(list,path,groupId.toString());
//
//        }

        String destPath = "D:\\file_server\\avatar\\";
        List<String> sourcePics = new ArrayList<>();
        sourcePics.add("D:\\file_server\\avatar\\10010260e4fd9ab1a6744a65ab658c52116b5f1c.jpg");
        sourcePics.add("D:\\file_server\\avatar\\10010261bbed3a418ba246ccb3f67b9719927ad5.jpg");
        sourcePics.add("D:\\file_server\\avatar\\10010261da2bce18518f490a8f09afd25a94521d.jpg");
        sourcePics.add("D:\\file_server\\avatar\\10010262fffade1e3f2b472fb40a2a1fd4f954e2.jpg");
        sourcePics.add("D:\\file_server\\avatar\\10010356248d9154d31f4ef983f819e994ffed93.jpg");
        sourcePics.add("D:\\file_server\\avatar\\1001093235496058924d41b5b9a49697d212276a.jpg");
        sourcePics.add("D:\\file_server\\avatar\\100106767e09836a9c884706b2dd6221ca0cf1c0.jpg");
        sourcePics.add("D:\\file_server\\avatar\\100102616deba16b266e4ed7bc1bfb2eb9780c69.jpg");
        sourcePics.add("D:\\file_server\\avatar\\10010966d5e2803875f446cea431fd49e6e254fc.jpg");

        for(int i = 1; i <= sourcePics.size(); i++){
            ImageTools.getCombinationOfhead(sourcePics.subList(0, i), destPath ,String.valueOf(i));
        }

    }
}
