package miu.ea.group3g.lab4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customer_order") // Specify the table name explicitly
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product_name;

    private int quantity;

    private int total_price;

    @ManyToOne
//    @JoinColumn(name = "customer_id")
    private Customer customer;

    // getters and setters
}