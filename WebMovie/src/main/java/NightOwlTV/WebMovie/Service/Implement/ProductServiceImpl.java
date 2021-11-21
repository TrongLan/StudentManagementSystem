package NightOwlTV.WebMovie.Service.Implement;

import NightOwlTV.WebMovie.Entity.Product;
import NightOwlTV.WebMovie.Repository.ProductRepo;
import NightOwlTV.WebMovie.Service.ProductService;
import NightOwlTV.WebMovie.entityPK.ProductPK;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepo pRepo;

    public ProductServiceImpl(ProductRepo pRepo) {
        this.pRepo = pRepo;
    }

    @Override
    public List<Product> showProducts() {
        return pRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Product> showProductsWithName(String name) {
        return pRepo.searchByName(name);
    }

    @Override
    public Product showMovieInfo(ProductPK key) {
        return pRepo.findById(key).get();
    }

    @Override
    public List<Product> showTopMovies() {
        return pRepo.topMovies();
    }

    @Override
    public List<Product> showCurrentYearProducts(LocalDate b) {
        return pRepo.currentYearMovies(b);
    }
    
    
    
}
