package com.pokemonreview.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data//adds all getters and setters using lombok
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity//let database know that this entity needs to go to the database
public class Pokemon {
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//database will handle the generation of primary key
    private int id;
    private String name;
    private String type;

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<Review>();
}
