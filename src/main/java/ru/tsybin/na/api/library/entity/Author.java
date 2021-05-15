package ru.tsybin.na.api.library.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    private Long id;
    private String name;
}
