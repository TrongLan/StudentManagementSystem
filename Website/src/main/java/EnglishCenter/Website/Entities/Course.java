package EnglishCenter.Website.Entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(updatable = false, length = 5)
    private String id;

    @Column(name = "ten", nullable = false, length = 50)
    private String ten;

    @Column(name = "hoc_phi", nullable = false)
    private int hocPhi;

    @Column(name = "so_hoc_vien", nullable = false)
    private int soHocVien;

    @Column(name = "thoi_luong", nullable = false)
    private int thoiLuong;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = true)
    private GiangVien gv;
    
    @OneToMany(mappedBy = "c", cascade = CascadeType.REMOVE)
    private List<Enroll> enrolled;

    public Course(){
    }

    public Course(String Id, String ten, int hocPhi, int soHocVien, int thoiLuong, GiangVien gv) {
        this.id = Id;
        this.ten = ten;
        this.hocPhi = hocPhi;
        this.soHocVien = soHocVien;
        this.thoiLuong = thoiLuong;
        this.gv = gv;
        this.enrolled = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getSoHocVien() {
        return soHocVien;
    }

    public void setSoHocVien(int soHocVien) {
        this.soHocVien = soHocVien;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public GiangVien getGv() {
        return gv;
    }

    public void setGv(GiangVien gv) {
        this.gv = gv;
    }

    public List<Enroll> getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(List<Enroll> enrolled) {
        this.enrolled = enrolled;
    }

    public int tongTien() {
        return this.hocPhi * this.soHocVien;
    }
}
