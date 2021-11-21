package NightOwlTV.WebMovie.Entity;

import NightOwlTV.WebMovie.entityPK.ProductPK;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@IdClass(ProductPK.class)
@Table(name="Product")
public class Product {
    @Id
    @Column(name = "id", updatable = false, columnDefinition = "char(20)")
    private String id;
    @Id
    @Column(name = "episode", updatable = false)
    private int ep;
    @Id
    @Column(name = "season", updatable = false)
    private int ss;
    @Column(name="name", nullable=false, length = 100)
    private String name;
    @Column(name="description", length = 1000)
    private String descript;
    @Column(name="time", nullable=false)
    private int time;
    @Column(name="nation", nullable=false, length = 100)
    private String nation;
    @Column(name="age_limit", nullable=false)
    private int age_limit;
    @Column(name="[view]", nullable=false)
    private int view;
    @Column(name = "release_date", nullable = false)
    private LocalDate release_date;
    @Column(name = "image_link")
    private String image_link;
    
    @OneToMany(mappedBy = "p")
    private List<Watch> is_watch; 

    public Product(String id, String name, int ep, int ss, String descript, int time, String nation, int age_limit, int view, String link) {
        this.id = id;
        this.name = name;
        this.ep = ep;
        this.ss = ss;
        this.descript = descript;
        this.time = time;
        this.nation = nation;
        this.age_limit = age_limit;
        this.view = view;
        this.image_link = link;
        this.is_watch = new ArrayList<>();
    }

    public Product() {
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(int age_limit) {
        this.age_limit = age_limit;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public List<Watch> getIs_watch() {
        return is_watch;
    }

    public void setIs_watch(List<Watch> is_watch) {
        this.is_watch = is_watch;
    }

    
}
