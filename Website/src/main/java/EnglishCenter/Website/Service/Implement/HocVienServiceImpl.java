package EnglishCenter.Website.Service.Implement;

import EnglishCenter.Website.Entities.HocVien;
import EnglishCenter.Website.Repositories.HocVienRepo;
import EnglishCenter.Website.Service.HocVienService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HocVienServiceImpl implements HocVienService{
    private HocVienRepo hvRepo;

    public HocVienServiceImpl(HocVienRepo hvRepo) {
        this.hvRepo = hvRepo;
    }
    
    @Override
    public List<HocVien> danhSachTatCaHocVien() {
        return hvRepo.findAll();
    }

    @Override
    public HocVien TaoHocVienMoi(HocVien hv) {
        return hvRepo.save(hv);
    }

    @Override
    public void xoaHocVien(String id) {
        hvRepo.deleteById(id);
    }

    @Override
    public List<HocVien> timKiemHocVienVoiTuKhoa(String keyword) {
        return hvRepo.timKiemHocVienVoiTuKhoa(keyword);
    }
    
}
