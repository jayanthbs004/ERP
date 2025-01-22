package com.capstone.project_service.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capstone.project_service.Model.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
