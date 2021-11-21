package NightOwlTV.WebMovie.Service.Implement;

import NightOwlTV.WebMovie.Entity.User;
import NightOwlTV.WebMovie.Entity.Watch;
import NightOwlTV.WebMovie.Repository.WatchRepo;
import NightOwlTV.WebMovie.Service.WatchService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WatchServiceImpl implements WatchService{
    private WatchRepo wRepo;

    public WatchServiceImpl(WatchRepo wRepo) {
        this.wRepo = wRepo;
    }

    @Override
    public Watch saveWatch(Watch w) {
        return wRepo.save(w);
    }

    @Override
    public List<Watch> getAllWatch() {
        return wRepo.findAll();
    }
    
}
