package it.plansoft.post.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.plansoft.post.model.BaseId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project post
 * @since 13/11/2021
 */

@Data
@NoArgsConstructor
@ToString
public class TagDto extends BaseId<Long> {

    private Long id;
    private String name;
    @JsonIgnore
    private List<PostDto> posts;
}
