package com.milosskovac.rezervisi.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name="object",schema="rezervisi")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "MainObject",procedureName = "MainObject",
parameters = {@StoredProcedureParameter(mode= ParameterMode.IN,name= "objName",type=String.class),
            @StoredProcedureParameter(mode= ParameterMode.IN,name= "objStreet",type=String.class),
            @StoredProcedureParameter(mode= ParameterMode.IN,name= "objNumber",type=String.class),
            @StoredProcedureParameter(mode= ParameterMode.IN,name= "objDistr",type=String.class),
            @StoredProcedureParameter(mode= ParameterMode.IN,name= "cityName",type=String.class),
            @StoredProcedureParameter(mode= ParameterMode.IN,name= "activityName",type=String.class)
           // @StoredProcedureParameter(mode= ParameterMode.OUT,name= "id",type=Integer.class)
        } )})
public class Objects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String street;
    private String number;
    private String district;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_city", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private City city;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_activity", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Activity activity;
}
