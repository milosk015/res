package com.milosskovac.rezervisi.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CityDTO {

    private  int id;

    @NotBlank(message = "Name is mandatory")
    private String name;
}
