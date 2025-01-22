package com.capstone.project_service.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    private String status;
    private String techStack;
    private String timeline;
    public Project() {
    }
    public Project(String id, String name, String description, String status, String techStack, String timeline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.techStack = techStack;
        this.timeline = timeline;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTechStack() {
        return techStack;
    }
    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }
    public String getTimeline() {
        return timeline;
    }
    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    // Getters and Setters
    // ...
    
}
