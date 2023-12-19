import java.awt.image.BufferedImage;
import java.io.*;
import org.junit.jupiter.api.Assertions;
import javax.imageio.ImageIO;


class MainTest {

    @org.junit.jupiter.api.Test
    void createImageConvert() throws Exception {
            int x = 0;
            Main img = new Main();
            BufferedImage newImage1 = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            ImageIO.write(newImage1, "png", new File("inPNG.png")); // создание первого изображения

            BufferedImage newImage2 = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            ImageIO.write(newImage2, "jpg", new File("inJPG.jpg")); // создание второго изображения

            BufferedImage newImage3 = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            ImageIO.write(newImage3, "gif", new File("inGIF.gif")); // создание третьего изображения

            BufferedImage newImage4 = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            ImageIO.write(newImage4, "png", new File("inPNG2.png")); // создание четвертого изображения

            BufferedImage newImage5 = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            ImageIO.write(newImage5, "jpg", new File("inJPG2.jpg")); // создание пятого изображения

            BufferedImage newImage6 = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            ImageIO.write(newImage6, "png", new File("inPNG2.jpg")); // шестое изображение, которое дублирует по названию будущее отредактированное
            img.createImageConvert(".png", ".jpg");
            File[] files = new File("F:\\Программирование\\Intellij IDEA\\ImageProcessing").listFiles();
            for (File f : files) {
                if (f.isDirectory()) continue;
                else {
                    String extension = f.getName().substring(f.getName().indexOf("."));
                    if (extension.equals(".png")) {
                        x++;
                    }
                }
            }
            Assertions.assertTrue(x < 1); // есть необработанные изображения
    }
}