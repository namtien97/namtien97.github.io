package vn.techmaster.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.blog.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
