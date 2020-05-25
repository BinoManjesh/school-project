package com.bino.graphics3d;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Mesh {

    ArrayList<Triangle> triangles;

    Mesh() {
        triangles = new ArrayList<>();
    }

    Mesh(String path) {
        this();
        try {
            FileInputStream fin = new FileInputStream(path);
            Scanner sc = new Scanner(fin);
            ArrayList<Vector3> vertices = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Scanner lineSc = new Scanner(line);
                lineSc.useDelimiter("[ /]");
                if (lineSc.hasNext()) {
                    String tok = lineSc.next();
                    if (tok.equals("v")) {
                        vertices.add(new Vector3(lineSc.nextDouble(), lineSc.nextDouble(), lineSc.nextDouble()));
                    } else if (tok.equals("f")) {
                        int[] indices = new int[3];
                        for (int i = 0; i < 3; ++i) {
                            indices[i] = lineSc.nextInt();
                            lineSc.nextInt();
                            lineSc.nextInt();
                        }
                        triangles.add(new Triangle(vertices.get(indices[0] - 1).copy(),
                                vertices.get(indices[1] - 1).copy(), vertices.get(indices[2] - 1).copy()));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Mesh copy() {
        Mesh copy = new Mesh();
        for (Triangle triangle : triangles) {
            copy.triangles.add(triangle.copy());
        }
        return copy;
    }
}
