package ru.itis.webappcdio.dao;

import ru.itis.webappcdio.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}