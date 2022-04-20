package cw3;

import java.awt.Color;

/**
 * CPT105 2020 Coursework 3 Sample Methods
 */
public class CW3_Example {

    // Returns a new picture that is an upside down version the given picture.
//    public static Picture upsideDown(Picture picture) {
//        Picture newPic = new Picture(width, height);
//        return newPic;
//    }
    // Returns a new picture that is a grayscale version the given picture.
    public static Picture grayScale(Picture picture) {

        int width = picture.width();
        int height = picture.height();
        Picture grayPic = new Picture(width, height);

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int r = picture.getColor(col, row).getRed();
                int g = picture.getColor(col, row).getGreen();
                int b = picture.getColor(col, row).getBlue();
                double luminance = 0.299 * r + 0.587 * g + 0.114 * b;
                int lum = (int) Math.round(luminance);
                Color gray = new Color(lum, lum, lum);
                grayPic.setColor(col, row, gray);
            }
        }
        return grayPic;

    }

    public static void main(String[] args) {
        Picture andrew = new Picture("src\\cw3\\Andrew.png");
        andrew.show();
        //upsideDown(andrew).show();
        //grayScale(andrew).show();

        //Picture udAndrew = new Picture("src\\cw3\\Expected\\UpsideDownAndrew.png");
        //System.out.println(udAndrew.equals(upsideDown(andrew)));
        //Picture grayAndrew = new Picture("src\\cw3\\Expected\\GrayAndrew.png");
        //System.out.println(grayAndrew.equals(grayScale(andrew)));
    }

}
