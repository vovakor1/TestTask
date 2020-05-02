package utils;

import aquality.selenium.core.logging.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileUtils {
    public static FileReader getFileFromResource(String fileName) {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(FileUtils.class.getResource(fileName).getFile());
        } catch (FileNotFoundException e) {
            Logger.getInstance().error(String.format("Can't load the file: %s", e));
        }
        return fileReader;
    }
}