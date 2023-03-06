package dp2023.lab5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dp2023.lab5.DAO.ManpadsDAO;
import dp2023.lab5.models.Manpads;

@Service
public class ManpadsService {

    @Autowired
    private ManpadsDAO manpadsDao;

    public List<Manpads> getAllManpads() {
        return manpadsDao.findAll();
    }

    public Manpads getManpadsById(int id) {
        return manpadsDao.findById(id).orElse(null);
    }

    public void saveOrUpdateManpads(Manpads manpads) {
        manpadsDao.save(manpads);
    }

    public void deleteManpads(int id) {
        manpadsDao.deleteById(id);
    }
}