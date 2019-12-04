package com.company;

import java.io.*;

public class Serializer {
    public static void explicitSerialize(Object obj, String PATH_TO_FILE) throws IOException {
    FileOutputStream fos = new FileOutputStream(PATH_TO_FILE);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
  oos.writeObject(obj);
  oos.flush();
  oos.close();
  System.out.print("Done..\n");
}
    public static void decodeSerialized(String PATH_TO_FILE, Object obj) throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream(PATH_TO_FILE);
    ObjectInputStream oin = new ObjectInputStream(fis);
    obj = (Object) oin.readObject();
}
}

