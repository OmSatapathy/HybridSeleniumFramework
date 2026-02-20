package utilites;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperityfile {

	public String readProperies() {

		String filepath = "..\\framworkE2E\\cofig.properties";

		Properties prop = new Properties();
		try {
			FileInputStream input = new FileInputStream(filepath);
			prop.load(input);
			String dbUser = prop.getProperty("baseurl");
			System.out.println(dbUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filepath;

	}

}
