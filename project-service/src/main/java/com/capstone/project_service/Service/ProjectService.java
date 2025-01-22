package com.capstone.project_service.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.capstone.project_service.Model.Project;
import com.capstone.project_service.Repository.ProjectRepository;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(String id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(String id, Project project) {
        project.setId(id);
        return projectRepository.save(project);
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }

    public Project approveProject(String id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            project.setStatus("Approved");
            projectRepository.save(project);

            // Call the finance-service to update the financial status
            webClientBuilder.build()
                .post()
                .uri("http://finance-service/finance/project/" + id + "/approve")
                .retrieve()
                .bodyToMono(Void.class)
                .block(); // Blocking for simplicity, consider using reactive approach

            return project;
        }
        return null;
    }
}
