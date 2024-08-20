package com.example.bugtracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status; // E.g., "Open", "In Progress", "Closed"
    private String priority; // E.g., "Low", "Medium", "High"
    private String severity; // E.g., "Minor", "Major", "Critical"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser; // The user to whom the bug is assigned

    // Constructors
    public Bug() {}

    public Bug(String title, String description, String status, String priority, String severity, User assignedUser) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.severity = severity;
        this.assignedUser = assignedUser;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }
}
