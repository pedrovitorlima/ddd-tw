package com.tw.dddtw.domain;

import com.tw.dddtw.Price;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    private String name;
    private Price price;
}
