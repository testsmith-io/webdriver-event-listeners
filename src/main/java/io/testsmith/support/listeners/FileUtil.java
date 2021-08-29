package io.testsmith.support.listeners;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

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
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSS");
        int i = filename.indexOf('\n');
        filename = filename.substring(0, i).replaceAll("\\s", "_").replaceAll(":", "");
        return filename = dateFormat.format(date) +
                "-" + filename;
    }

}
