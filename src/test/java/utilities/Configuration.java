package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    public static String getProperties(String key)throws IOException {
        Properties properties=new Properties();
        properties.load(new FileReader(new File("src/test/resorces/conf/Configuration.properties")));
        String value= properties.getProperty(key);
        return value;
    }

}
