package dp2023.lab5.DAO;

import dp2023.lab5.models.Manpads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManpadsDAO extends JpaRepository<Manpads, Integer> { }