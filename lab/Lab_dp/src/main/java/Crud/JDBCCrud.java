package Crud;

import Entities.Manpads;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCCrud implements LabCRUDInterface<Manpads> {
    Connection con;

    public JDBCCrud(Connection con){
        this.con = con;
    }
    @Override
    public List<Manpads> read() {
        List<Manpads> list = new ArrayList<Manpads>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM vitalii.manpads");
            while (rs.next()){
                list.add(new Manpads(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void create(Manpads manpad) {
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO vitalii.manpads (name, weight, photo) VALUES (?,?,?)");
            st.setString(1, manpad.getName());
            st.setDouble(2, manpad.getWeight());
            st.setString(3, manpad.getPhoto());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM vitalii.manpads WHERE id=?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Manpads manpad) {
        try {
            PreparedStatement st = con.prepareStatement("UPDATE vitalii.manpads SET \"name\"=?, \"weight\"=?, \"photo\"=? WHERE id=?");
            st.setString(1, manpad.getName());
            st.setDouble(2, manpad.getWeight());
            st.setString(3, manpad.getPhoto());
            st.setInt(4, id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
