package Crud;

import Entities.Manpads;

import java.util.List;

public interface LabCRUDInterface<T> {
    public List<T> read();
    public void create(T t);
    public void delete(int id);
    public void update(int id, T t);
}
