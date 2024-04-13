package miu.ea.group3g.lab4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class ProductBatchLazy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    @BatchSize(size = 100)
    private List<ReviewBatchLazy> reviews;
}

