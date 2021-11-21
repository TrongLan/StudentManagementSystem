package NightOwlTV.WebMovie.Repository;

import NightOwlTV.WebMovie.Entity.User;
import NightOwlTV.WebMovie.entityPK.UserPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, UserPK>{
    @Query(value="SELECT TOP(1) * FROM [User]",nativeQuery = true)
    User theFirstUser();
}
