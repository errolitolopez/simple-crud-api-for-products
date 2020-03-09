package com.errolitolopez.simplecrudapiforproducts.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private Long quantity;
}
