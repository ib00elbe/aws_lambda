package net.aws2020course.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.aws2020course.fullstack.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
