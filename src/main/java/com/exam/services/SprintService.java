package com.exam.services;

import com.exam.repositories.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class SprintService implements ISprint{
    @Autowired
    private final SprintRepository sprintRepository;
}
