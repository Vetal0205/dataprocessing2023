package FileIO;

import Entities.Manpads;

import java.util.List;

public interface FileIOInterface {
    public void loadToFile(List<Manpads> objects);
    public List<Manpads> readFromFile();
}
