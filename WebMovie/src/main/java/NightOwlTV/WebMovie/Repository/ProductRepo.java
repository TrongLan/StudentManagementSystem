/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NightOwlTV.WebMovie.Repository;

import NightOwlTV.WebMovie.Entity.Product;
import NightOwlTV.WebMovie.entityPK.ProductPK;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Lenovo T440s
 */
public interface ProductRepo extends JpaRepository<Product, ProductPK>{
    
    @Query(value = "SELECT * FROM Product WHERE LOWER(name) LIKE %?1% ORDER BY [view] DESC", nativeQuery = true)
    List<Product> searchByName(String name);
    
    @Query(value = "SELECT TOP(9) * FROM Product ORDER BY [view] DESC", nativeQuery = true)
//    @Query(value = "SELECT p.[name], p.season, SUM(p.[view]) FROM Product p GROUP BY p.[name], p.season", nativeQuery = true)        
    List<Product> topMovies();
    
    @Query(value = "SELECT * FROM Product WHERE release_date >= ?1 ORDER BY release_date DESC", nativeQuery = true)
    List<Product> currentYearMovies(LocalDate b);
}
