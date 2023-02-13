package Crud;

import Entities.Manpads;

import java.util.List;

public interface Lab2CrudInterface {
    public List<Manpads> readData();
    public void addData(List<Manpads> data);
}
