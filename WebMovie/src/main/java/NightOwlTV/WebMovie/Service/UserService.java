package NightOwlTV.WebMovie.Service;

import NightOwlTV.WebMovie.Entity.User;
import NightOwlTV.WebMovie.entityPK.UserPK;
import java.util.List;

public interface UserService {
    User getUserByKey(UserPK key);
    User saveUser(User u);
    List<User> showAllUsers();
}
