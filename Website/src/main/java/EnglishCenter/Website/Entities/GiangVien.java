package EnglishCenter.Website.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "giangvien")
public class GiangVien {
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
    @Column(name = "luong", nullable = false)
    private int luong;
    @OneToMany(mappedBy = "gv")
    List<Course> teaches;
    
    public GiangVien() {
        
    }

    public GiangVien(String id, String ten, LocalDate ngaySinh, String gioiTinh, String email, String soDienThoai, int luong) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.luong = luong;
        this.teaches = new ArrayList<>();
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

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public List<Course> getTeaches() {
        return teaches;
    }

    public void setTeaches(List<Course> teaches) {
        this.teaches = teaches;
    }
    
}
