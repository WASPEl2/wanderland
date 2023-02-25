package wanderland;

//64050285 Aekapab  Sukkasem
//64050543 Pariyakorn  Pramoonsin 
import java.util.concurrent.TimeUnit;
import java.awt.*;
import javax.swing.*;

public class Assignment2_64050285_64050543 extends JPanel implements Runnable {
    long fps = 1000 / 1;
    int size = 6;
    int cloudPosition = 0;
    int cloudSpeed = 6;
    int flowerSpeed = 6;

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
            if (cloudPosition >= 30 || cloudPosition <= 0)
                cloudSpeed = -cloudSpeed;
            flowerSpeed = (flowerSpeed + 6) % 12;
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

        skydetail(g, 0, Color.decode("#ff7bff"), 18);
        skydetail(g, 6, Color.decode("#ff7bff"), 30);
        g.setColor(Color.decode("#ff7bff"));
        g.fillRect(0, 36, 600, 45);
        skydetail(g, 0, Color.decode("#bd75ff"), 42);

        skydetail(g, 0, Color.decode("#ffbcda"), 72);
        g.setColor(Color.decode("#ffbcda"));
        g.fillRect(0, 78, 600, 30);
        skydetail(g, 6, Color.decode("#ff7bff"), 84);

        skydetail(g, 6, Color.decode("#ffcace"), 102);
        g.setColor(Color.decode("#ffcace"));
        g.fillRect(0, 108, 600, 37);
        skydetail(g, 0, Color.decode("#ffbcda"), 115);

        skydetail(g, 6, Color.decode("#fff2aa"), 138);
        g.setColor(Color.decode("#fff2aa"));
        g.fillRect(0, 144, 600, 36);
        skydetail(g, 0, Color.decode("#ffcace"), 150);

        skydetail(g, 6, Color.decode("#fdfec6"), 174);
        g.setColor(Color.decode("#fdfec6"));
        g.fillRect(0, 180, 600, 35);
        skydetail(g, 0, Color.decode("#fff2aa"), 186);

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

        // grass
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

        cloud(g);
        flower(g);
        mainOpject(g);

    }

    public void cloud(Graphics g) {
        // cloud 1
        g.setColor(Color.decode("#fdfecc"));
        bresenhamsLine(g, 90 + cloudPosition, 54, 113 + cloudPosition, 54);
        bresenhamsLine(g, 72 + cloudPosition, 60, 113 + cloudPosition, 60);
        bresenhamsLine(g, 60 + cloudPosition, 66, 125 + cloudPosition, 66);
        bresenhamsLine(g, 48 + cloudPosition, 72, 131 + cloudPosition, 72);
        bresenhamsLine(g, 48 + cloudPosition, 78, 137 + cloudPosition, 78);
        bresenhamsLine(g, 42 + cloudPosition, 84, 137 + cloudPosition, 84);
        g.setColor(Color.decode("#ccd9fe"));
        bresenhamsLine(g, 66 + cloudPosition, 72, 89 + cloudPosition, 72);
        bresenhamsLine(g, 54 + cloudPosition, 78, 101 + cloudPosition, 78);
        bresenhamsLine(g, 54 + cloudPosition, 84, 119 + cloudPosition, 84);
        bresenhamsLine(g, 42 + cloudPosition, 90, 125 + cloudPosition, 90);
        g.setColor(Color.decode("#cbf6fe"));
        plot(g, 78 + cloudPosition, 78);
        bresenhamsLine(g, 78 + cloudPosition, 66, 107 + cloudPosition, 66);
        bresenhamsLine(g, 90 + cloudPosition, 72, 113 + cloudPosition, 72);
        bresenhamsLine(g, 102 + cloudPosition, 78, 125 + cloudPosition, 78);
        bresenhamsLine(g, 66 + cloudPosition, 84, 77 + cloudPosition, 84);
        bresenhamsLine(g, 120 + cloudPosition, 84, 131 + cloudPosition, 84);
        bresenhamsLine(g, 72 + cloudPosition, 90, 101 + cloudPosition, 90);
        bresenhamsLine(g, 126 + cloudPosition, 90, 137 + cloudPosition, 90);

        // cloud 2
        g.setColor(Color.decode("#fdfecc"));
        plot(g, 204 + cloudPosition, 114);
        plot(g, 210 + cloudPosition, 120);
        plot(g, 222 + cloudPosition, 120);
        bresenhamsLine(g, 186 + cloudPosition, 108, 197 + cloudPosition, 108);
        g.setColor(Color.decode("#cbf6fe"));
        plot(g, 216 + cloudPosition, 120);
        bresenhamsLine(g, 174 + cloudPosition, 108, 185 + cloudPosition, 108);
        bresenhamsLine(g, 168 + cloudPosition, 114, 197 + cloudPosition, 114);
        bresenhamsLine(g, 156 + cloudPosition, 120, 209 + cloudPosition, 120);
        bresenhamsLine(g, 156 + cloudPosition, 126, 221 + cloudPosition, 126);
        g.setColor(Color.decode("#ccd9fe"));
        plot(g, 174 + cloudPosition, 114);
        plot(g, 198 + cloudPosition, 114);
        bresenhamsLine(g, 162 + cloudPosition, 120, 197 + cloudPosition, 120);
        bresenhamsLine(g, 156 + cloudPosition, 126, 173 + cloudPosition, 126);
        bresenhamsLine(g, 180 + cloudPosition, 126, 203 + cloudPosition, 126);
        plot(g, 222 + cloudPosition, 126);

        // cloud 3
        g.setColor(Color.decode("#fdfecc"));
        plot(g, 474 + cloudPosition, 90);
        g.fillRect(432 + cloudPosition, 96, 48, 12);
        bresenhamsLine(g, 426 + cloudPosition, 108, 437 + cloudPosition, 108);
        bresenhamsLine(g, 474 + cloudPosition, 114, 485 + cloudPosition, 114);

        g.setColor(Color.decode("#cbf6fe"));
        plot(g, 450 + cloudPosition, 96);
        plot(g, 426 + cloudPosition, 102);
        plot(g, 420 + cloudPosition, 108);
        bresenhamsLine(g, 468 + cloudPosition, 102, 485 + cloudPosition, 102);
        bresenhamsLine(g, 438 + cloudPosition, 108, 473 + cloudPosition, 108);
        bresenhamsLine(g, 414 + cloudPosition, 114, 473 + cloudPosition, 114);
        bresenhamsLine(g, 492 + cloudPosition, 114, 509 + cloudPosition, 114);
        bresenhamsLine(g, 408 + cloudPosition, 120, 419 + cloudPosition, 120);
        g.setColor(Color.decode("#ccd9fe"));
        plot(g, 468 + cloudPosition, 90);
        plot(g, 456 + cloudPosition, 96);
        plot(g, 432 + cloudPosition, 114);
        plot(g, 486 + cloudPosition, 114);
        bresenhamsLine(g, 480 + cloudPosition, 96, 497 + cloudPosition, 96);
        bresenhamsLine(g, 486 + cloudPosition, 102, 503 + cloudPosition, 102);
        bresenhamsLine(g, 474 + cloudPosition, 108, 533 + cloudPosition, 108);
        bresenhamsLine(g, 444 + cloudPosition, 114, 467 + cloudPosition, 114);
        bresenhamsLine(g, 510 + cloudPosition, 114, 539 + cloudPosition, 114);
        bresenhamsLine(g, 420 + cloudPosition, 120, 521 + cloudPosition, 120);

    }

    public void flower(Graphics g) {
        // flower petals
        g.setColor(Color.decode("#d6adfe"));
        plot(g, 18 + flowerSpeed, 396);
        plot(g, 42 + flowerSpeed, 396);
        plot(g, 30 + flowerSpeed, 408);
        g.fillRect(24 + flowerSpeed, 390, 18, 18);

        g.setColor(Color.decode("#fe8aec"));
        g.fillRect(66, 456 + flowerSpeed, 12, 6);
        g.fillRect(60 + flowerSpeed, 462, 24, 18);
        g.fillRect(54 + flowerSpeed, 468, 6, 12 - flowerSpeed);
        g.fillRect(60 + flowerSpeed * 5, 480 - flowerSpeed * 2, 18 - flowerSpeed * 2, 6);

        g.setColor(Color.decode("#d8a9ff"));
        plot(g, 102 + flowerSpeed, 558);
        plot(g, 126 + flowerSpeed, 558);
        g.fillRect(108 + flowerSpeed, 552, 18, 18);

        g.setColor(Color.decode("#d6adfe"));
        plot(g, 174 + flowerSpeed * 2, 540);
        plot(g, 198 + flowerSpeed * 2, 540);
        g.fillRect(180 + flowerSpeed * 2, 534, 18, 18);

        g.setColor(Color.decode("#fe89ed"));
        plot(g, 294 + flowerSpeed, 522);
        plot(g, 318 + flowerSpeed, 522);
        g.fillRect(300 + flowerSpeed, 516, 18, 18);

        g.setColor(Color.decode("#d8a8ff"));
        plot(g, 360 + flowerSpeed, 558);
        plot(g, 384 + flowerSpeed, 558);
        g.fillRect(366 + flowerSpeed, 552, 18, 18);

        g.setColor(Color.decode("#d6acfe"));
        plot(g, 492 + flowerSpeed, 546);
        plot(g, 522 + flowerSpeed, 546);
        g.fillRect(498 + flowerSpeed, 540, 24, 18);

        g.setColor(Color.decode("#fe8aec"));
        plot(g, 474 + flowerSpeed, 468);
        g.fillRect(486 + flowerSpeed, 456, 18, 6);
        g.fillRect(480 + flowerSpeed, 462, 30, 12);
        g.fillRect(480 + flowerSpeed, 474, 24, 6);

        // center of flower
        g.setColor(Color.decode("#fdffca"));
        plot(g, 30 + flowerSpeed, 396);
        plot(g, 114 + flowerSpeed, 558);
        plot(g, 186 + flowerSpeed * 2, 540);
        plot(g, 306 + flowerSpeed, 522);
        plot(g, 372 + flowerSpeed, 558);
        plot(g, 486 + flowerSpeed, 468);
        plot(g, 492 + flowerSpeed, 462);
        g.fillRect(66 + flowerSpeed, 468, 6 + flowerSpeed, 6);
        g.fillRect(504 + flowerSpeed, 546, 12, 6);

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

    public void skydetail(Graphics g, int start, Color color, int y) {
        for (int i = start; i < 600; i += 12) {
            g.setColor(color);
            size = 6;
            plot(g, i, y);
        }
    }

    public void mainOpject(Graphics g) {
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
        g.fillRect(384, 306, 6, 18);
        plot(g, 390, 300);
        plot(g, 366, 282);

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

    void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, size, size);
    }

}
