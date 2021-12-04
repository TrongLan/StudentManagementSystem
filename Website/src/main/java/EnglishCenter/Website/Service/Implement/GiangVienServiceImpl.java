package EnglishCenter.Website.Service.Implement;

import EnglishCenter.Website.Entities.Course;
import EnglishCenter.Website.Entities.GiangVien;
import EnglishCenter.Website.Repositories.GiangVienRepo;
import EnglishCenter.Website.Service.GiangVienService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GiangVienServiceImpl implements GiangVienService{
    private GiangVienRepo gvRepo;

    public GiangVienServiceImpl(GiangVienRepo gvRepo) {
        this.gvRepo = gvRepo;
    }
    
    @Override
    public List<GiangVien> danhSachTatCaGiangVien() {
        return gvRepo.findAll();
    }

    @Override
    public GiangVien TaoGiangVienMoi(GiangVien hv) {
        return gvRepo.save(hv);
    }

    @Override
    public void xoaGiangVien(String id) {
        gvRepo.deleteById(id);
    }

    @Override
    public List<GiangVien> timKiemGiangVienVoiTuKhoa(String keyword) {
        return gvRepo.timKiemGiangVienVoiTuKhoa(keyword);
    }

    @Override
    public void nghiDay(String id) {
        gvRepo.ngungDayTatCaKhoaHoc(id);
    }

    @Override
    public GiangVien chonGiangVien(String id) {
        return gvRepo.getById(id);
    }

    @Override
    public boolean daTonTaiGiangVien(String id) {
        return gvRepo.existsById(id);
    }

    
}
