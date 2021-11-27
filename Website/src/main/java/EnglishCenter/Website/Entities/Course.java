package EnglishCenter.Website.Entities;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(updatable = false, length = 5)
    private String id;

    @Column(name = "ten", nullable = false, length = 20)
    private String ten;

    @Column(name = "hoc_phi", nullable = false)
    private int hocPhi;

    @Column(name = "so_hoc_vien", nullable = false)
    private int soHocVien;

    @Column(name = "thoi_luong", nullable = false)
    private int thoiLuong;

    public Course(){
    }

    public Course(String Id, String ten, int hocPhi, int soHocVien, int thoiLuong) {
        this.id = Id;
        this.ten = ten;
        this.hocPhi = hocPhi;
        this.soHocVien = soHocVien;
        this.thoiLuong = thoiLuong;
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


//    public String trangThai() {
//        if (soHocVien >= 40) {
//            return "da day";
//        } else {
//            return "chua day";
//        }
//    }

    public int tongTien() {
        return this.hocPhi * this.soHocVien;
    }
}
