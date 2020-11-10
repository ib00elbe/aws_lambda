package net.aws2020course.fullstack.repository;


import net.aws2020course.fullstack.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TwitterRepository extends JpaRepository<Post, Long> {

}
