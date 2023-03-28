package dp2023.lab8.Repositories;
import dp2023.lab8.Entities.Manpads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*")
@RepositoryRestResource(path="Lab_dp")
public interface ManpadsRepository extends JpaRepository<Manpads, Integer> {}
