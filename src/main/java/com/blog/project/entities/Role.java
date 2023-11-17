package com.blog.project.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String roleName;
}
