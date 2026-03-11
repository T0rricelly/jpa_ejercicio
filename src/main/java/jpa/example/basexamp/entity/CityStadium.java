package jpa.example.basexamp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "city_stadium")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityStadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, name = "name_city")
    private String nameCity;
}
