package EnglishCenter.Website.Service.Implement;

import EnglishCenter.Website.Entities.Course;
import EnglishCenter.Website.Repositories.CourseRepo;
import EnglishCenter.Website.Service.CourseService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepo cRepo;

    public CourseServiceImpl(CourseRepo cRepo) {
        this.cRepo = cRepo;
    }
    
    @Override
    public List<Course> getAllCourse() {
        return cRepo.findAll();
    }

    @Override
    public List<Course> timKiemKhoaHocVoiTuKhoa(String key) {
        return cRepo.timKiemKhoaHocVoiTuKhoa(key);
    }

    @Override
    public void xoaKhoaHoc(String id) {
        cRepo.deleteById(id);
    }

    @Override
    public Course taoKhoaHocMoi(Course c) {
        return cRepo.save(c);
    }
    
}
