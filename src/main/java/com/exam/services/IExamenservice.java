package com.exam.services;

import com.exam.entities.Project;
import com.exam.entities.User;

public interface IExamenservice {
    User addUser (User user);
    Project addProject(Project project);
    void assignProjectToUser (int projectId, int userId);
}
