package com.bino.graphics3d.util;

import com.bino.graphics3d.math.Vector;

import java.util.Arrays;

public class Renderer {

    private static float x32;
    private static float x21;
    private static float y32;
    private static float y21;
    private static float z32;
    private static float z21;
    private static float a;
    private static float b;
    private static float c;
    private static float z1;
    private static float z2;

    public static void fillTriangle(Screen screen, Vector... p) {
        Arrays.sort(p, (a, b) -> Float.compare(a.y, b.y));
        Vector p3 = new Vector();
        p3.y = p[1].y;
        p3.x = p[0].x + (p[1].y - p[0].y) * (p[0].x - p[2].x) / (p[0].y - p[2].y);
        p3.z = (p[2].z - p[0].z) / (p[2].y - p[0].y) * (p3.y - p[0].y);

        if (p[0].x < p[1].x)
            fillUpTriangle(screen, p[0], p[1], p3);
        else
            fillUpTriangle(screen, p[1], p[0], p3);

        if (p[1].x < p[2].x)
            fillDownTriangle(screen, p3, p[1], p[2]);
        else
            fillDownTriangle(screen, p3, p[2], p[1]);
    }

    private static void fillUpTriangle(Screen screen, Vector... p) {
        int y;
        if (p[0].y <= (int) p[0].y + 0.5f)
            y = (int) p[0].y;
        else
            y = (int) p[0].y + 1;
        if (y < 0)
            y = 0;
        while (y + 0.5f < p[1].y) {
            float fX1 = p[0].x + (y + 0.5f - p[0].y) * (p[0].x - p[2].x) / (p[0].y - p[2].y);
            float fX2 = p[0].x + (y + 0.5f - p[0].y) * (p[0].x - p[2].x) / (p[0].y - p[2].y);
            int x1, x2;
            if (fX1 <= (int) fX1 + 0.5f)
                x1 = (int) fX1;
            else
                x1 = (int) fX1 + 1;
            if (fX2 <= (int) fX2 + 0.5f)
                x2 = (int) fX2;
            else
                x2 = (int) fX2 + 1;
            if (x1 >= x2) {
                continue;
            }
            x32 = p[2].x - p[1].x;
            x21 = p[1].x - p[0].x;
            y32 = p[2].y - p[1].y;
            y21 = p[1].y - p[0].y;
            z32 = p[2].z - p[1].z;
            z21 = p[1].z - p[0].z;
            a = (x21 * z32 - x32 * z21) / (x21 * y32 - x32 * y21);
            b = (y32 * z21 - y21 * z32) / (x21 * y32 - x32 * y21);
            c = p[0].z - a * p[0].x - b * p[0].y;
            z1 = a * (x1 + 0.5f) + b * (y + 0.5f) + c;
            z2 = a * (x2 + 0.5f) + b * (y + 0.5f) + c;
            screen.drawLine(x1, x2, y, z1, z2);
        }
    }

    private static void fillDownTriangle(Screen screen, Vector... p) {
        int y;
    }

    //	public static void fillTriangle(Graphics g, Vector2[] p) {
    //        Arrays.sort(p, (a, b) -> (int) (a.y - b.y));
    //        if (p[0].y == p[1].y) {
    //            fillDownTriangle(g, p);
    //        } else if (p[1].y == p[2].y) {
    //            fillUpTriangle(g, p);
    //        } else {
    //            Vector2 p3 = new Vector2();
    //            p3.y = p[1].y;
    //            p3.x = p[0].x + (p3.y - p[0].y) * (p[0].x - p[2].x) / (p[0].y - p[2].y);
    //            fillUpTriangle(g, p[0], p[1], p3);
    //            fillDownTriangle(g, p3, p[1], p[2]);
    //        }
    //    }
    //
    //    private static void fillUpTriangle(Graphics g, Vector2... p) {
    //        int y = (int) Math.round(p[0].y);
    //        float x1 = p[0].x, x2 = p[0].x;
    //        float dx1 = (p[1].x - p[0].x) / (p[1].y - p[0].y);
    //        float dx2 = (p[2].x - p[0].x) / (p[2].y - p[0].y);
    //        while (y + 0.5 <= p[2].y) {
    //            g.drawLine((int) Math.round(x1), y, (int) Math.round(x2), y);
    //            x1 += dx1;
    //            x2 += dx2;
    //            y++;
    //        }
    //    }
    //
    //    private static void fillDownTriangle(Graphics g, Vector2... p) {
    //        int y = (int) Math.round(p[0].y);
    //        float x0 = p[0].x, x1 = p[1].x;
    //        float dx0 = (p[2].x - p[0].x) / (p[2].y - p[0].y);
    //        float dx1 = (p[2].x - p[1].x) / (p[2].y - p[1].y);
    //        while (y + 0.5 <= p[2].y) {
    //            g.drawLine((int) Math.round(x0), y, (int) Math.round(x1), y);
    //            x0 += dx0;
    //            x1 += dx1;
    //            y++;
    //        }
    //    }
    //
    //    public static void drawTriangle(Graphics g, Vector2[] p) {
    //        for (int i = 0; i < 3; ++i) {
    //            int j = (i + 1) % 3;
    //            g.drawLine((int) p[i].x, (int) p[i].y, (int) p[j].x, (int) p[j].y);
    //        }
    //    }
}