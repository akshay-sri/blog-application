package com.blog.project.repositories;

import com.blog.project.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, String> {

}
