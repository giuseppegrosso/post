package it.plansoft.post.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.plansoft.post.model.BaseId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe di gestione dei post
 *
 * @author Giuseppe Grosso
 * @project post
 * @since 13/11/2021
 */
@Data
@NoArgsConstructor
@ToString
public class PostDto extends BaseId<Long> {
    // SWAgger documentation @NotNull, @NotBlank, @Size, @Min, and @Max
    // SWAgger documentation
    private String title;

    //@NotNull, @NotBlank, @Size, @Min, and @Max,
    @NotNull
    @NotBlank
    private Long id;

    private List<TagDto> tags;
}
