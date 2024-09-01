package com.test.reservation_system_backend.repository;
import com.test.reservation_system_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
