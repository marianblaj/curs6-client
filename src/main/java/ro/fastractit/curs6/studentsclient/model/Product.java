package ro.fastractit.curs6.studentsclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.fastractit.curs6.studentsclient.enums.Category;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    Long id;

    private String name;
    private int price;
    private String description;
    Category category;

    public Product(String name, int price, String description, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }


}
