package com.bino.graphics3d.util;

import com.bino.graphics3d.math.Vector;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MeshLoader {

	public static void load(String path, ArrayList<Vector> vertices, ArrayList<Integer> indices) {
		try {
            FileInputStream fin = new FileInputStream(path);
            Scanner sc = new Scanner(fin);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Scanner lineSc = new Scanner(line);
                lineSc.useDelimiter("[ /]");
                if (lineSc.hasNext()) {
                    String tok = lineSc.next();
                    if (tok.equals("v")) {
                        vertices.add(new Vector(lineSc.nextFloat(), lineSc.nextFloat(), -lineSc.nextFloat()));
                    } else if (tok.equals("f")) {
                        for (int i = 0; i < 3; ++i) {
                            indices.add(lineSc.nextInt());
                            lineSc.next();
                            lineSc.next();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}