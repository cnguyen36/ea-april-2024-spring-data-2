package miu.ea.group3g.lab4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "activity_log")
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String operation;

    private int duration;

    public Activity(LocalDate date, String operation, int duration) {
        this.date =date;
        this.operation = operation;
        this.duration = duration;
    }

    public Activity() {

    }
}
