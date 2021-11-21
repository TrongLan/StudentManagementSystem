package NightOwlTV.WebMovie.entityPK;

import java.io.Serializable;

public class UserPK implements Serializable{
    private String acc_id;
    private String nickname;

    public UserPK(String acc_id, String nickname) {
        this.acc_id = acc_id;
        this.nickname = nickname;
    }

    public UserPK() {
    }
    
}
