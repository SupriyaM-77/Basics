package com.example.SpringData.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "bigboss")
public class Contestant {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String name;
    private int votes;

    public Contestant( String name, int votes){

        this.name = name;
        this.votes = votes;
    }
}
