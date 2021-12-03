package EnglishCenter.Website.Entities;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "enroll")
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "hv_id", nullable = false)
    private HocVien hv;
    @ManyToOne
    @JoinColumn(name = "c_id", nullable = false)
    private Course c;
    @Column(name = "ngay_dang_ky")
    private LocalDate ngayDangKy;

    public Enroll() {
    }

    public Enroll(long id, HocVien hv, Course c, LocalDate ngayDangKy) {
        this.id = id;
        this.hv = hv;
        this.c = c;
        this.ngayDangKy = ngayDangKy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HocVien getHv() {
        return hv;
    }

    public void setHv(HocVien hv) {
        this.hv = hv;
    }

    public Course getC() {
        return c;
    }

    public void setC(Course c) {
        this.c = c;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
    
}
