package com.crudservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrudDto {  //data transfer object
    private Long id;
    private String text;
    private UserDto user;
}
