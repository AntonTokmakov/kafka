package tech.razymov.omega.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Product {

    private Long id;
    private String name;
    private int amount;
    private ProductStatus productStatus;

    public enum ProductStatus {
        OUTOFSTOCK,
        INSTOCK,
        RESERVED
    }

}
