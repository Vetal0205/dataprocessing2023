package dp2023.lab6.Repositories;
import dp2023.lab6.Entities.Manpads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManpadsRepository extends JpaRepository<Manpads, Integer> {

}
