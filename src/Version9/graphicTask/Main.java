package Version9.graphicTask;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedImage img = siplit(ImageIO.read(new File("origin.jpg")));
        ImageIO.write(img, "jpg", new File("Test.jpg"));
        rgbColor();
    }

    private static BufferedImage siplit (BufferedImage img){
        int imgFullHeight = img.getHeight();
        int imgFullWidth = img.getWidth();
        System.out.println(imgFullHeight);
        System.out.println(imgFullWidth);
        int[][] partSize = new int[imgFullHeight/2][imgFullWidth/2];
//        BufferedImage newImg = img.getSubimage(0, 0, imgFullHeight/2, imgFullWidth/2);
//        int [] arr = {3, 1, 1, 2};
//        parts(newImg, arr);
//        parts(img, arr);
        changeOnePartColor(img);
        return img;
    }

    private static void changeOnePartColor(BufferedImage bufferedImage){
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth()/2, bufferedImage.getHeight()/2, Color.cyan, null);
    }

    private static void parts(BufferedImage bi, int[] cells){
        Graphics2D graphics2D = bi.createGraphics();
        int cellWidth = bi.getWidth(null)/2;
        int cellHeight = bi.getHeight(null)/2;
        for (int x=0; x<2; x++) {
            int sx = x*cellWidth;
            for (int y=0; y<2; y++) {
                int sy = y*cellHeight;
                int cell = cells[x*2+y];
                int dx = (cell / 2) * cellWidth;
                int dy = (cell % 2) * cellHeight;
                graphics2D.drawImage(bi,
                        dx, dy,
                        x+cellWidth, dy+cellHeight,
                        sx, sy,
                        sx+cellWidth, sy+cellHeight,
                        null);
            }
        }
    }

    public static void rgbColor(){
        BufferedImage img = null;
        File f = null;

        //read image
        try{
            f = new File("origin.jpg");
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }

        //get image width and height
        int width = img.getWidth()/2;
        int height = img.getHeight()/2;

        //convert to grayscale
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int p = img.getRGB(x,y);

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                //calculate average
                int avg = (r+g+b)/3;

                //replace RGB value with avg
//                p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                p=avg;
                img.setRGB(x, y, p);
            }
        }

        //write image
        try{
            f = new File("test2.jpg");
            ImageIO.write(img, "jpg", f);
        }catch(IOException e){
            System.out.println(e);
        }
    }


}
