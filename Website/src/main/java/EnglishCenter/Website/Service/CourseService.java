package EnglishCenter.Website.Service;
import EnglishCenter.Website.Entities.Course;
import EnglishCenter.Website.Entities.GiangVien;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    List<Course> timKiemKhoaHocVoiTuKhoa(String key);
    void xoaKhoaHoc(String id);
    Course taoKhoaHocMoi(Course c);
    Course getCourseByID(String id);
    List<String[]> danhSachGiangVien();
    boolean daTonTaiKhoaHoc(String id);
}
