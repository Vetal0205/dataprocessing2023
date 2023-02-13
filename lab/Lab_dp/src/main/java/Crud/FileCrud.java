package Crud;

import Entities.Manpads;
import FileIO.FileIO;
import FileIO.FileIOInterface;

import java.util.List;


public class FileCrud implements Lab2CrudInterface{
    FileIOInterface fio;
    public FileCrud(){
        this.fio = new FileIO();
    }
    @Override
    public List<Manpads> readData() {
        return fio.readFromFile();
    }

    @Override
    public void addData(List<Manpads> data) {
        fio.loadToFile(data);
    }
}
