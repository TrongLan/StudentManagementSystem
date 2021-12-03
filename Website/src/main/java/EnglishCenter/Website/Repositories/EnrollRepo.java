package EnglishCenter.Website.Repositories;

import EnglishCenter.Website.Entities.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepo extends JpaRepository<Enroll, Long>{
    
}
