package com.exam.services;

import com.exam.entities.Project;
import com.exam.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProject{
    @Autowired
    private final ProjectRepository projectRepository;
}
