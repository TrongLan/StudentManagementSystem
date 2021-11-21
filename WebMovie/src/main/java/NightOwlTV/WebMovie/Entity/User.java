package NightOwlTV.WebMovie.Entity;

import NightOwlTV.WebMovie.entityPK.UserPK;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;
@Entity
@IdClass(UserPK.class)
@Table(name = "[User]")
public class User {
    @Id
    @Column(name = "acc_id", updatable = false, columnDefinition = "char(10)")
    private String acc_id;
    @Id
    @Column(name = "nickname", updatable = false, length = 100)
    private String nickname;
    @Column(name = "login_date", nullable = false)
    private LocalDate login_date;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    
    @OneToMany(mappedBy = "u")
    private List<Watch> watches;

    public User(String acc_id, String nickname, LocalDate login_date, String password) {
        this.acc_id = acc_id;
        this.nickname = nickname;
        this.login_date = login_date;
        this.password = password;
        this.watches = new ArrayList<>();
    }

    public User() {
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getLogin_date() {
        return login_date;
    }

    public void setLogin_date(LocalDate login_date) {
        this.login_date = login_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Watch> getWatches() {
        Collections.sort(watches);
        Collections.reverse(watches);
        return watches;
    }

    public void setWatches(List<Watch> watches) {
        this.watches = watches;
    }

    
}
