package com.map.example.Controller;

import com.map.example.Repository.CatRepo;
import com.map.example.Repository.ProductRepo;
import com.map.example.model.Address;
import com.map.example.model.Category;
import com.map.example.model.Product;
import com.map.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ProductController {

    @Autowired
    CatRepo crepo;

    @Autowired
    ProductRepo prepo;


   @GetMapping("/Product")
   public List<Product> getProducts(){
    List<Product> products=prepo.findAll();
    return products;
   }

   @GetMapping("/Product/{pid}")
   public Product getProduct(@PathVariable("pid") int pid){
    Product product=prepo.findById(pid).orElse( new Product());
    return product;
   }


    @PostMapping("/Product")
  public Product addProduct(@RequestBody Product prod){
        Product pro1 =prepo.save(prod);
        List<Category> cat=pro1.getCategories();
        cat.forEach(catego -> {
            catego.getProductList();
            crepo.save(catego);
        });

      return pro1;
    }


    @PutMapping("/Product")
    public Product getProducts(@RequestBody Product prod){
       // System.out.println(prod);

       prepo.save(prod);
        return prod;
    }

    @DeleteMapping("/Product/{pid}")
    public String deleteProduct (@PathVariable("pid") int pid){
        Optional<Product> prod=prepo.findById(pid);
        prepo.deleteById(pid);
      return ("product is delete");

    }








}
