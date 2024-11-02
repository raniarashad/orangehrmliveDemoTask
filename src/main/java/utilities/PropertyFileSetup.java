package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileSetup
{
    public static Properties props;
    static {
        propInitiate();
    }
    public static void propInitiate() {
        props = new Properties();
        try {
            props.load(new FileInputStream(new File("resources/inputs/Data.properties")));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
