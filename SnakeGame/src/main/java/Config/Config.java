package main.java.Config;

import java.awt.*;
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
    public static int SOUND = 100;

    public static Font DEFAULT_FONT = new Font("Monospaced", Font.PLAIN, Config.SCALE);

    /*
     * Store necessary configuration in a txt file via Properties
     */
    public static void saveConfig() {

        System.out.println(SCALE);
        System.out.println(SOUND);

        try (OutputStream output = new FileOutputStream("./SnakeConfig.txt")) {

            Properties properties = new Properties();

            properties.setProperty("scale", Integer.toString(SCALE));
            properties.setProperty("sound", Integer.toString(SOUND));

            properties.store(output, "Application configuration");

            System.out.println(properties);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Store necessary configuration from config txt file
     */

    public static void setSize(String size)
    {
        switch (size) {
            case "Small":
                SCALE = 20;
                break;
            case "Normal":
                SCALE = 25;
                break;
            case "Large":
                SCALE = 30;
                break;
        }
    }

    public static String getSize() {
        switch (SCALE) {
            case 20:
                return "Small";
            case 25:
                return "Normal";
            case 30:
                return "Large";
        }
        return "";
    }

    public static void setSound(int volume)
    {
        SOUND = volume;
    }
    public static void loadConfig() {

        try (InputStream input = new FileInputStream("./SnakeConfig.txt")) {

            Properties properties = new Properties();

            properties.load(input);

            SCALE = Integer.parseInt(properties.getProperty("scale"));
            SOUND = Integer.parseInt(properties.getProperty("sound"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
