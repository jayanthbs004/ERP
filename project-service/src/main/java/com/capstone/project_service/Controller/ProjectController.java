package com.capstone.project_service.Controller;

import com.capstone.project_service.Model.Project;
import com.capstone.project_service.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable String id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable String id, @RequestBody Project project) {
            return projectService.updateProject(id, project)
                    .map(updatedProject -> ResponseEntity.ok(updatedProject))
                    .orElse(ResponseEntity.notFound().build());
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<Void> approveProject(@PathVariable String id) {
        // Update the project status to "Approved"
        Project approvedProject = projectService.approveProject(id);
        if (approvedProject == null) {
            return ResponseEntity.notFound().build();
        }

        // Call the finance-service to update the financial status
        Mono<Void> response = webClientBuilder.build()
                .post()
                .uri("http://finance-service/finance/project/" + id + "/approve")
                .retrieve()
                .bodyToMono(Void.class);

        response.block(); // Blocking for simplicity, consider using reactive approach

        return ResponseEntity.ok().build();
    }
}
