package wanderland;

//64050285 Aekapab  Sukkasem
//64050543 Pariyakorn  Pramoonsin 
import java.util.concurrent.TimeUnit;
import java.awt.*;
import javax.swing.*;

public class Assignment2_64050285_64050543 extends JPanel implements Runnable {
    long fps = 1000 / 10;
    int size = 6;
    int cloudPosition = 0;
    int cloudSpeed = 6;

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
            System.out.println(cloudPosition);
            cloudPosition += cloudSpeed;
            if (cloudPosition >= 30 || cloudPosition <= 0)
                cloudSpeed = -cloudSpeed;
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
        size = 1;
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

        size = 6;
        g.setColor(Color.decode("#5494d8"));
        bresenhamsLine(g, 0, 216, 118, 216);
        bresenhamsLine(g, 0, 222, 71, 222);
        bresenhamsLine(g, 0, 228, 40, 228);
        bresenhamsLine(g, 534, 216, 600, 216);
        bresenhamsLine(g, 552, 222, 600, 222);
        bresenhamsLine(g, 575, 228, 600, 228);
        bresenhamsLine(g, 582, 234, 600, 234);

        cloud(g);

    }

    public void cloud(Graphics g) {
        g.setColor(Color.decode("#fdfecc"));
        bresenhamsLine(g, 42 + cloudPosition, 84, 102 + cloudPosition, 84);
    }

    public void skydetail(Graphics g, int start, Color color, int y) {
        for (int i = start; i <= 600; i += 12) {
            g.setColor(color);
            size = 6;
            plot(g, i, y);
        }
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
