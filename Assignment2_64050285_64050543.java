//64050285 Aekapab  Sukkasem
//64050543 Pariyakorn  Pramoonsin 
import java.util.concurrent.TimeUnit;
import java.awt.*;
import javax.swing.*;

public class Assignment2_64050285_64050543 extends JPanel implements Runnable {
    long fps = 1000 / 4;
    int size = 6;
    int cloudPosition = 0;
    int cloudSpeed = 6;
    int flowerSpeed = 6;
    int cntFrame = 0;

    public static void main(String[] args) {
        Assignment2_64050285_64050543 m = new Assignment2_64050285_64050543();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Graphics");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        (new Thread(m)).start();
    }

    @Override
    public void run() {
        while (true) {
            long start = System.currentTimeMillis();

            // code here
            cloudPosition += cloudSpeed;
            if (cloudPosition >= 30)
                cloudPosition = 0;
            flowerSpeed = (flowerSpeed + 6) % 12;
            cntFrame = (++cntFrame) % 6;
            repaint();
            // end code

            long end = System.currentTimeMillis();
            long sleep = fps - (end - start) - 1;
            try {
                TimeUnit.MILLISECONDS.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {

        // sky
        g.setColor(Color.decode("#bd75ff"));
        g.fillRect(0, 0, 600, 36);

        sicksack(g, 0, 18, 599, Color.decode("#ff7bff"));
        sicksack(g, 6, 30, 599, Color.decode("#ff7bff"));
        g.setColor(Color.decode("#ff7bff"));
        g.fillRect(0, 36, 600, 45);
        sicksack(g, 0, 42, 599, Color.decode("#bd75ff"));

        sicksack(g, 0, 72, 599, Color.decode("#ffbcda"));
        g.setColor(Color.decode("#ffbcda"));
        g.fillRect(0, 78, 600, 30);
        sicksack(g, 6, 84, 599, Color.decode("#ff7bff"));

        sicksack(g, 6, 102, 599, Color.decode("#ffcace"));
        g.setColor(Color.decode("#ffcace"));
        g.fillRect(0, 108, 600, 37);
        sicksack(g, 0, 115, 599, Color.decode("#ffbcda"));

        sicksack(g, 6, 138, 599, Color.decode("#fff2aa"));
        g.setColor(Color.decode("#fff2aa"));
        g.fillRect(0, 144, 600, 36);
        sicksack(g, 0, 150, 599, Color.decode("#ffcace"));

        sicksack(g, 6, 174, 599, Color.decode("#fdfec6"));
        g.setColor(Color.decode("#fdfec6"));
        g.fillRect(0, 180, 600, 35);
        sicksack(g, 0, 186, 599, Color.decode("#fff2aa"));

        createStars(g);

        // circle 116
        g.setColor(Color.decode("#fefefe"));
        g.fillOval(288, 155, 116, 116);
        g.setColor(Color.decode("#fffdf2"));
        midpointEllipse(g, 346, 213, 58, 58);

        // water
        g.setColor(Color.decode("#80ddea"));
        g.fillRect(0, 216, 600, 384);
        g.setColor(Color.decode("#5494d8"));
        bresenhamsLine(g, 0, 216, 118, 216);
        bresenhamsLine(g, 0, 222, 71, 222);
        bresenhamsLine(g, 0, 228, 40, 228);
        bresenhamsLine(g, 534, 216, 600, 216);
        bresenhamsLine(g, 552, 222, 600, 222);
        bresenhamsLine(g, 575, 228, 599, 228);
        bresenhamsLine(g, 582, 234, 600, 234);
        g.setColor(Color.decode("#54ccd8"));
        bresenhamsLine(g, 462, 216, 533, 216);
        bresenhamsLine(g, 516, 222, 551, 222);
        bresenhamsLine(g, 498, 222, 504, 222);

        bresenhamsLine(g, 192, 217, 259, 217);
        bresenhamsLine(g, 162, 222, 180, 222);
        bresenhamsLine(g, 72, 222, 143, 222);
        bresenhamsLine(g, 120, 216, 157, 216);
        bresenhamsLine(g, 42, 228, 109, 228);
        bresenhamsLine(g, 83, 234, 0, 234);
        g.setColor(Color.decode("#68ced9"));
        g.fillRect(0, 240, 47, 23);
        g.fillRect(0, 269, 12, 12);
        g.fillRect(12, 269, 12, 6);
        g.fillRect(24, 263, 11, 6);
        g.fillRect(43, 252, 16, 11);
        g.fillRect(47, 240, 12, 6);
        g.fillRect(85, 234, 118, 6);
        g.fillRect(150, 228, 41, 6);
        g.fillRect(65, 246, 72, 6);
        g.fillRect(59, 252, 42, 6);
        g.fillRect(120, 240, 47, 6);
        plot(g, 570, 228);

        g.fillRect(582, 240, 18, 30);
        g.fillRect(564, 258, 18, 12);
        bresenhamsLine(g, 552, 258, 564, 258);
        g.fillRect(588, 275, 12, 12);
        plot(g, 594, 287);
        plot(g, 582, 275);
        bresenhamsLine(g, 528, 246, 600, 246);
        bresenhamsLine(g, 504, 234, 581, 234);
        g.fillRect(492, 228, 17, 6);
        g.fillRect(515, 240, 13, 6);
        plot(g, 558, 240);
        g.setColor(Color.decode("#fdfecc"));
        g.fillRect(282, 240, 88, 12);
        g.fillRect(240, 252, 30, 6);
        plot(g, 390, 306);
        plot(g, 425, 312);
        g.fillRect(431, 318, 30, 6);
        g.fillRect(485, 342, 24, 6);

        g.setColor(Color.decode("#fef2b2"));
        g.fillRect(288, 222, 120, 12);
        g.fillRect(252, 228, 50, 12);
        g.fillRect(342, 240, 107, 6);
        g.fillRect(414, 222, 30, 12);
        g.fillRect(360, 264, 30, 6);
        g.fillRect(366, 246, 12, 6);
        g.fillRect(414, 252, 24, 12);
        g.fillRect(402, 258, 12, 6);
        g.fillRect(432, 264, 30, 18);
        g.fillRect(420, 276, 18, 6);
        g.fillRect(420, 294, 36, 6);
        g.fillRect(456, 300, 36, 6);
        plot(g, 180, 270);
        plot(g, 270, 240);
        plot(g, 210, 300);

        g.setColor(Color.decode("#feccce"));
        g.fillRect(365, 222, 56, 6);
        g.fillRect(444, 233, 54, 6);
        plot(g, 492, 238);
        g.fillRect(468, 244, 42, 6);
        g.fillRect(456, 250, 12, 6);
        g.fillRect(462, 288, 78, 12);
        g.fillRect(438, 264, 82, 12);
        g.fillRect(402, 270, 60, 6);
        plot(g, 402, 264);
        g.fillRect(354, 258, 30, 6);
        g.fillRect(348, 252, 12, 6);
        g.fillRect(402, 288, 60, 6);
        plot(g, 540, 294);
        g.fillRect(288, 240, 12, 6);

        g.fillRect(162, 300, 48, 6);
        g.fillRect(120, 306, 42, 6);
        plot(g, 114, 300);
        g.fillRect(174, 282, 35, 12);
        bresenhamsLine(g, 156, 288, 174, 288);
        g.fillRect(108, 288, 42, 6);
        g.fillRect(186, 258, 12, 6);
        bresenhamsLine(g, 174, 246, 271, 246);
        g.fillRect(192, 228, 60, 6);
        g.fillRect(185, 270, 12, 6);
        g.fillRect(192, 276, 12, 6);
        g.fillRect(144, 276, 30, 6);
        plot(g, 18, 306);

        g.setColor(Color.decode("#febfda"));
        g.fillRect(426, 222, 30, 6);
        g.fillRect(474, 228, 12, 6);
        g.fillRect(462, 239, 30, 6);
        g.fillRect(426, 252, 30, 6);// pb
        g.fillRect(468, 252, 12, 6);// pb
        g.fillRect(438, 264, 18, 6);
        plot(g, 474, 270);
        g.fillRect(486, 270, 42, 6);
        g.fillRect(528, 276, 12, 6);
        g.fillRect(420, 288, 54, 6);
        g.fillRect(480, 288, 60, 6);
        g.fillRect(384, 264, 18, 6);
        plot(g, 462, 282);

        g.fillRect(252, 228, 18, 6);
        g.fillRect(222, 234, 30, 6);
        g.fillRect(252, 240, 18, 6);
        g.fillRect(108, 264, 90, 6);
        g.fillRect(168, 258, 12, 6);
        g.fillRect(156, 270, 18, 6);
        g.fillRect(174, 276, 12, 6);
        g.fillRect(132, 276, 12, 6);
        g.fillRect(78, 282, 18, 6);
        g.fillRect(72, 294, 12, 6);
        g.fillRect(60, 288, 24, 6);
        g.fillRect(90, 294, 84, 6);
        g.fillRect(84, 300, 24, 6);
        g.fillRect(108, 306, 12, 6);
        g.fillRect(162, 306, 30, 6);
        g.fillRect(108, 318, 88, 6);
        g.fillRect(108, 264, 88, 6);
        g.fillRect(24, 306, 60, 6);
        g.fillRect(72, 270, 46, 6);
        plot(g, 12, 306);

        g.setColor(Color.decode("#a8f6fe"));
        g.fillRect(378, 246, 30, 6);
        g.fillRect(372, 252, 12, 6);
        g.fillRect(489, 252, 30, 6);
        g.fillRect(378, 270, 24, 6);
        g.fillRect(552, 306, 24, 6);
        g.fillRect(540, 312, 18, 6);
        g.fillRect(498, 318, 42, 6);
        g.fillRect(426, 336, 35, 6);
        g.fillRect(456, 330, 12, 6);
        g.fillRect(384, 318, 42, 6);
        g.fillRect(390, 354, 30, 6);
        g.fillRect(414, 360, 30, 6);

        g.fillRect(204, 240, 24, 6);
        g.fillRect(144, 246, 18, 6);
        g.fillRect(126, 252, 24, 6);
        g.fillRect(72, 258, 36, 6);
        plot(g, 72, 264);
        g.fillRect(42, 270, 30, 6);
        g.fillRect(12, 282, 30, 6);
        g.fillRect(78, 324, 24, 6);
        g.fillRect(108, 336, 42, 6);
        g.fillRect(150, 330, 36, 6);
        g.fillRect(185, 336, 18, 6);
        plot(g, 108, 330);

        createSeaLight(g);

        // bg grass
        g.setColor(Color.decode("#bafeca"));
        bresenhamsLine(g, 0, 354, 23, 354);
        bresenhamsLine(g, 0, 360, 65, 360);
        bresenhamsLine(g, 0, 366, 107, 366);
        bresenhamsLine(g, 0, 372, 137, 372);
        bresenhamsLine(g, 0, 378, 173, 378);
        bresenhamsLine(g, 444, 378, 600, 378);
        bresenhamsLine(g, 462, 372, 600, 372);
        bresenhamsLine(g, 468, 366, 600, 366);
        plot(g, 468, 360);
        plot(g, 473, 354);
        plot(g, 504, 360);
        bresenhamsLine(g, 552, 360, 600, 360);
        bresenhamsLine(g, 570, 354, 600, 354);
        bresenhamsLine(g, 582, 348, 600, 348);
        bresenhamsLine(g, 594, 342, 600, 342);
        g.fillRect(0, 384, 600, 216);

        g.setColor(Color.decode("#fdfecc"));
        bresenhamsLine(g, 0, 348, 35, 348);
        bresenhamsLine(g, 24, 354, 71, 354);
        bresenhamsLine(g, 66, 360, 113, 360);
        bresenhamsLine(g, 108, 366, 143, 366);
        bresenhamsLine(g, 138, 372, 179, 372);
        bresenhamsLine(g, 174, 378, 401, 384);
        bresenhamsLine(g, 390, 378, 443, 378);
        bresenhamsLine(g, 438, 372, 461, 372);
        bresenhamsLine(g, 474, 366, 500, 366);
        bresenhamsLine(g, 510, 366, 527, 366);
        bresenhamsLine(g, 522, 360, 551, 360);
        bresenhamsLine(g, 552, 354, 569, 354);
        bresenhamsLine(g, 552, 348, 581, 348);
        bresenhamsLine(g, 576, 342, 593, 342);
        bresenhamsLine(g, 582, 336, 600, 336);
        bresenhamsLine(g, 546, 336, 553, 336);
        plot(g, 552, 342);
        plot(g, 582, 330);
        bresenhamsLine(g, 90, 348, 90, 359);
        bresenhamsLine(g, 48, 330, 48, 353);
        plot(g, 53, 330);
        bresenhamsLine(g, 18, 324, 18, 347);
        bresenhamsLine(g, 23, 342, 35, 342);
        bresenhamsLine(g, 30, 336, 40, 336);

        createGrassBG(g);
        createShadow(g);
        createCloud(g);
        createFlower(g);
        createMainOpject(g);

    }

    public void createGrassBG(Graphics g) {
        g.setColor(Color.decode("#fdfecc"));

        plot(g, 42, 372);
        plot(g, 66, 372);
        plot(g, 60, 390);
        plot(g, 90, 378);
        plot(g, 114, 378);
        plot(g, 102, 402);
        plot(g, 150, 390);
        plot(g, 162, 396);
        plot(g, 144, 408);
        plot(g, 168, 420);
        plot(g, 144, 432);
        plot(g, 186, 432);
        plot(g, 216, 456);
        plot(g, 252, 480);
        plot(g, 366, 402);
        plot(g, 360, 438);
        plot(g, 360, 456);
        plot(g, 378, 444);
        plot(g, 378, 474);
        plot(g, 414, 396);
        plot(g, 408, 408);
        plot(g, 450, 426);
        plot(g, 444, 438);
        plot(g, 432, 450);
        plot(g, 444, 480);
        plot(g, 468, 390);
        plot(g, 486, 384);
        plot(g, 486, 396);
        plot(g, 498, 420);
        plot(g, 516, 390);

        g.setColor(Color.decode("#66c27a"));
        plot(g, 12, 378);
        plot(g, 12, 438);
        plot(g, 18, 504);
        plot(g, 36, 462);
        plot(g, 78, 408);
        plot(g, 132, 396);
        plot(g, 108, 426);
        plot(g, 120, 456);
        plot(g, 162, 456);
        plot(g, 174, 450);
        plot(g, 192, 450);
        plot(g, 144, 516);
        plot(g, 222, 576);
        plot(g, 264, 564);
        plot(g, 324, 564);
        plot(g, 366, 522);
        plot(g, 402, 504);
        plot(g, 414, 516);
        plot(g, 402, 564);
        plot(g, 468, 438);
        plot(g, 516, 420);
        plot(g, 516, 528);
        plot(g, 534, 402);
        plot(g, 582, 396);
        plot(g, 546, 474);
        plot(g, 576, 588);

    }

    public void createStars(Graphics g) {
        g.setColor(Color.decode("#fefefe"));
        plot(g, 30, 6);
        plot(g, 42, 48);
        plot(g, 186, 36);
        plot(g, 234, 18);
        plot(g, 264, 48);
        plot(g, 324, 12);
        plot(g, 372, 42);
        plot(g, 426, 12);
        plot(g, 510, 6);
        plot(g, 546, 36);
        plot(g, 582, 12);

    }

    public void createSeaLight(Graphics g) {
        g.setColor(Color.decode("#e4f8fb"));

        for (int i = 224; i < 370; i += 3)
            plot(g, random(0, 594), i);
    }

    public void createShadow(Graphics g) {
        Color c = Color.decode("#8adf9d");
        g.setColor(c);
        plot(g, 288, 438);
        plot(g, 282, 444);
        plot(g, 198, 474);
        plot(g, 354, 486);
        plot(g, 342, 498);
        plot(g, 258, 546);

        g.fillRect(330, 450, 12, 6);
        sicksack(g, 264, 450, 42, c);
        sicksack(g, 198, 456, 150, c);
        sicksack(g, 216, 462, 150, c);
        sicksack(g, 222, 468, 126, c);
        sicksack(g, 204, 474, 150, c);
        sicksack(g, 186, 480, 174, c);
        sicksack(g, 204, 486, 150, c);
        sicksack(g, 198, 492, 156, c);
        sicksack(g, 192, 498, 150, c);
        sicksack(g, 198, 504, 138, c);
        sicksack(g, 204, 510, 138, c);
        sicksack(g, 198, 516, 126, c);
        sicksack(g, 204, 522, 126, c);
        sicksack(g, 210, 528, 102, c);
        sicksack(g, 216, 534, 90, c);
        sicksack(g, 234, 540, 54, c);
        sicksack(g, 240, 546, 42, c);

        sicksack(g, 222, 528, 18, Color.decode("#bafeca"));

    }

    public void sicksack(Graphics g, int xs, int y, int xpixel, Color color) {
        g.setColor(color);
        int xn = xs + xpixel;
        for (int i = xs; i <= xn; i += 12) {
            plot(g, i, y);
        }
    }

    public void createCloud(Graphics g) {
        g.translate(cloudPosition, 0);
        // cloud 1
        g.setColor(Color.decode("#fdfecc"));
        bresenhamsLine(g, 90, 54, 113, 54);
        bresenhamsLine(g, 72, 60, 113, 60);
        bresenhamsLine(g, 60, 66, 125, 66);
        bresenhamsLine(g, 48, 72, 131, 72);
        bresenhamsLine(g, 48, 78, 137, 78);
        bresenhamsLine(g, 42, 84, 137, 84);
        g.setColor(Color.decode("#ccd9fe"));
        bresenhamsLine(g, 66, 72, 89, 72);
        bresenhamsLine(g, 54, 78, 101, 78);
        bresenhamsLine(g, 54, 84, 119, 84);
        bresenhamsLine(g, 42, 90, 125, 90);
        g.setColor(Color.decode("#cbf6fe"));
        plot(g, 78, 78);
        bresenhamsLine(g, 78, 66, 107, 66);
        bresenhamsLine(g, 90, 72, 113, 72);
        bresenhamsLine(g, 102, 78, 125, 78);
        bresenhamsLine(g, 66, 84, 77, 84);
        bresenhamsLine(g, 120, 84, 131, 84);
        bresenhamsLine(g, 72, 90, 101, 90);
        bresenhamsLine(g, 126, 90, 137, 90);

        // cloud 2
        g.setColor(Color.decode("#fdfecc"));
        plot(g, 204, 114);
        plot(g, 210, 120);
        plot(g, 222, 120);
        bresenhamsLine(g, 186, 108, 197, 108);
        g.setColor(Color.decode("#cbf6fe"));
        plot(g, 216, 120);
        bresenhamsLine(g, 174, 108, 185, 108);
        bresenhamsLine(g, 168, 114, 197, 114);
        bresenhamsLine(g, 156, 120, 209, 120);
        bresenhamsLine(g, 156, 126, 221, 126);
        g.setColor(Color.decode("#ccd9fe"));
        plot(g, 174, 114);
        plot(g, 198, 114);
        bresenhamsLine(g, 162, 120, 197, 120);
        bresenhamsLine(g, 156, 126, 173, 126);
        bresenhamsLine(g, 180, 126, 203, 126);
        plot(g, 222, 126);

        // cloud 3
        g.setColor(Color.decode("#fdfecc"));
        plot(g, 474, 90);
        g.fillRect(432, 96, 48, 12);
        bresenhamsLine(g, 426, 108, 437, 108);
        bresenhamsLine(g, 474, 114, 485, 114);

        g.setColor(Color.decode("#cbf6fe"));
        plot(g, 450, 96);
        plot(g, 426, 102);
        plot(g, 420, 108);
        bresenhamsLine(g, 468, 102, 485, 102);
        bresenhamsLine(g, 438, 108, 473, 108);
        bresenhamsLine(g, 414, 114, 473, 114);
        bresenhamsLine(g, 492, 114, 509, 114);
        bresenhamsLine(g, 408, 120, 419, 120);
        g.setColor(Color.decode("#ccd9fe"));
        plot(g, 468, 90);
        plot(g, 456, 96);
        plot(g, 432, 114);
        plot(g, 486, 114);
        bresenhamsLine(g, 480, 96, 497, 96);
        bresenhamsLine(g, 486, 102, 503, 102);
        bresenhamsLine(g, 474, 108, 533, 108);
        bresenhamsLine(g, 444, 114, 467, 114);
        bresenhamsLine(g, 510, 114, 539, 114);
        bresenhamsLine(g, 420, 120, 521, 120);
        g.translate(-cloudPosition, 0);

    }

    public void createFlower(Graphics g) {
        g.translate(flowerSpeed, 0);
        // flower petals
        g.setColor(Color.decode("#d6adfe"));
        plot(g, 18, 396);
        plot(g, 42, 396);
        plot(g, 30, 408);
        g.fillRect(24, 390, 18, 18);

        g.setColor(Color.decode("#fe8aec"));
        g.fillRect(66, 456 + flowerSpeed, 12, 6);
        g.fillRect(60, 462, 24, 18);
        g.fillRect(54, 468, 6, 12 - flowerSpeed);
        g.fillRect(60 + flowerSpeed * 4, 480 - flowerSpeed * 2, 18 - flowerSpeed * 2, 6);

        g.setColor(Color.decode("#d8a9ff"));
        plot(g, 102, 558);
        plot(g, 126, 558);
        g.fillRect(108, 552, 18, 18);

        g.translate(flowerSpeed, 0);
        g.setColor(Color.decode("#d6adfe"));
        plot(g, 174, 540);
        plot(g, 198, 540);
        g.fillRect(180, 534, 18, 18);
        g.translate(-flowerSpeed, 0);

        g.setColor(Color.decode("#fe89ed"));
        plot(g, 294, 522);
        plot(g, 318, 522);
        g.fillRect(300, 516, 18, 18);

        g.setColor(Color.decode("#d8a8ff"));
        plot(g, 360, 558);
        plot(g, 384, 558);
        g.fillRect(366, 552, 18, 18);

        g.setColor(Color.decode("#d6acfe"));
        plot(g, 492, 546);
        plot(g, 522, 546);
        g.fillRect(498, 540, 24, 18);

        g.setColor(Color.decode("#fe8aec"));
        plot(g, 474, 468);
        g.fillRect(486, 456, 18, 6);
        g.fillRect(480, 462, 30, 12);
        g.fillRect(480, 474, 24, 6);

        // center of flower
        g.setColor(Color.decode("#fdffca"));
        plot(g, 30, 396);
        plot(g, 114, 558);
        plot(g, 186 + flowerSpeed, 540);
        plot(g, 306, 522);
        plot(g, 372, 558);
        plot(g, 486, 468);
        plot(g, 492, 462);
        g.fillRect(66, 468, 6 + flowerSpeed, 6);
        g.fillRect(504, 546, 12, 6);

        g.translate(-flowerSpeed, 0);

        // stick of flower sort by left to right
        g.setColor(Color.decode("#6ac47e"));

        g.fillRect(30 + flowerSpeed * 2, 408, 6, 30 - flowerSpeed * 3);
        g.fillRect(36, 426 - flowerSpeed * 2, 6, 18 + flowerSpeed);
        plot(g, 42 - flowerSpeed * 2, 426);

        g.fillRect(66 + flowerSpeed, 486 - flowerSpeed, 6, 36);
        g.fillRect(60, 522, 6, 18);
        g.fillRect(72, 504, 6, 30);
        g.fillRect(78, 498 - flowerSpeed, 12, 6 + flowerSpeed);
        g.fillRect(84, 486, flowerSpeed * 2, 6);
        plot(g, 66, 522);
        plot(g, 78, 504);

        g.fillRect(108, 576 + flowerSpeed, 6, 12 - flowerSpeed);
        g.fillRect(114, 570, 6, 12);

        g.fillRect(186, 552 + flowerSpeed, 6, 18 - flowerSpeed * 2);
        g.fillRect(192, 564 - flowerSpeed * 2, 6, 12 + flowerSpeed * 2);
        g.fillRect(198, 558 - flowerSpeed, 6, 12 - flowerSpeed);

        g.fillRect(294 + flowerSpeed, 552, 12, 6);
        g.fillRect(306 + flowerSpeed, 534, 6, 18);
        plot(g, 300 + flowerSpeed, 546);

        g.fillRect(378, 576, 6, 12);
        g.fillRect(372 + flowerSpeed * 2, 570, 12 - flowerSpeed, 6);

        g.fillRect(492, 480, 6, 18 - flowerSpeed * 2);
        g.fillRect(498, 492 - flowerSpeed * 2, 6, 12 + flowerSpeed * 2);
        g.fillRect(504, 480, flowerSpeed, 12);

        g.fillRect(504 + flowerSpeed, 558, 6, 24 - flowerSpeed);
        plot(g, 510 + flowerSpeed, 558);
        plot(g, 498 + flowerSpeed, 576);

    }

    public void createMainOpject(Graphics g) {
        // body color
        g.setColor(Color.decode("#feebf9"));
        g.fillRect(204, 324, 18, 18);
        g.fillRect(198, 366, 18, 48);
        g.fillRect(234, 258, 54, 156);
        g.fillRect(288, 252, 60, 168);
        g.fillRect(348, 282, 30, 102);
        g.fillRect(348, 384, 18, 24);
        g.fillRect(378, 348, 6, 18);

        plot(g, 198, 318);
        plot(g, 378, 312);

        g.setColor(Color.decode("#fec2ee"));
        plot(g, 246, 264);
        plot(g, 240, 270);
        plot(g, 228, 276);
        plot(g, 234, 282);
        plot(g, 240, 288);
        plot(g, 318, 294);
        plot(g, 198, 324);
        plot(g, 204, 330);
        plot(g, 210, 336);
        plot(g, 204, 390);
        plot(g, 198, 396);
        plot(g, 204, 402);
        plot(g, 198, 408);
        plot(g, 300, 330);
        plot(g, 336, 336);
        plot(g, 360, 390);

        g.fillRect(192, 378, 6, 30);
        g.fillRect(198, 414, 24, 12);
        g.fillRect(294, 276, 24, 24);
        g.fillRect(300, 270, 12, 36);
        g.fillRect(306, 300, 36, 12);
        g.fillRect(240, 300, 12, 18);
        g.fillRect(234, 318, 12, 18);
        g.fillRect(222, 324, 12, 78);
        g.fillRect(204, 342, 18, 24);
        g.fillRect(210, 408, 12, 8);
        g.fillRect(198, 414, 102, 12);
        g.fillRect(210, 426, 90, 12);
        g.fillRect(252, 438, 30, 6);
        g.fillRect(294, 312, 6, 18);
        g.fillRect(294, 312, 6, 18);
        g.fillRect(288, 342, 12, 6);
        g.fillRect(306, 348, 12, 12);
        g.fillRect(342, 324, 6, 12);
        g.fillRect(216, 372, 42, 42);
        g.fillRect(222, 366, 36, 6);
        g.fillRect(234, 348, 18, 18);
        g.fillRect(300, 420, 42, 24);
        g.fillRect(330, 414, 12, 6);
        g.fillRect(342, 408, 12, 24);
        g.fillRect(354, 396, 6, 12);

        g.setColor(Color.decode("#fea3e6"));
        plot(g, 240, 294);
        plot(g, 318, 300);
        plot(g, 342, 336);
        plot(g, 336, 432);
        plot(g, 306, 444);

        g.fillRect(312, 438, 24, 6);
        g.fillRect(228, 432, 12, 12);

        g.setColor(Color.decode("#fdfecc"));
        g.fillRect(252, 264, 18, 6);
        g.fillRect(270, 258, 18, 6);
        g.fillRect(288, 252, 12, 6);
        g.fillRect(330, 252, 12, 6);
        g.fillRect(342, 258, 6, 12);
        g.fillRect(348, 270, 6, 18);
        plot(g, 210, 318);

        g.setColor(Color.decode("#fefefe"));
        g.fillRect(330, 264, 12, 24);
        g.fillRect(312, 444, 18, 6);
        g.fillRect(264, 444, 18, 6);

        plot(g, 276, 246);
        plot(g, 330, 270);
        plot(g, 204, 318);
        plot(g, 198, 378);

        g.setColor(Color.decode("#feebf9"));
        plot(g, 330, 270);

        // ear
        g.setColor(Color.decode("#937c8e"));
        g.fillRect(204, 258, 36, 18);
        g.fillRect(366, 276, 12, 12);
        g.fillRect(378, 282, 18, 24);

        g.setColor(Color.decode("#536198"));
        g.fillRect(210, 276, 18, 18);
        g.fillRect(204, 270, 12, 12);
        g.fillRect(198, 258, 6, 12);
        g.fillRect(204, 252, 36, 6);
        g.fillRect(240, 258, 30, 6);
        plot(g, 240, 262);
        plot(g, 234, 270);

        g.fillRect(354, 270, 12, 12);
        g.fillRect(366, 270, 12, 6);
        g.fillRect(378, 276, 18, 6);
        g.fillRect(396, 282, 6, 18);
        g.fillRect(372, 288, 6, 12);
        g.fillRect(378, 300, 6, 12);
        g.fillRect(384, 306, 6, 12);
        plot(g, 390, 300);
        plot(g, 366, 282);

        // line cute head
        g.setColor(Color.decode("#536198"));
        plot(g, 228, 282);
        plot(g, 222, 306);
        plot(g, 342, 252);
        plot(g, 354, 282);
        plot(g, 342, 300);
        plot(g, 312, 300);

        g.fillRect(216, 288, 24, 18);
        g.fillRect(228, 300, 18, 18);
        g.fillRect(222, 300, 24, 12);
        g.fillRect(228, 312, 12, 6);

        g.fillRect(270, 252, 18, 6);
        g.fillRect(288, 246, 12, 6);
        g.fillRect(300, 240, 30, 6);
        g.fillRect(330, 246, 12, 6);
        g.fillRect(348, 258, 6, 12);

        g.fillRect(354, 264, 6, 24);

        g.fillRect(312, 276, 12, 6);
        g.fillRect(306, 282, 6, 18);
        g.fillRect(318, 306, 24, 6);
        g.fillRect(348, 288, 6, 12);

        // cut body sort by left to right
        g.fillRect(216, 318, 18, 6);
        g.fillRect(198, 312, 18, 6);
        g.fillRect(192, 318, 6, 12);
        g.fillRect(204, 336, 6, 12);
        g.fillRect(198, 348, 6, 18);
        g.fillRect(222, 330, 6, 18);
        g.fillRect(216, 348, 6, 30);
        g.fillRect(192, 366, 6, 12);
        g.fillRect(186, 378, 6, 30);
        g.fillRect(210, 390, 6, 12);
        g.fillRect(192, 408, 6, 12);
        g.fillRect(210, 432, 12, 6);
        g.fillRect(222, 438, 12, 6);
        g.fillRect(222, 402, 6, 24);
        g.fillRect(228, 420, 6, 12);
        g.fillRect(282, 432, 18, 6);
        g.fillRect(306, 450, 24, 6);
        g.fillRect(348, 420, 6, 12);
        g.fillRect(354, 408, 6, 12);
        g.fillRect(360, 396, 6, 12);
        g.fillRect(366, 384, 6, 12);
        g.fillRect(378, 366, 6, 12);

        plot(g, 228, 324);
        plot(g, 198, 330);
        plot(g, 204, 360);
        plot(g, 210, 366);
        plot(g, 198, 420);
        plot(g, 204, 426);
        plot(g, 216, 402);
        plot(g, 234, 432);
        plot(g, 294, 438);
        plot(g, 300, 444);
        plot(g, 330, 444);
        plot(g, 336, 438);
        plot(g, 342, 432);
        plot(g, 372, 378);

        // Mouth
        g.fillRect(306, 342, 24, 6);
        plot(g, 306, 348);
        plot(g, 318, 348);
        plot(g, 312, 354);

        // animation
        animation(g);

    }

    public void animation(Graphics g) {
        int faceAction = cntFrame % 2 * 6;
        int footAction = (cntFrame % 3 == 0) ? 0 : 6;
        ;

        // eye
        g.setColor(Color.decode("#536198"));
        g.fillRect(306 - faceAction, 312 + faceAction, 6 + faceAction, 12 - faceAction);
        g.fillRect(330 + faceAction, 318, 6, 12 - faceAction);
        plot(g, 306 + faceAction, 324);
        plot(g, 330, 330 - faceAction);

        // hand
        g.setColor(Color.decode("#feebf9"));
        if (faceAction != 0) {
            plot(g, 258, 324);
            plot(g, 384, 348);
            g.fillRect(378, 330, 24, 18);
        }

        g.setColor(Color.decode("#fec2ee"));

        if (faceAction == 0) {
            plot(g, 258, 324);
            g.fillRect(360, 336, 6, 18);
        } else {
            plot(g, 372, 336);
            plot(g, 384, 336);
            plot(g, 396, 336);
            plot(g, 390, 342);
            plot(g, 378, 360);
            plot(g, 366, 378);
            g.fillRect(372, 366, 6, 12);

        }
        g.fillRect(246 + faceAction, 330, 18, 6);
        g.fillRect(252 + faceAction, 336, 6, 12);

        g.setColor(Color.decode("#fefefe"));

        plot(g, 252, 318);
        plot(g, 270 + faceAction, 330);
        plot(g, 246, 324);
        if (faceAction == 0) {
            plot(g, 348, 342);
            plot(g, 360, 330);
        } else {
            plot(g, 258, 324);
            plot(g, 384, 324);
            plot(g, 396, 324);
        }

        g.setColor(Color.decode("#536198"));
        g.translate(faceAction * 5, 0);
        plot(g, 354, 330 - faceAction * 2);
        plot(g, 360, 324);
        plot(g, 366, 330 - faceAction * 2);
        g.translate(-faceAction * 5, 0);

        g.fillRect(342, 342, 6 - faceAction, 6);
        g.fillRect(378, 318, 6, 12);
        g.fillRect(372, 324, 6, 12);
        g.fillRect(348 + faceAction * 2, 336, 12, 6);
        g.fillRect(348 + faceAction * 7, 348, 6, 12);
        g.fillRect(378, 336, 6 - faceAction, 12);
        g.fillRect(384, 348 + faceAction, 6, 18 - faceAction);
        g.fillRect(402, 324, faceAction, 18);
        g.fillRect(396, 342, faceAction, 12);

        g.setColor(Color.decode("#536198"));

        plot(g, 240 + faceAction * 2, 330 - faceAction);
        plot(g, 252 + faceAction, 312 + faceAction);
        plot(g, 258 + faceAction, 318 + faceAction);
        plot(g, 276 - faceAction, 330);
        g.fillRect(240 - faceAction, 366 - faceAction * 2, 6, 12);
        g.fillRect(234 + faceAction, 336, 6, 30 - faceAction * 2);
        g.fillRect(246, 318, 6, 12 - faceAction * 2);
        g.fillRect(264, 324, 12, 6 - faceAction);
        g.fillRect(270 + faceAction, 336, 6, 12);
        g.fillRect(276, 348, 6, 12 - faceAction * 2);
        g.fillRect(234, 318, faceAction, 18);
        g.fillRect(240, 318, 12, faceAction);

        // foot
        g.setColor(Color.decode("#fec2ee"));
        plot(g, 270, 408);
        g.fillRect(258, 390, 6, 24);
        g.fillRect(264, 402, 6, 12);

        g.setColor(Color.decode("#fea3e6"));
        plot(g, 258, 444);
        g.fillRect(222, 384, 6 - footAction, 18);
        g.fillRect(228 + footAction, 396 + footAction, 6 + footAction * 2, 24 - footAction * 3);
        g.fillRect(234 + footAction, 414, 6, 18 - footAction);
        g.fillRect(240 + footAction, 432 - footAction * 3, 12, 12 + footAction);
        g.fillRect(264, 438, 12, 6);

        g.setColor(Color.decode("#536198"));
        if (footAction == 0) {
            g.fillRect(216, 378, 6, 24);
            g.fillRect(252, 450, 24, 6);
        } else {
            plot(g, 270, 420);
            plot(g, 258, 396);
            plot(g, 252, 390);
            plot(g, 228, 396);

            g.fillRect(264, 402, 6, 12);
            g.fillRect(258, 432, 12, 6);
            g.fillRect(270, 426, 24, 6);
            g.fillRect(240, 384, 12, 6);
            g.fillRect(228, 390, 12, 6);
            g.fillRect(222, 378, 6, 12);
        }

        plot(g, 276, 444 - footAction);
        plot(g, 282 - footAction * 2, 438);
        plot(g, 234, 432);
        g.fillRect(240, 438, 6 + footAction * 2, 6);
        g.fillRect(234, 444, 24 + footAction * 2, 6);

        g.setColor(Color.decode("#fefefe"));
        g.fillRect(240, 390, 12, footAction);

    }

    public void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int lenght = Math.abs(x2 - x1);
        for (int i = 0; i <= lenght; i += size) {
            double t = i / (lenght * 1.0);

            int x = (int) (Math.pow((1 - t), 3) * x1
                    + 3 * t * Math.pow((1 - t), 2) * x2
                    + 3 * Math.pow(t, 2) * (1 - t) * x3
                    + Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1
                    + 3 * t * Math.pow((1 - t), 2) * y2
                    + 3 * Math.pow(t, 2) * (1 - t) * y3
                    + Math.pow(t, 3) * y4);

            plot(g, x, y);
        }
    }

    public void bresenhamsLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? size : -size;
        int sy = (y1 < y2) ? size : -size;
        boolean isSwap = false;

        if (dy > dx) {
            int tmp;
            tmp = dx;
            dx = dy;
            dy = tmp;
            isSwap = true;
        }

        int D = 2 * dy - dx;

        int x = x1;
        int y = y1;

        for (int i = 1; i <= dx; i += size) {
            plot(g, x, y);
            if (D >= 0) {
                if (isSwap) {
                    x += sx;
                } else {
                    y += sy;
                }

                D -= 2 * dx;
            }
            if (isSwap) {
                y += sy;
            } else {
                x += sx;
            }
            D += 2 * dy;
        }

    }

    private void midpointEllipse(Graphics g, int xc, int yc, int a, int b) {
        // R1
        int x = 0;
        int y = b;

        int d = Math.round(b * b - a * a * b + a * a / 4);
        while (b * b * x <= a * a * y) {
            plot(g, x + xc, y + yc);
            plot(g, -x + xc, y + yc);
            plot(g, x + xc, -y + yc);
            plot(g, -x + xc, -y + yc);

            x++;

            d = d + 2 * b * b * x + b * b;

            if (d >= 0) {
                y--;
                d = d - 2 * a * a * y;

            }
        }
        // R2
        x = a;
        y = 0;

        d = Math.round(a * a - b * b * a + b * b / 4);
        while (b * b * x >= a * a * y) {
            plot(g, x + xc, y + yc);
            plot(g, -x + xc, y + yc);
            plot(g, x + xc, -y + yc);
            plot(g, -x + xc, -y + yc);

            y++;

            d = d + 2 * a * a * y + a * a;

            if (d >= 0) {
                x--;
                d = d - 2 * b * b * x;

            }
        }
    }

    private int random(int m, int n) {
        int random = (int) (Math.random() * n + 1 + m);
        return random;
    }

    void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, size, size);
    }

}
