package Servlets;

import Crud.SQLCrud;
import Crud.LabCRUDInterface;
import Entities.Manpads;
import JDBC.Connect;

public class ManpadsServletConfig implements ManpadsServletConfigInterface {
    LabCRUDInterface<Manpads> sqlCRUD;
    Connect con;

    @Override
    public LabCRUDInterface<Manpads> getSqlCRUD() {
        return sqlCRUD;
    }
    @Override
    public void CloseConnection(){
        this.con.closeConnect();
    }
    public ManpadsServletConfig() {
        this.con = new Connect();
        this.sqlCRUD = new SQLCrud(this.con.getCon());
    }
    public void setSqlCRUD(LabCRUDInterface<Manpads> sqlCRUD) {
        this.sqlCRUD = sqlCRUD;
    }

}
