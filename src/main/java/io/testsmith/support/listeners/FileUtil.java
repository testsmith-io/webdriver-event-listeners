package io.testsmith.support.listeners;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

    public static final int MAX_FILENAME = 50;

    protected static void saveFile(String folder, String filename, byte[] data) {
        try {
            File file = new File(folder, filename);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream os = new FileOutputStream(file);
            os.write(data);
            os.close();
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save file", e);
        }
    }

    protected static String generateRandomFilename(String filename) {
        if (filename.length() >= MAX_FILENAME) {
            filename = filename.substring(0, MAX_FILENAME);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSS");
        filename = filename.replaceAll("\\s", "_").replaceAll(":", "");
        return dateFormat.format(new Date()) +
                "-" + filename;
    }

}
