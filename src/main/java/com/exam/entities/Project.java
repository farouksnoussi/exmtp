package com.exam.entities;

import javax.persistence.*;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @ManyToMany(mappedBy = "projects")
    private List<User> userList;

    @OneToMany(mappedBy = "project")
    private List<Sprint> sprintList;
}
