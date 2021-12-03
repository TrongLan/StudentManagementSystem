package EnglishCenter.Website.Service;
import EnglishCenter.Website.Entities.GiangVien;
import java.util.List;

public interface GiangVienService {
    List<GiangVien> danhSachTatCaGiangVien();
    GiangVien TaoGiangVienMoi(GiangVien hv);
    void xoaGiangVien(String id);
    List<GiangVien> timKiemGiangVienVoiTuKhoa(String keyword);
    void nghiDay(String id);
    GiangVien chonGiangVien(String id);
}
