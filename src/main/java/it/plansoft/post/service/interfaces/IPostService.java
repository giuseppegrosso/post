package it.plansoft.post.service.interfaces;

import java.util.Set;

/**
 * classe di interfaccia specifica per i post
 *
 * @param <PostDto>
 */
public interface IPostService<PostDto> {
    Set<PostDto> findByTitle(String title);

    boolean selectExistsPostByTitle(String title);
}
