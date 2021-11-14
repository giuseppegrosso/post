package it.plansoft.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project post
 * @since 13/11/2021
 */
@Entity(name = "Tag")
@Table(name = "tag")
@Data
@NoArgsConstructor
@ToString
public class Tag extends BaseId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Post> posts;

    public Tag(String name) {
        this.name = name;
    }
}
