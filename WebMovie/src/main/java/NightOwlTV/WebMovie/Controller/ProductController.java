package NightOwlTV.WebMovie.Controller;

import NightOwlTV.WebMovie.Service.ProductService;
import NightOwlTV.WebMovie.entityPK.ProductPK;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private ProductService pService;

    public ProductController(ProductService pService) {
        this.pService = pService;
    }

    @GetMapping("/all-movies")
    public String getAllProducts(Model mod){
        mod.addAttribute("movies",pService.showProducts());
        mod.addAttribute("title", "All");
        return "movies";
    }
    
    @GetMapping("/search-results")
    public String getAllProductsByName(Model mod, @RequestParam(value="keyword", required = true) String name){
        mod.addAttribute("movie_name", name);
        mod.addAttribute("movies", pService.showProductsWithName(name));
        return "search_result";
    }
    
    @GetMapping("movie-info/{id}/{ep}/{ss}")
    public String getProductByKey(@PathVariable String id, @PathVariable int ep, @PathVariable int ss, Model mod){
        ProductPK key = new ProductPK(id,ep,ss);
        mod.addAttribute("movie", pService.showMovieInfo(key));
        return "movie_info";
    }
    @GetMapping("/top-movies")
    public String getAllTopProducts(Model mod){
        mod.addAttribute("movies",pService.showTopMovies());
        mod.addAttribute("title", "Top");
        return "movies";
    }
    @GetMapping("/this-year-movies")
    public String getAllCurrentYearProducts(Model mod, LocalDate b){
        LocalDate today = LocalDate.now();
        b = today.with(firstDayOfYear());
        mod.addAttribute("title", ""+b.getYear());
        mod.addAttribute("movies",pService.showCurrentYearProducts(b));
        return "movies";
    }
}
