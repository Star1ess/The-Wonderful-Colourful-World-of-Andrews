package cw3;

import java.awt.Color;

/**
 * CPT105 2020 Coursework 3 Part B
 */
public class CW3_Part_B {

    /**
     * **************
     * CW3 Part B.1 * **************
     */
    // Original picture and positionally tranformed picture.
    public static Picture positionalTransform(Picture picture) {

        int width = picture.width();
        int height = picture.height();
        Picture picture1 = new Picture(width, height);
        int cenx = (int) (width / 2);
        int ceny = (int) (height / 2);
        int quater = width / 2;
        int m = 2;
        int rate = quater / m;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int distancex = (col - cenx);
                int distancey = (row - ceny);
                int distance = (int) Math.sqrt(distancex * distancex + distancey * distancey);
                if (distance < quater) {
                    int tx = (col - cenx) / m;
                    int ty = (row - ceny) / m;
                    tx = (tx * distance / rate) + cenx;
                    ty = (ty * distance / rate) + ceny;
                    if (tx < 0) {
                        tx = 0;
                    }
                    if (tx >= width) {
                        tx = width - 1;
                    }
                    if (ty < 0) {
                        ty = 0;
                    }
                    if (ty >= height) {
                        ty = height - 1;
                    }

                    picture1.setColor(col, row, picture.getColor(tx, ty));
                } else {
                    picture1.setColor(col, row, picture.getColor(col, row));
                }
            }
        }
        //以上是畸变

        Picture picture2 = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int newcol = width - 1 - col;
                Color inverse = picture1.getColor(newcol, row);
                picture2.setColor(col, row, inverse);
            }
        }
        //以上是镜像

        Picture picture3 = new Picture(width, height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                
                int newrow = (int) (row + 20 * Math.sin(2*col*Math.PI/100));
                if (newrow >= 0 && newrow < height ) {
                    picture3.setColor(col, row, picture2.getColor(col, newrow));
                }

            }
        }
        //以上是波纹

        Picture finalresult = new Picture(width * 2, height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                finalresult.setColor(col, row, picture.getColor(col, row));
            }
        }
        for (int row = 0; row < height; row++) {
            for (int col = width; col < width * 2; col++) {

                finalresult.setColor(col, row, picture3.getColor(col - width, row));
            }
        }

        return finalresult;

    }

    /**
     * **************
     * CW3 Part B.2 * **************
     */
    // Original picture and color tranformed picture.
    public static Picture colorTransform(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture picture1 = new Picture(width, height);

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

                int red = (-1 * picture.getColor(leftcol, uprow).getRed()) + (-2 * picture.getColor(col, uprow).getRed()) + (-1 * picture.getColor(rightcol, uprow).getRed())
                        + (0 * picture.getColor(leftcol, row).getRed()) + (0 * picture.getColor(col, row).getRed()) + (0 * picture.getColor(rightcol, row).getRed())
                        + (1 * picture.getColor(leftcol, downrow).getRed()) + (2 * picture.getColor(col, downrow).getRed()) + (2 * picture.getColor(rightcol, downrow).getRed());

                int green = (-1 * picture.getColor(leftcol, uprow).getGreen()) + (-2 * picture.getColor(col, uprow).getGreen()) + (-1 * picture.getColor(rightcol, uprow).getGreen())
                        + (0 * picture.getColor(leftcol, row).getGreen()) + (0 * picture.getColor(col, row).getGreen()) + (2 * picture.getColor(rightcol, row).getGreen())
                        + (1 * picture.getColor(leftcol, downrow).getGreen()) + (2 * picture.getColor(col, downrow).getGreen()) + (1 * picture.getColor(rightcol, downrow).getGreen());

                int blue = (-1 * picture.getColor(leftcol, uprow).getBlue()) + (-2 * picture.getColor(col, uprow).getBlue()) + (-1 * picture.getColor(rightcol, uprow).getBlue())
                        + (0 * picture.getColor(leftcol, row).getBlue()) + (0 * picture.getColor(col, row).getBlue()) + (0 * picture.getColor(rightcol, row).getBlue())
                        + (1 * picture.getColor(leftcol, downrow).getBlue()) + (2 * picture.getColor(col, downrow).getBlue()) + (1 * picture.getColor(rightcol, downrow).getBlue());

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
                picture1.setColor(col, row, color2);
            }
        }
        //以上是赛博朋克配色

        Picture picture2 = new Picture(width, height);

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

                int red = (-1 * picture1.getColor(leftcol, uprow).getRed()) + (-1 * picture1.getColor(col, uprow).getRed()) + (-1 * picture1.getColor(rightcol, uprow).getRed())
                        + (-1 * picture1.getColor(leftcol, row).getRed()) + (9 * picture1.getColor(col, row).getRed()) + (-1 * picture1.getColor(rightcol, row).getRed())
                        + (-1 * picture1.getColor(leftcol, downrow).getRed()) + (-1 * picture1.getColor(col, downrow).getRed()) + (-1 * picture1.getColor(rightcol, downrow).getRed());

                int green = (-1 * picture1.getColor(leftcol, uprow).getGreen()) + (-1 * picture1.getColor(col, uprow).getGreen()) + (-1 * picture1.getColor(rightcol, uprow).getGreen())
                        + (-1 * picture1.getColor(leftcol, row).getGreen()) + (9 * picture1.getColor(col, row).getGreen()) + (-1 * picture1.getColor(rightcol, row).getGreen())
                        + (-1 * picture1.getColor(leftcol, downrow).getGreen()) + (-1 * picture1.getColor(col, downrow).getGreen()) + (-1 * picture1.getColor(rightcol, downrow).getGreen());

                int blue = (-1 * picture1.getColor(leftcol, uprow).getBlue()) + (-1 * picture1.getColor(col, uprow).getBlue()) + (-1 * picture1.getColor(rightcol, uprow).getBlue())
                        + (-1 * picture1.getColor(leftcol, row).getBlue()) + (9 * picture1.getColor(col, row).getBlue()) + (-1 * picture1.getColor(rightcol, row).getBlue())
                        + (-1 * picture1.getColor(leftcol, downrow).getBlue()) + (-1 * picture1.getColor(col, downrow).getBlue()) + (-1 * picture1.getColor(rightcol, downrow).getBlue());

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
                picture2.setColor(col, row, color2);

            }
        }
        //以上是锐化

        Picture finalresult = new Picture(width * 2, height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                finalresult.setColor(col, row, picture.getColor(col, row));
            }
        }
        for (int row = 0; row < height; row++) {
            for (int col = width; col < width * 2; col++) {

                finalresult.setColor(col, row, picture2.getColor(col - width, row));
            }
        }

        return finalresult;

    }

    public static void main(String[] args) {
        Picture andrew = new Picture("src\\cw3\\Andrew.png");
        andrew.show();

        positionalTransform(andrew).show();
        colorTransform(andrew).show();

    }
}
