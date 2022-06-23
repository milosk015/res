package com.milosskovac.rezervisi.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="review",schema="rezervisi")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int objectId;
    private int userId;
    private int number;
    private String comment;
}
