package NightOwlTV.WebMovie.Service.Implement;

import NightOwlTV.WebMovie.Entity.User;
import NightOwlTV.WebMovie.Repository.UserRepo;
import NightOwlTV.WebMovie.Service.UserService;
import NightOwlTV.WebMovie.entityPK.UserPK;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo uRepo;

    public UserServiceImpl(UserRepo uRepo) {
        this.uRepo = uRepo;
    }

    @Override
    public User getUserByKey(UserPK key) {
        return uRepo.findById(key).get();
    }

    @Override
    public User saveUser(User u) {
        return uRepo.save(u);
    }

    @Override
    public List<User> showAllUsers() {
        return uRepo.findAll();
    }    
}
