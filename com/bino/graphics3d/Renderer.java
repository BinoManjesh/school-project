package com.bino.graphics3d;

import java.awt.Graphics;
import java.util.Arrays;

public class Renderer {

	static void fillTriangle(Graphics g, Vector2[] p) {
        Arrays.sort(p, (a, b) -> (int) (a.y - b.y));
        if (p[0].y == p[1].y) {
            fillDownTriangle(g, p);
        } else if (p[1].y == p[2].y) {
            fillUpTriangle(g, p);
        } else {
            Vector2 p3 = new Vector2();
            p3.y = p[1].y;
            p3.x = p[0].x + (p3.y - p[0].y) * (p[0].x - p[2].x) / (p[0].y - p[2].y);
            fillUpTriangle(g, p[0], p[1], p3);
            fillDownTriangle(g, p3, p[1], p[2]);
        }
    }

    static void fillUpTriangle(Graphics g, Vector2... p) {
        int y = (int) Math.round(p[0].y);
        double x1 = p[0].x, x2 = p[0].x;
        double dx1 = (p[1].x - p[0].x) / (p[1].y - p[0].y);
        double dx2 = (p[2].x - p[0].x) / (p[2].y - p[0].y);
        while (y + 0.5 <= p[2].y) {
            g.drawLine((int) Math.round(x1), y, (int) Math.round(x2), y);
            x1 += dx1;
            x2 += dx2;
            y++;
        }
    }

    static void fillDownTriangle(Graphics g, Vector2... p) {
        int y = (int) Math.round(p[0].y);
        double x0 = p[0].x, x1 = p[1].x;
        double dx0 = (p[2].x - p[0].x) / (p[2].y - p[0].y);
        double dx1 = (p[2].x - p[1].x) / (p[2].y - p[1].y);
        while (y + 0.5 <= p[2].y) {
            g.drawLine((int) Math.round(x0), y, (int) Math.round(x1), y);
            x0 += dx0;
            x1 += dx1;
            y++;
        }
    }

    static void drawTriangle(Graphics g, Vector2[] p) {
        for (int i = 0; i < 3; ++i) {
            int j = (i + 1) % 3;
            g.drawLine((int) p[i].x, (int) p[i].y, (int) p[j].x, (int) p[j].y);
        }
    }
}