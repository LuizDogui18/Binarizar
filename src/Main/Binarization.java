package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Binarization {
    public static void main(String[] args) throws IOException {
        try {
            // Carrega a imagem
            BufferedImage image = ImageIO.read(new File("C:\\Users\\DELL\\IdeaProjects\\Binarizar\\src\\Imagem\\sombrinhas.jpg"));

            // Define o limiar de binarização
            int threshold = 128; // Valor de limiar, pode ser ajustado conforme necessário

            // Obtém as dimensões da imagem
            int width = image.getWidth();
            int height = image.getHeight();

            // Percorre cada pixel na imagem
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Obtém o pixel na posição (x, y)
                    Color pixelColor = new Color(image.getRGB(x, y));

                    // Calcula o valor de cinza (média das componentes RGB)
                    int grayValue = (pixelColor.getRed() + pixelColor.getGreen() + pixelColor.getBlue()) / 3;

                    // Verifica se o valor de cinza é menor que o limiar
                    if (grayValue < threshold) {
                        // Define o pixel como preto
                        image.setRGB(x, y, Color.BLACK.getRGB());
                    } else {
                        // Define o pixel como branco
                        image.setRGB(x, y, Color.WHITE.getRGB());
                    }
                }
            }

            // Salva a imagem binarizada
            File output = new File("C:\\Users\\DELL\\IdeaProjects\\Binarizar\\src\\Imagem\\sombrinhas.jpg");
            ImageIO.write(image, "jpg", output);

            System.out.println("Binarização concluída. Imagem salva como output.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
