package cw3;

import java.awt.Color;

/**
 * CPT105 2020 Coursework 3 Part A
 */
public class CW3_Part_A {

    /**
     * **************
     * CW3 Part A.1 * **************
     */
    // Returns a new picture that tilts it 30 degrees clockwise.
    public static Picture tilt(Picture picture) {
        int height = picture.height();
        int width = picture.width();
        Picture result1 = new Picture(width, height);
        double c = 0.5 * (width - 1);
        double r = 0.5 * (height - 1);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int cn = (int) ((col - c) * Math.cos(Math.toRadians(330)) - (row - r) * Math.sin(Math.toRadians(330)) + c);
                int rn = (int) ((col - c) * Math.sin(Math.toRadians(330)) + (row - r) * Math.cos(Math.toRadians(330)) + r);
                if (0 <= cn && cn < width && 0 <= rn && rn < height) {
                    Color color1 = picture.getColor(cn, rn);
                    result1.setColor(col, row, color1);
                }
            }
        }
        return result1;

    }

    /**
     * **************
     * CW3 Part A.2 * **************
     */
    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture result2 = new Picture(width, height);

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {

                int uprow;
                int leftcol;
                int downrow;
                int rightcol;

                if (row == 0) {
                    uprow = height - 1;
                } else {
                    uprow = row - 1;
                }

                if (row == height - 1) {
                    downrow = 0;
                } else {
                    downrow = row + 1;
                }

                if (col == 0) {
                    leftcol = width - 1;
                } else {
                    leftcol = col - 1;
                }

                if (col == width - 1) {
                    rightcol = 0;
                } else {
                    rightcol = col + 1;
                }

                int red = (-2 * picture.getColor(leftcol, uprow).getRed()) + (-1 * picture.getColor(col, uprow).getRed()) + (0 * picture.getColor(rightcol, uprow).getRed())
                        + (-1 * picture.getColor(leftcol, row).getRed()) + (1 * picture.getColor(col, row).getRed()) + (1 * picture.getColor(rightcol, row).getRed())
                        + (0 * picture.getColor(leftcol, downrow).getRed()) + (1 * picture.getColor(col, downrow).getRed()) + (2 * picture.getColor(rightcol, downrow).getRed());

                int green = (-2 * picture.getColor(leftcol, uprow).getGreen()) + (-1 * picture.getColor(col, uprow).getGreen()) + (0 * picture.getColor(rightcol, uprow).getGreen())
                        + (-1 * picture.getColor(leftcol, row).getGreen()) + (1 * picture.getColor(col, row).getGreen()) + (1 * picture.getColor(rightcol, row).getGreen())
                        + (0 * picture.getColor(leftcol, downrow).getGreen()) + (1 * picture.getColor(col, downrow).getGreen()) + (2 * picture.getColor(rightcol, downrow).getGreen());

                int blue = (-2 * picture.getColor(leftcol, uprow).getBlue()) + (-1 * picture.getColor(col, uprow).getBlue()) + (0 * picture.getColor(rightcol, uprow).getBlue())
                        + (-1 * picture.getColor(leftcol, row).getBlue()) + (1 * picture.getColor(col, row).getBlue()) + (1 * picture.getColor(rightcol, row).getBlue())
                        + (0 * picture.getColor(leftcol, downrow).getBlue()) + (1 * picture.getColor(col, downrow).getBlue()) + (2 * picture.getColor(rightcol, downrow).getBlue());

                if (red < 0) {
                    red = 0;
                }
                if (red > 255) {
                    red = 255;
                }

                if (green < 0) {
                    green = 0;
                }
                if (green > 255) {
                    green = 255;
                }

                if (blue < 0) {
                    blue = 0;
                }
                if (blue > 255) {
                    blue = 255;
                }

                Color color2 = new Color(red, green, blue);
                result2.setColor(col, row, color2);

            }
        }

        return result2;

    }

    /**
     * **************
     * CW3 Part A.3 * **************
     */
    // Returns a new picture that applies a blur filter to the given picture.
    public static Picture blur(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture result3 = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int up4row = row - 4;
                int left4col = col - 4;
                int up3row = row - 3;
                int left3col = col - 3;
                int up2row = row - 2;
                int left2col = col - 2;
                int up1row = row - 1;
                int left1col = col - 1;
                int down1row = row + 1;
                int right1col = col + 1;
                int down2row = row + 2;
                int right2col = col + 2;
                int down3row = row + 3;
                int right3col = col + 3;
                int down4row = row + 4;
                int right4col = col + 4;
                if (row == 0) {
                    up4row = height - 4;
                    up3row = height - 3;
                    up2row = height - 2;
                    up1row = height - 1;
                }
                if (row == 1) {
                    up4row = height - 3;
                    up3row = height - 2;
                    up2row = height - 1;
                }
                if (row == 2) {
                    up4row = height - 2;
                    up3row = height - 1;
                }
                if (row == 3) {
                    up4row = height - 1;
                }
                if (row == height - 1) {
                    down1row = 0;
                    down2row = 1;
                    down3row = 2;
                    down4row = 3;
                }
                if (row == height - 2) {
                    down2row = 0;
                    down3row = 1;
                    down4row = 2;
                }
                if (row == height - 3) {
                    down3row = 0;
                    down4row = 1;
                }
                if (row == height - 4) {
                    down4row = 0;
                }
                if (col == 0) {
                    left4col = width - 4;
                    left3col = width - 3;
                    left2col = width - 2;
                    left1col = width - 1;
                }
                if (col == 1) {
                    left4col = width - 3;
                    left3col = width - 2;
                    left2col = width - 1;
                }
                if (col == 2) {
                    left4col = width - 2;
                    left3col = width - 1;
                }
                if (col == 3) {
                    left4col = width - 1;
                }
                if (col == width - 1) {
                    right1col = 0;
                    right2col = 1;
                    right3col = 2;
                    right4col = 3;
                }
                if (col == width - 2) {
                    right2col = 0;
                    right3col = 1;
                    right4col = 2;
                }
                if (col == width - 3) {
                    right3col = 0;
                    right4col = 1;
                }
                if (col == width - 4) {
                    right4col = 0;
                }

                double red = ((picture.getColor(left4col, up4row).getRed() + picture.getColor(left3col, up3row).getRed() + picture.getColor(left2col, up2row).getRed()
                        + picture.getColor(left1col, up1row).getRed() + picture.getColor(col, row).getRed() + picture.getColor(right1col, down1row).getRed()
                        + picture.getColor(right2col, down2row).getRed() + picture.getColor(right3col, down3row).getRed() + picture.getColor(right4col, down4row).getRed()) / 9.0);

                double green = ((picture.getColor(left4col, up4row).getGreen() + picture.getColor(left3col, up3row).getGreen() + picture.getColor(left2col, up2row).getGreen()
                        + picture.getColor(left1col, up1row).getGreen() + picture.getColor(col, row).getGreen() + picture.getColor(right1col, down1row).getGreen()
                        + picture.getColor(right2col, down2row).getGreen() + picture.getColor(right3col, down3row).getGreen() + picture.getColor(right4col, down4row).getGreen()) / 9.0);

                double blue = ((picture.getColor(left4col, up4row).getBlue() + picture.getColor(left3col, up3row).getBlue() + picture.getColor(left2col, up2row).getBlue()
                        + picture.getColor(left1col, up1row).getBlue() + picture.getColor(col, row).getBlue() + picture.getColor(right1col, down1row).getBlue()
                        + picture.getColor(right2col, down2row).getBlue() + picture.getColor(right3col, down3row).getBlue() + picture.getColor(right4col, down4row).getBlue()) / 9.0);

                int redi = (int) Math.round(red);
                if (redi < 0) {
                    redi = 0;
                }
                if (redi > 255) {
                    redi = 255;
                }

                int greeni = (int) Math.round(green);
                if (greeni < 0) {
                    greeni = 0;
                }
                if (greeni > 255) {
                    greeni = 255;
                }

                int bluei = (int) Math.round(blue);
                if (bluei < 0) {
                    bluei = 0;
                }
                if (bluei > 255) {
                    bluei = 255;
                }

                Color color3 = new Color(redi, greeni, bluei);
                result3.setColor(col, row, color3);

            }
        }

        return result3;
    }

    /**
     * **************
     * CW3 Part A.4 * **************
     */
    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture edge(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture grayPic = CW3_Example.grayScale(picture);
        Picture result4 = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int uprowx = row - 1;
                int leftcolx = col - 1;
                int downrowx = row + 1;
                int rightcolx = col + 1;

                if (row == 0) {
                    uprowx = height - 1;
                }
                if (row == height - 1) {
                    downrowx = 0;
                }
                if (col == 0) {
                    leftcolx = width - 1;
                }
                if (col == width - 1) {
                    rightcolx = 0;
                }
                int gx = (-1 * grayPic.getColor(leftcolx, uprowx).getRed()) + (0 * grayPic.getColor(col, uprowx).getRed())
                        + (1 * grayPic.getColor(rightcolx, uprowx).getRed()) + (-2 * grayPic.getColor(leftcolx, row).getRed())
                        + (0 * grayPic.getColor(col, row).getRed()) + (2 * grayPic.getColor(rightcolx, row).getRed())
                        + (-1 * grayPic.getColor(leftcolx, downrowx).getRed()) + (0 * grayPic.getColor(col, downrowx).getRed()) + (1 * grayPic.getColor(rightcolx, downrowx).getRed());

                int uprowy = row - 1;
                int leftcoly = col - 1;
                int downrowy = row + 1;
                int rightcoly = col + 1;

                if (row == 0) {
                    uprowy = height - 1;
                }
                if (row == height - 1) {
                    downrowy = 0;
                }
                if (col == 0) {
                    leftcoly = width - 1;
                }
                if (col == width - 1) {
                    rightcoly = 0;
                }
                int gy = (1 * grayPic.getColor(leftcoly, uprowy).getRed()) + (2 * grayPic.getColor(col, uprowy).getRed())
                        + (1 * grayPic.getColor(rightcoly, uprowy).getRed()) + (0 * grayPic.getColor(leftcoly, row).getRed())
                        + (0 * grayPic.getColor(col, row).getRed()) + (0 * grayPic.getColor(rightcoly, row).getRed())
                        + (-1 * grayPic.getColor(leftcoly, downrowy).getRed()) + (-2 * grayPic.getColor(col, downrowy).getRed()) + (-1 * grayPic.getColor(rightcoly, downrowy).getRed());

                double Gg = Math.sqrt(gx * gx + gy * gy);
                int G = (int) (Gg);
                if (G < 0) {
                    G = 0;
                }
                if (G > 255) {
                    G = 255;
                }

                int Ggf = 255 - G;

                Color color4 = new Color(Ggf, Ggf, Ggf);
                result4.setColor(col, row, color4);
            }
        }
        return result4;

    }

    public static void main(String[] args) {

        Picture andrew = new Picture("src\\cw3\\Andrew.png");
        andrew.show();

        tilt(andrew).show();
        Picture tiltAndrew = new Picture("src\\cw3\\Expected\\TiltAndrew.png");
        System.out.println(tilt(andrew).equals(tiltAndrew));

        emboss(andrew).show();
        Picture embossAndrew = new Picture("src\\cw3\\Expected\\EmbossAndrew.png");
        System.out.println(emboss(andrew).equals(embossAndrew));

        blur(andrew).show();
        Picture blurAndrew = new Picture("src\\cw3\\Expected\\BlurAndrew.png");
        System.out.println(blur(andrew).equals(blurAndrew));

        edge(andrew).show();
        Picture edgeAndrew = new Picture("src\\cw3\\Expected\\EdgeAndrew.png");
        System.out.println(edge(andrew).equals(edgeAndrew));
    }

}
