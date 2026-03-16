package jpa.example.basexamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 100, name = "name_team")
    private String nameTeam;

    // Relaciones

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
//    @JsonIgnore
    private List<Player> players;

    @OneToOne(targetEntity = Stadium.class)
    @JoinColumn(name = "id_stadium")
    private Stadium stadium;

}
