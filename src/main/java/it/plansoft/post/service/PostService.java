package it.plansoft.post.service;

import it.plansoft.post.dto.PostDto;
import it.plansoft.post.mapper.CycleAvoidingMappingContext;
import it.plansoft.post.mapper.IPostMapper;
import it.plansoft.post.model.Post;
import it.plansoft.post.model.Tag;
import it.plansoft.post.repository.PostRepository;
import it.plansoft.post.repository.TagRepository;
import it.plansoft.post.service.interfaces.IPostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Classe di service per i post: attenzione le operazioni crud le eredito dalla classe
 * base di implementazione.
 * Il resto lo devo implementare in questo oggetto.
 *
 * @author Giuseppe Grosso
 * @project post
 * @since 13/11/2021
 */
@Service
public class PostService extends
        BaseCrudService<PostRepository, IPostMapper, PostDto, Post, Long>
        implements IPostService<PostDto> {

    private TagRepository tagRepository;

    public PostService(PostRepository repository, TagRepository tagRepository) {
        super(repository, IPostMapper.INSTANCE);
        this.tagRepository = tagRepository;
    }

    @Override
    public Set<PostDto> findByTitle(String title) {
        List<Post> byTitle = repository.findByTitle(title);

        return mapper.toSetDtos(byTitle);
    }

    @Override
    public boolean selectExistsPostByTitle(String title) {
        return repository.selectExistsPostByTitle(title);
    }


    public PostDto tagga(PostDto postDto) {
        // verifico se post e tag hanno id
        // 1. li cerco se trovati li associo
        // altrimenti li inserisco e li associo
        // inserisco il post e il tag
        Post post = mapper.dtoToModel(postDto);
        for (int i = 0; i < post.getTags().size(); i++) {
            if (post.getTags().get(i).getId() != null)
            {
                // check id tag
                Optional<Tag> byId = this.tagRepository.findById(post.getTags().get(i).getId());
                if (byId.isPresent())
                    post.getTags().set(i, byId.get());
            }
        }
        // return data.
        return mapper.toDto(repository.save(post), new CycleAvoidingMappingContext());
    }
}
