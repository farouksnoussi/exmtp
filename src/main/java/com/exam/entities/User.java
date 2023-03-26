package com.exam.entities;

import javax.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String pwd;
    private String fname;
    private String lname;
    @Enumerated(EnumType.STRING)
    private role role;

    @ManyToMany
    private List<Project> projects;

    @OneToMany
    List<Project> project;
}