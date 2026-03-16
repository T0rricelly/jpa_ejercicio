package jpa.example.basexamp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    private Integer id;

    private String name;

    private String lastName;

    private Integer age;

    private String nationality;
}
