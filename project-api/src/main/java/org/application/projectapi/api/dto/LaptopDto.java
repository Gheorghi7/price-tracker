package org.application.projectapi.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LaptopDto {

    String brand;

    Integer page;



}
