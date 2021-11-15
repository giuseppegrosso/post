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
 * Classe di gestione dei post
 *
 * @author Giuseppe Grosso
 * @project post
 * @since 13/11/2021
 */
@Entity(name = "Post")
@Table(name = "post")
@Data
@NoArgsConstructor
@ToString
public class Post extends BaseId<Long> {

    // definizione con sequence.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
    @SequenceGenerator(name = "post_sequence", sequenceName = "post_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, columnDefinition = "text", unique = false)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public Post(String title) {
        this.title = title;
    }
}
