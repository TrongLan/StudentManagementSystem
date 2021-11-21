/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NightOwlTV.WebMovie.Service;

import NightOwlTV.WebMovie.Entity.Product;
import NightOwlTV.WebMovie.entityPK.ProductPK;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Lenovo T440s
 */
public interface ProductService {
    List<Product> showProducts();
    List<Product> showProductsWithName(String name);
    Product showMovieInfo(ProductPK key);
    List<Product> showTopMovies();
    List<Product> showCurrentYearProducts(LocalDate b) ;
}
