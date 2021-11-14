package it.plansoft.post.repository;

import it.plansoft.post.model.Tag;
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
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByName(String name);

    @Query("SELECT CASE WHEN COUNT(t) > 0 then TRUE ELSE FALSE END " +
            "FROM Tag t WHERE t.name = ?1")
    Boolean selectExistsTagByName(String name);
}
