package com.exam.controllers;

import com.exam.entities.Project;
import com.exam.entities.User;
import com.exam.services.IExamenservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Examcontroller {
    private final IExamenservice iExamenservice;
    @PostMapping("/adduser")
    //requestBody: paramétre user ki t7otha spring yefhem enou bch enrigistri fil bd (o dima n7otha m3a kol post)
    public User addUser(@RequestBody User user){
        return iExamenservice.addUser(user);
    }
    @PostMapping("/addprojet")
    public Project addProject (@RequestBody Project project){
        return iExamenservice.addProject(project);
    }
    @PutMapping("/putProjet")
    public void assignProjectToUser (@PathVariable int UserId, @PathVariable int ProjetID){
        iExamenservice.assignProjectToUser(UserId, ProjetID);

    }
}
