import java.util.Properties;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Config {
	
	private static String src_path = "";
	private static String bin_path = "";

	public static void setDefaultProperties() {
		setSrcPath("");
		setBinPath("");
	}

	// Getters and setters for paths
	
	public static String getSrcPath() {
		return src_path;
	}

	public static void setSrcPath(String new_src_path) {
		src_path = new_src_path;
	}

	public static String getBinPath() {
		return bin_path;
	}

	public static void setBinPath(String new_bin_path) {
		bin_path = new_bin_path;
	}

	// File handling

	public static void readConfig(String file_name) {
		File configFile = new File(file_name);
		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);

			setSrcPath(props.getProperty("src_path"));
			setBinPath(props.getProperty("bin_path"));

			reader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found.");
		} catch (IOException ex) {
			System.out.println("IOException.");
		}
	}

	public static void writeConfig(String file_name) {
		File configFile = new File(file_name);
		try {
			Properties props = new Properties();
			props.setProperty("src_path", getSrcPath());
			props.setProperty("bin_path", getBinPath());
			FileWriter writer = new FileWriter(configFile);
			props.store(writer, "jvi configuration");
			writer.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found.");
		} catch (IOException ex) {
			System.out.println("IOException.");
		}
	}

	//
	

	public static void main(String[] args) {
		if(args[0].equals("read")) {
			readConfig(args[1]);
			System.out.println(src_path);
			System.out.println(bin_path);
		} else if (args[0].equals("write")) {
			// file src bin
			setSrcPath(args[2]);
			setBinPath(args[3]);
			writeConfig(args[1]);
		} else System.out.println("That functionality is not supported.");
	}

}
