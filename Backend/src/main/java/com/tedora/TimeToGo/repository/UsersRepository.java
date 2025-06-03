package com.tedora.TimeToGo.repository;

import com.tedora.TimeToGo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
