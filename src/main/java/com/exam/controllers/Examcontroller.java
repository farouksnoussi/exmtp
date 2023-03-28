package com.exam.controllers;

import com.exam.entities.Project;
import com.exam.entities.Sprint;
import com.exam.entities.User;
import com.exam.services.IExamenservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Examcontroller {
    private final IExamenservice iExamenservice;
    @PostMapping("/adduser")
    //requestBody: paramétre user ki t7otha spring yefhem enou bch enrigistri fil bd (o dima n7otha m3a kol post) (yet3ada fil body)
    //pathvariable (yet3ada URL)
    public User addUser(@RequestBody User user){
        return iExamenservice.addUser(user);
    }
    @PostMapping("/addprojet")
    public Project addProject (@RequestBody Project project){
        return iExamenservice.addProject(project);
    }
    @PutMapping("/putProjet/{UserId}/{ProjetID}")
    public void assignProjectToUser (@PathVariable int UserId, @PathVariable int ProjetID){
        iExamenservice.assignProjectToUser(UserId, ProjetID);
    }
    @PutMapping("/assignProjectClient/{projectId}/{firstName}/{lastName}")
    public void assignProjectToClient(@PathVariable int projectId,@PathVariable String firstName,@PathVariable String lastName) {
        iExamenservice.assignProjectToClient(projectId, firstName, lastName);
    }
    @GetMapping("/currentProjects")
    public List<Project> getAllCurrentProject() {
        return iExamenservice.getAllCurrentProject();
    }

    @GetMapping("/getprojects/{fName}/{lName}")
    public List<Project> getProjectsByScrumMaster(@PathVariable String fName,@PathVariable String lName) {
        return iExamenservice.getProjectsByScrumMaster(fName, lName);
    }

    @PostMapping("/addsprint/{idProject}")
    public void assignSprintToProject(@RequestBody Sprint sprint, @PathVariable int idProject) {
        iExamenservice.addSprintAndAssignToProject(sprint, idProject);
    }
}
