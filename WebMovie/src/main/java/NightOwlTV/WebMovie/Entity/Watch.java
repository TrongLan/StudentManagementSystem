package NightOwlTV.WebMovie.Entity;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="Watch")
public class Watch implements Comparable<Watch>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stt;
    @ManyToOne
    @JoinColumn(name = "acc_id", nullable = false)
    @JoinColumn(name = "nickname", nullable = false)
    private User u;
    @ManyToOne
    @JoinColumn(name = "episode", nullable = false)
    @JoinColumn(name = "id", nullable = false, columnDefinition = "char(20)")
    @JoinColumn(name = "season", nullable = false)
    private Product p;
    @Column(name = "last_watch", nullable = false)
    private LocalDate last_watch; 
    @Column(name = "evaluated", nullable = false)
    private int evaluated;
    @Column(name = "last_time_line", nullable = false)
    private int last_time_line;
    @Column(name = "total_time", nullable = false)
    private int total_time;

    public Watch(User u, Product p, LocalDate last_watch, int total_time, int last_time_line) {
        this.u = u;
        this.p = p;
        this.last_watch = last_watch;
        this.evaluated = 0;
        this.total_time = total_time;
        this.last_time_line = last_time_line;
    }

    public Watch() {
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public LocalDate getLast_watch() {
        return last_watch;
    }

    public void setLast_watch(LocalDate last_watch) {
        this.last_watch = last_watch;
    }

    public int getEvaluated() {
        return evaluated;
    }

    public void setEvaluated(int evaluated) {
        this.evaluated = evaluated;
    }

    public int getLast_time_line() {
        return last_time_line;
    }

    public void setLast_time_line(int last_time_line) {
        this.last_time_line = last_time_line;
    }

    public int getTotal_time() {
        return total_time;
    }

    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }

    
    
    @Override
    public int compareTo(Watch o) {
        return last_watch.compareTo(o.last_watch);
    }
    
}
