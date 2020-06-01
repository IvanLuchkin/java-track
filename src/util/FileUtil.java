package util;

import model.Flight;

import java.io.*;

public class FileUtil {

    public static void writeTeachers(Flight[] flights, String filePath) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(flights);
    }

    public static Flight[] readTeachers(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        return (Flight[]) objectInputStream.readObject();
    }

}