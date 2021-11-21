package NightOwlTV.WebMovie.Service;

import NightOwlTV.WebMovie.Entity.User;
import NightOwlTV.WebMovie.Entity.Watch;
import java.util.List;

public interface WatchService {
    Watch saveWatch(Watch w);
    List<Watch> getAllWatch();
}
