package it.plansoft.post.service.interfaces;

import java.util.Set;

/**
 * classe di interfaccia specifica per i tag
 *
 * @param <TagDto>
 */
public interface ITagService<TagDto> {
    Set<TagDto> findByName(String name);

    boolean selectExistsTagByName(String name);
}
