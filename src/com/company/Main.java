package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Main extends JFrame {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private final int CENTER_X = WIDTH / 2;
    private final int CENTER_Y = HEIGHT / 2;

    public Main() {
        setTitle("Draw");
        setSize(WIDTH, HEIGHT);
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        graphics.drawLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2);
        paintVectors(graphics);
    }

    private void paintVectors(Graphics graphics) {
        graphics.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D) graphics;
        Line2D line1 = new Line2D.Double();
        Line2D line2 = new Line2D.Double();
        line1.setLine(CENTER_X, CENTER_Y, 400, 173);
        line2.setLine(CENTER_X, CENTER_Y, 400, 70);
        g2.draw(line1);
        g2.draw(line2);
        drawVertical(graphics, line1, line2);
    }

    private void drawVertical(Graphics graphics, Line2D firstLine, Line2D secondLine) {
        Graphics2D g2 = (Graphics2D) graphics;
        graphics.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2.0f));
        Line2D line1 = new Line2D.Double();
        Line2D line2 = new Line2D.Double();
        line1.setLine(CENTER_X, CENTER_Y, firstLine.getY2(), Math.abs(firstLine.getX1() - firstLine.getX2() + firstLine.getY1()));
        line2.setLine(CENTER_X, CENTER_Y, secondLine.getX1() - secondLine.getY2() + secondLine.getX1(), secondLine.getX2()); // 2 line
        g2.draw(line1);
        g2.draw(line2);
    }

    public static double angleBetween2Lines(Line2D line1, Line2D line2) {
        double angle1 = Math.atan2(line1.getY1() - line1.getY2(),
                line1.getX1() - line1.getX2());
        double angle2 = Math.atan2(line2.getY1() - line2.getY2(),
                line2.getX1() - line2.getX2());
        return angle1 - angle2;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
