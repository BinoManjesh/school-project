package com.bino.graphics3d.utils;

import com.bino.graphics3d.math.Vector3;
import java.util.ArrayList;

public class MeshLoader {

	public static void load(String path, ArrayList<Vector3> vertices, ArrayList<Vector3> indices) {
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
                        vertices.add(new Vector3(lineSc.nextFloat(), lineSc.nextFloat(), -lineSc.nextFloat()));
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