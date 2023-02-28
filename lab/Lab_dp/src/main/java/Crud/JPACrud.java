package Crud;

import Entities.Manpads;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class JPACrud implements LabCRUDInterface<Manpads> {
    private static Session openedSession;
    public JPACrud(Session session){
        try {
            openedSession = session;
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Manpads> read() {
        List<Manpads> manpads = new ArrayList<>();
        try {
            manpads = (List<Manpads>) openedSession.createQuery("FROM Manpads", Manpads.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manpads;
    }

    @Override
    public void create(Manpads manpads) {
        Transaction transaction = null;
        try {
            transaction = openedSession.beginTransaction();
            openedSession.save(manpads);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try {
            transaction = openedSession.beginTransaction();
            Manpads person = openedSession.get(Manpads.class, id);
            openedSession.delete(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Manpads manpads) {
        Transaction transaction = null;
        try {
            transaction = openedSession.beginTransaction();
            Manpads oldManpad = openedSession.get(Manpads.class, id);
            if (oldManpad != null) {
                oldManpad.setName(manpads.getName());
                oldManpad.setPhoto(manpads.getPhoto());
                oldManpad.setWeight(manpads.getWeight());
                openedSession.update(oldManpad);
            }
            openedSession.update(manpads);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
