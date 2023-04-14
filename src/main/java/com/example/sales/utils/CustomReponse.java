package com.example.sales.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CustomReponse<T> {
    T data;
    Boolean error;
    int statusCode;
    String message;

}
