/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishCenter.Website.Repositories;

import EnglishCenter.Website.Entities.HocVien;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Lenovo T440s
 */
public interface HocVienRepo extends JpaRepository<HocVien, String>{
    @Query(value = "SELECT * FROM hocvien WHERE LOWER(ten) LIKE %?1% OR LOWER(id) LIKE %?1%", nativeQuery = true)
    List<HocVien> timKiemHocVienVoiTuKhoa(String keyword); 
}
