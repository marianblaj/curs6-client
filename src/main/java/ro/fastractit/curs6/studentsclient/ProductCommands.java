package ro.fastractit.curs6.studentsclient;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fastractit.curs6.studentsclient.enums.Category;
import ro.fastractit.curs6.studentsclient.model.Product;
import ro.fastractit.curs6.studentsclient.service.ProductService;

import java.util.Scanner;

@ShellComponent
@AllArgsConstructor
public class ProductCommands {
    private ProductService service;

    @ShellMethod("print all products")
    void printAllProducts() {
        service.getAll()
                .forEach(System.out::println);
    }

    @ShellMethod("Get product by Id")
    void getProductById() {
        System.out.println("id:");
        System.out.println(service.getById(new Scanner(System.in).nextInt()));
    }

    @ShellMethod("Get product by Category")
    void getProductsByCategory() {
        System.out.println("Category:");
        System.out.println(service.getProductsByCategory(new Scanner(System.in).next()));
    }

    @ShellMethod("Get product by Max Price")
    void getProductsMaxPrice() {
        System.out.println("Category:");
        System.out.println(service.getProductsByMaxPrice(new Scanner(System.in).nextInt()));
    }

    @ShellMethod("Add a product;")
    void addProduct() {
       service.addProduct(new Product("produs nou", 800, "descriere noua", Category.CATEGORY2));
    }

    @ShellMethod("Delete product by Id:")
    void deleteProduct() {
        System.out.println("Product id:");
        service.deleteProductById(new Scanner(System.in).nextInt());
    }

}
