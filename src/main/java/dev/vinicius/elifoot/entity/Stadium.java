package dev.vinicius.elifoot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stadium")
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,  length = 255)
    private String name;

    @Column(nullable = false,  length = 255)
    private String city;
    private Integer capacity;

    @Column(name = "url_img", length = 255)
    private String urlImg;
}
