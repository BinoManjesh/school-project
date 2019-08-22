import java.io.IOException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.FileWriter;

public class BatGenerator {
	
	private static final String INPUT =
		"C:\\Users\\Manjesh\\Desktop\\something\\school-project";
		
	private static final String[] PACKAGES = new String[] {"journal"};

	private static final String OUTPUT = 
		"C:\\Users\\Manjesh\\Desktop\\something\\school-project\\bats";

	public static void main(String[] args) throws IOException {
		int length = PACKAGES.length;
		FilenameFilter filter = new JavaSrcFilter();
		
		File directory = new File(INPUT);
		File[] srcFiles = directory.listFiles(filter);
			
		for (File srcFile : srcFiles) {
			String name = srcFile.getName();
			name = name.substring(0, name.length() - 5);
			File bat = new File(OUTPUT + "\\" + name + ".bat");
			bat.createNewFile();
				
			FileWriter writer = new FileWriter(bat);
			writer.write("java -cp \"" + INPUT + "\\classes\" " + name);
			writer.write("\npause"); 
			writer.close();
		}
			
		for (int i = 0; i < length; i ++) {
			directory = new File(INPUT + "\\" + PACKAGES[i]);
			srcFiles = directory.listFiles(filter);
			
			for (File srcFile : srcFiles) {
				String name = srcFile.getName();
				name = name.substring(0, name.length() - 5);
				File bat = new File(OUTPUT + "\\" + PACKAGES[i] + "\\" + name + ".bat");
				bat.createNewFile();
				
				FileWriter writer = new FileWriter(bat);
				writer.write("java -cp \"" + INPUT + "\\classes\" " + PACKAGES[i] + "\\" + name);
				writer.write("\npause"); 
				writer.close();
			}
		}
	}
	
	private static class JavaSrcFilter implements FilenameFilter {
		
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(".java");
		}
	}
	
}