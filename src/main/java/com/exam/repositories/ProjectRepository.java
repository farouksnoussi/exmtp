package com.exam.repositories;

import com.exam.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    //recuperi date mtaa sprint
    List<Project> findProjectsBySprintListStartDateGreaterThan(Date datenow); //findProjectsBySprintList bch tlawejli 3al projet selon sprint list / StartDateGreaterThan(Date datenow)// tlawej 3al sprint list selon (date ykoun akber mn date lioum
    List<Project> findProjectsByUserListFnameAndLname(String fname, String lname);
}

