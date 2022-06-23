package com.milosskovac.rezervisi.views;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter @Setter
@Entity
@Table(name = "cityview", schema="rezervisi")
@org.hibernate.annotations.Immutable
public class ViewCity implements Serializable {

    @Id
    /*@Column(name ="id")
    private int id;*/

    @Column(name="name")
    private String name;
}
