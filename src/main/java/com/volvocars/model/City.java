package com.volvocars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Column(nullable = false)
    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
