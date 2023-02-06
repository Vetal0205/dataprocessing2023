package Crud;

import Entities.Manpads;
import FileIO.FileIO;
import FileIO.FileIOInterface;


public class FileCrud implements Lab2CrudInterface{
    FileIOInterface fio;
    public FileCrud(){
        this.fio = new FileIO();
    }
    @Override
    public Manpads readData() {
        return (Manpads) fio.readFromFile();
    }

    @Override
    public void addData(Manpads data) {
        fio.loadToFile(data);
    }
}
