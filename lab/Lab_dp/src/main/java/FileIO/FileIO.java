package FileIO;

import Entities.Manpads;

import java.io.*;
import java.util.List;

public class FileIO implements FileIOInterface{
    private String fileName = "db.txt";
    public String getFileName() {
        return fileName;
    }

    File yourFile = new File(fileName);
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void loadToFile(List<Manpads> objects) {
        try {
            this.yourFile.createNewFile(); // if file already exists will do nothing
            FileOutputStream fos = new FileOutputStream(yourFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objects);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Manpads> readFromFile() {
        List<Manpads> data = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (List<Manpads>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
