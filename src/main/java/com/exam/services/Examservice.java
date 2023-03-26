package com.exam.services;

import com.exam.entities.Project;
import com.exam.entities.User;
import com.exam.repositories.ProjectRepository;
import com.exam.repositories.SprintRepository;
import com.exam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class Examservice implements IExamenservice {
    private final ProjectRepository projectRepository;
    private final SprintRepository sprintRepository;
    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
    @Transactional // ychouf les metthodes lkol idhaken s7a7 lkol wa9tha ysavi fil bd
    public Project addProject(Project project) {
        //saveAndflash : tsajel entity hedhika fil bd
        projectRepository.saveAndFlush(project);
        project.getSprintList().forEach(sprint -> {sprint.setProject(project);}); //kol sprint tzidou ysavih fil projet
        return project;
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project project = projectRepository.findById(projectId).orElse(null); // yetraja3 projet wela null
        User user = userRepository.findById(userId).orElse(null);
        List<Project> projects= new ArrayList<>();//sna3na list
        projects.add(project);// ozedna projet
        user.setProjects(projects); //tajouti la list de projet fi wost l user
    }

}
