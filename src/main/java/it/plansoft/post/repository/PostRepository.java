package it.plansoft.post.repository;

import it.plansoft.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project post
 * @since 13/11/2021
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitle(String title);

    @Query("SELECT CASE WHEN COUNT(p) > 0 then TRUE ELSE FALSE END " +
            "FROM Post p WHERE p.title = ?1")
    Boolean selectExistsPostByTitle(String title);
}
