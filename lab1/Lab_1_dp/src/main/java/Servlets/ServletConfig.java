package Servlets;

import Crud.FileCrud;
import Crud.Lab2CrudInterface;

public class ServletConfig implements  ServletConfigInterface{
    public ServletConfig() {
        this.l2ci = new FileCrud();
    }

    Lab2CrudInterface  l2ci;
    public Lab2CrudInterface getL2ci() {
        return l2ci;
    }

    public void setL2ci(Lab2CrudInterface l2ci) {
        this.l2ci = l2ci;
    }

    @Override
    public Lab2CrudInterface getCrud() {
        return l2ci;
    }
}
