package Servlets;

import Crud.LabCRUDInterface;
import Entities.Manpads;

public interface ManpadsServletConfigInterface {
    public LabCRUDInterface<Manpads> getJdbcCrud();
    public LabCRUDInterface<Manpads> getJpaCrud();
    public void CloseJdbcConnection();
    public void CloseJpaConnection();

}
