import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.*;



public class Main {
    public static void main(String[] args) throws Exception {
        BufferedImage newImage1 = new BufferedImage(800,600, BufferedImage.TYPE_INT_RGB);
        ImageIO.write(newImage1, "png", new File("inPNG.png")); // создание первого изображения

        BufferedImage newImage2 = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
        ImageIO.write(newImage2, "jpg", new File("inJPG.jpg")); // создание второго изображения

        BufferedImage newImage3 = new BufferedImage(800,600, BufferedImage.TYPE_INT_RGB);
        ImageIO.write(newImage3, "gif", new File("inGIF.gif")); // создание третьего изображения

        BufferedImage newImage4 = new BufferedImage(800,600, BufferedImage.TYPE_INT_RGB);
        ImageIO.write(newImage4, "png", new File("inPNG2.png")); // создание четвертого изображения

        BufferedImage newImage5 = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
        ImageIO.write(newImage5, "jpg", new File("inJPG2.jpg")); // создание пятого изображения




        String type1 = ".png"; // первый параметр расширения
        String type2 = ".jpg"; // второй параметр расширения
        createImageConvert(type1, type2); // задание 4.1 + 4.2


    }

    public static void createImageConvert(String type1, String type2) throws Exception {
        File[] files = new File(".").listFiles(); // список файлов и каталогов текущей директории
        for (File f : files) {
            if (f.isDirectory()) continue;
            else {
                String extension = f.getName().substring(f.getName().indexOf("."));
                if ((extension.equals(type1))) {
                    int lastIndex = f.getName().lastIndexOf(".");
                    File new_f_name = new File(f.getName().substring(0, lastIndex) + type2);
                    f.renameTo(new_f_name); // переименование файла

                    BufferedImage img = ImageIO.read(new File(new_f_name.getName()));
                    Graphics2D g = img.createGraphics();
                    g.setColor(Color.BLUE);
                    int w = 150;
                    g.drawRect ( (img.getWidth()-w)/2, (img.getHeight()-w)/2, w, w );
                    g.drawString("Hello,", (img.getWidth())/2 - (w/4),(img.getHeight())/2);
                    g.drawString("World!", (img.getWidth())/2 - (w/4),(img.getHeight())/2 + (w/4));
                    g.dispose();
                    ImageIO.write(img, "jpg", new File(new_f_name.getName())); // построение квадрата с текстом внутри
                }
            }
        }
    }
}
