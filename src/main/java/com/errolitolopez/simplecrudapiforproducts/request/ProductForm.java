package com.errolitolopez.simplecrudapiforproducts.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize
public class ProductForm {

    @NotNull(message = "name required")
    @Length(max = 256, message = "name too long")
    private String name;

    @Length(max = 256, message = "description too long")
    private String description;

    @NotNull(message = "quantity required")
    @PositiveOrZero
    @Max(value = 99)
    private Long quantity;
}
