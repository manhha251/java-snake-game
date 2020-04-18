package Config;

import java.io.*;
import java.util.Properties;

/*
 * Config class to store application properties like size, sounds,...
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class Config {

    public final static int BOARD_ROWS = 20;
    public final static int BOARD_COLUMNS = 20;
    public static int SCALE = 20;

    /*
     * Store necessary configuration in a txt file via Properties
     */
    public static void saveConfig() {

        try (OutputStream output = new FileOutputStream("./save/SnakeConfig.txt")) {

            Properties properties = new Properties();

            properties.setProperty("scale", Integer.toString(SCALE));

            properties.store(output, null);

            System.out.println(properties);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /*
     * Store necessary configuration from config txt file
     */
    public static void loadConfig() {

        try (InputStream input = new FileInputStream("./save/SnakeConfig.txt")) {

            Properties properties = new Properties();

            properties.load(input);

            SCALE = Integer.parseInt(properties.getProperty("scale"));


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
