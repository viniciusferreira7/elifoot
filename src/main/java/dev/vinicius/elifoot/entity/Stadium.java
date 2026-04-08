package dev.vinicius.elifoot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stadium")
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stadium_seq")
    @SequenceGenerator(name = "stadium_seq", sequenceName = "stadium_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false,  length = 255)
    private String name;

    @Column(nullable = false,  length = 255)
    private String city;
    private Integer capacity;

    @Column(name = "url_img", length = 255)
    private String urlImg;
}
