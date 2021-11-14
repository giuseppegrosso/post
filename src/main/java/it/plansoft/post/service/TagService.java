package it.plansoft.post.service;

import it.plansoft.post.dto.TagDto;
import it.plansoft.post.mapper.ITagMapper;
import it.plansoft.post.model.Tag;
import it.plansoft.post.repository.TagRepository;
import it.plansoft.post.service.interfaces.ITagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Classe di service per i Tag: attenzione le operazioni crud le eredito dalla classe
 * base di implementazione.
 * Il resto lo devo implementare in questo oggetto.
 *
 * @author Giuseppe Grosso
 * @project Tag
 * @since 13/11/2021
 */
@Service
public class TagService
        extends BaseCrudService<TagRepository, ITagMapper, TagDto, Tag, Long>
        implements ITagService<TagDto> {

    public TagService(TagRepository repository) {
        super(repository, ITagMapper.INSTANCE);
    }


    @Override
    public Set<TagDto> findByName(String name) {
        List<Tag> byName = repository.findByName(name);

        return mapper.toSetDtos(byName);
    }

    @Override
    public boolean selectExistsTagByName(String name) {
        return repository.selectExistsTagByName(name);
    }
}
