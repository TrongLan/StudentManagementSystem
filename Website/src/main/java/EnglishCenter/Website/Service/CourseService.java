package EnglishCenter.Website.Service;
import EnglishCenter.Website.Entities.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    List<Course> timKiemKhoaHocVoiTuKhoa(String key);
    void xoaKhoaHoc(String id);
    Course taoKhoaHocMoi(Course c);
}
