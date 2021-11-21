package NightOwlTV.WebMovie.Repository;

import NightOwlTV.WebMovie.Entity.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WatchRepo extends JpaRepository<Watch, Long>{
}
