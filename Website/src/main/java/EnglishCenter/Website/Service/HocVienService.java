package EnglishCenter.Website.Service;

import EnglishCenter.Website.Entities.HocVien;
import java.util.List;

public interface HocVienService {
    List<HocVien> danhSachTatCaHocVien();
    HocVien TaoHocVienMoi(HocVien hv);
    void xoaHocVien(String id);
    List<HocVien> timKiemHocVienVoiTuKhoa(String keyword);
    HocVien chonHocVien(String id);
    boolean daTonTaiHocVien(String id);
}
