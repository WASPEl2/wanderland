//64050285 Aekapab  Sukkasem
//64050543 Pariyakorn  Pramoonsin 
package wanderland;

import java.awt.*;
import javax.swing.*;

public class Assignment2_64050285_64050543 extends JPanel implements Runnable {
    public int size;
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

            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.decode("#80ddea"));
        g.fillRect(0, 0, 600, 600);

        // Sky
        size = 1;
        g.setColor(Color.decode("#bd75ff"));
        g.fillRect(0, 0, 600, 36);

        skydetail(g,0,Color.decode("#ff7bff"),18);
        skydetail(g,6,Color.decode("#ff7bff"),30);
        g.setColor(Color.decode("#ff7bff"));
        g.fillRect(0, 36, 600, 45);
        skydetail(g,0,Color.decode("#bd75ff"),42);

        skydetail(g,0,Color.decode("#ffbcda"),72);
        g.setColor(Color.decode("#ffbcda"));
        g.fillRect(0, 78, 600, 30);
        skydetail(g,6,Color.decode("#ff7bff"),84);

        skydetail(g,6,Color.decode("#ffcace"),102);
        g.setColor(Color.decode("#ffcace"));
        g.fillRect(0, 108, 600, 37);
        skydetail(g,0,Color.decode("#ffbcda"),115);

        skydetail(g,6,Color.decode("#fff2aa"),138);
        g.setColor(Color.decode("#fff2aa"));
        g.fillRect(0, 144, 600, 36);
        skydetail(g,0,Color.decode("#ffcace"),150);

        skydetail(g,6,Color.decode("#fdfec6"),174);
        g.setColor(Color.decode("#fdfec6"));
        g.fillRect(0, 180, 600, 36);
        skydetail(g,0,Color.decode("#fff2aa"),186);

        // water
        size = 6;
        g.setColor(Color.decode("#5494d8"));
        bresenhamsLine(g, 0, 216, 118, 216);
        bresenhamsLine(g, 0, 222, 71, 222);
        bresenhamsLine(g, 0, 228, 40, 228);
        bresenhamsLine(g, 534, 216, 600, 216);
        bresenhamsLine(g, 552, 222, 600, 222);
        bresenhamsLine(g, 575, 228, 600, 228);
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


    }

    public void skydetail(Graphics g, int start, Color color, int y) {
        for (int i = start; i <= 600; i+=12) {
            g.setColor(color);
            size = 6;
            plot(g, i, y);
        }
    }

    public void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;

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

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
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

        for (int i = 1; i <= dx; i++) {
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

    void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, size, size);
    }

}
