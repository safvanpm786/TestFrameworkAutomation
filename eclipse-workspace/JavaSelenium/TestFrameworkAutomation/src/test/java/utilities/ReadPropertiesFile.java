package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("C:\\Users\\safva\\eclipse-workspace\\JavaSelenium\\TestFrameworkAutomation\\src\\test\\resources\\configfiles\\config.properties");
		Properties p = new Properties();
		
		p.load(fr);
		// TODO Auto-generated method stub

	}

}
