package Servlets;

import Crud.JDBCCrud;
import Crud.JPACrud;
import Crud.LabCRUDInterface;

import Entities.Manpads;

import Hibernate.JPAConnect;
import JDBC.JDBCConnect;

import org.hibernate.SessionFactory;
import java.sql.Connection;

public class ManpadsServletConfig implements ManpadsServletConfigInterface {
    LabCRUDInterface<Manpads> jdbcCRUD;
    LabCRUDInterface<Manpads> jpaCRUD;
    JPAConnect jpaConnect;
    JDBCConnect jdbcConnect;

    public ManpadsServletConfig() {
        this.jdbcConnect = new JDBCConnect();
        this.jdbcCRUD= new JDBCCrud(this.jdbcConnect.getCon());

        this.jpaConnect = new JPAConnect();
        this.jpaCRUD = new JPACrud(this.jpaConnect.getSessionFactory().openSession());
    }
    @Override
    public LabCRUDInterface<Manpads> getJdbcCrud() {
        return this.jdbcCRUD;
    }

    @Override
    public LabCRUDInterface<Manpads> getJpaCrud() {
        return this.jpaCRUD;
    }

    @Override
    public void CloseJdbcConnection() {
        this.jpaConnect.closeSession();
    }

    @Override
    public void CloseJpaConnection() {
        this.jdbcConnect.closeConnect();
    }
}
