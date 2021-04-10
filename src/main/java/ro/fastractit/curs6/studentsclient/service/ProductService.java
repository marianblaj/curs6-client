package ro.fastractit.curs6.studentsclient.service;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ro.fastractit.curs6.studentsclient.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @SneakyThrows
    public Product getById(int studentId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/students/" + studentId, Product.class);
    }

    @SneakyThrows
    public List<Product> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8080/products/all",
                        Product[].class);
        return Arrays.asList(response.getBody());
    }

    @SneakyThrows
    public List<Product> getProductsByCategory(String category) {
        RestTemplate restTemplate = new RestTemplate();
        var response =
                restTemplate.getForEntity(
                        "http://localhost:8080/products/all",
                        Product[].class);
        var result = Arrays.asList(response.getBody()).stream()
                .filter(product -> product.getCategory().name().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        return result;
    }

    @SneakyThrows
    public List<Product> getProductsByMaxPrice(int maxPrice) {
        RestTemplate restTemplate = new RestTemplate();
        var response =
                restTemplate.getForEntity(
                        "http://localhost:8080/products/all",
                        Product[].class);
        var result = Arrays.asList(response.getBody()).stream()
                .filter(product -> product.getPrice() < maxPrice)
                .collect(Collectors.toList());
        return result;
    }

    @SneakyThrows
    public void addProduct(Product product) {
        RestTemplate restTemplate = new RestTemplate();
       restTemplate.postForObject(
                "http://localhost:8080/products/",
                product,
                Product.class);
    }

    @SneakyThrows
    public void deleteProductById(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(
                "http://localhost:8080/products/{productId}",
                productId
        );
    }
}
