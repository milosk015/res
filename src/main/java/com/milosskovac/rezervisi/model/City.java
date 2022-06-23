package com.milosskovac.rezervisi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//@Validated
@Getter @Setter
@Entity
@Table(name="city",schema="rezervisi")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "getCityCount",procedureName = "getCityCount")})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(unique = true)
    private String name;

   /* @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Objects> objects; */
}
