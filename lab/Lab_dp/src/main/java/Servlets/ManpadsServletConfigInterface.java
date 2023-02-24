package Servlets;

import Crud.LabCRUDInterface;
import Entities.Manpads;

public interface ManpadsServletConfigInterface {
    public LabCRUDInterface<Manpads> getSqlCRUD();
    public void CloseConnection();
}
