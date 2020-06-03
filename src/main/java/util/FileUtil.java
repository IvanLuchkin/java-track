package util;

import model.Flight;

import java.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtil {

    private static final Logger log = LogManager.getLogger(FileUtil.class);

    public static void writeFlights(Flight[] flights, String filePath) throws IOException {
        log.info("trying to write to - {}", filePath);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(flights);
    }

    public static Flight[] readFlights(String filePath) throws IOException, ClassNotFoundException {
        log.info("trying to read from - {}", filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        return (Flight[]) objectInputStream.readObject();
    }

}