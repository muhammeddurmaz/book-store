package com.muhammed.bookstore.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String author;
    private Double price;
    private Integer stock;
}
