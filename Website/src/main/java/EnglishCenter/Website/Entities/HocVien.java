package EnglishCenter.Website.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "hocvien")
public class HocVien {
    @Id
    @Column(name = "id",length = 5,nullable = false,unique = true)
    private String id;
    @Column(name = "ten", length = 30, nullable = false)
    private String ten;
    @Column(name = "ngay_sinh", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngaySinh;
    @Column(name = "gioi_tinh", nullable = false, length = 10 )
    private String gioiTinh;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "so_dien_thoai", nullable = true, length = 10)
    private String soDienThoai;
    @OneToMany(mappedBy = "hv", cascade = CascadeType.REMOVE)
    private List<Enroll> enrolls;

    public HocVien(String id, String ten, LocalDate ngaySinh, String gioiTinh, String email, String soDienThoai) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.enrolls = new ArrayList<>();
    }

    public HocVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<Enroll> getEnrolls() {
        return enrolls;
    }

    public void setEnrolls(List<Enroll> enrolls) {
        this.enrolls = enrolls;
    }
    
}
