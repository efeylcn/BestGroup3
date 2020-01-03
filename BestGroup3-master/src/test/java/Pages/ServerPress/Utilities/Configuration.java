package Pages.ServerPress.Utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {
    public static String getProperties(String key) throws IOException {

        //specify the needed file
        File credsFile= new File("src/test/resources/Configuration/configuration.properties");

        //read from a file
        FileReader fileReader=new FileReader(credsFile);

        java.util.Properties properties = new java.util.Properties();


        properties.load(fileReader);
        String value = properties.getProperty(key);
        return value;


    }
}
