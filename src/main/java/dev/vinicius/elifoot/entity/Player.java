package dev.vinicius.elifoot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Position position;

    private int shirtNumber;

    private String urlImg;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;


}
