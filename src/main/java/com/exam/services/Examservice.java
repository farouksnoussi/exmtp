package com.exam.services;

import com.exam.entities.Project;
import com.exam.entities.Sprint;
import com.exam.entities.User;
import com.exam.repositories.ProjectRepository;
import com.exam.repositories.SprintRepository;
import com.exam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional     // ychouf les metthodes lkol idhaken s7a7 lkol wa9tha ysavi fil bd
public class Examservice implements IExamenservice {
    private final ProjectRepository projectRepository;
    private final SprintRepository sprintRepository;
    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
    // ychouf les metthodes lkol idhaken s7a7 lkol wa9tha ysavi fil bd
    @Override
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
    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        User user = userRepository.findUserByFnameAndLname(firstName,lastName); //stockineh fil user o resultat fil find...
        Project project = projectRepository.findById(projectId).orElse(null);
        List<Project> projects= new ArrayList<>(); //listy de projet fergha khater user ie9bel list de projet mouch projet we7ed mba3ed zedna feha projet mte3na
        projects.add(project);
        user.setProjects(projects); // 7atina projet fi user
    }
    @Override
    public List<Project> getAllCurrentProject() {
        Date date = new Date();
        return projectRepository.findProjectsBySprintListStartDateGreaterThan(date);
    }
    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        return projectRepository.findProjectsByUserListFnameAndLname(fName, lName);
    }

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);// recuperineh ml bd
        sprintRepository.saveAndFlush(sprint); //tsajel fi wost bd
        sprint.setProject(project); //.set (affectation)
    }
}
