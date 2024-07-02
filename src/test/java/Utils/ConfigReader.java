package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static  String readProperty(String key){

        //THIS IS FOR READING SENSITIVE DATA FROM FILE

        File file=new File("configuration.properties");
        Properties properties=new Properties();

        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
