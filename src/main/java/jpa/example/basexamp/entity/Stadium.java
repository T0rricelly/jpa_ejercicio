package jpa.example.basexamp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stadium")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, name = "name_stadium")
    private String nameStadium;

    @Column(nullable = false)
    private Integer quantity;

    @OneToOne(targetEntity = CityStadium.class)
    @JoinColumn(name = "id_city")
    private CityStadium cityStadium;


}
