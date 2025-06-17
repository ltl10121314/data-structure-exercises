package com.exercises.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private String code;
    private String name;
    private Integer seq;
}
