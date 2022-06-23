package com.milosskovac.rezervisi.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name="term",schema="rezervisi")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp dateTerm;
    private String price;
    private String termFrom;
    private String termTo;
    private String priceDiscount;
    private Timestamp cancelTime;
}
