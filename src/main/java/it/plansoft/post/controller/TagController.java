package it.plansoft.post.controller;

import it.plansoft.post.controller.interfaces.ITagController;
import it.plansoft.post.dto.TagDto;
import it.plansoft.post.mapper.ITagMapper;
import it.plansoft.post.model.Tag;
import it.plansoft.post.repository.TagRepository;
import it.plansoft.post.service.TagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giuseppe Grosso
 * @project Tag
 * @since 13/11/2021
 */
@RestController
@RequestMapping("/tag")
public class TagController extends BaseCrudController<TagService, TagRepository, ITagMapper, TagDto, Tag, Long>
        implements ITagController<Tag> {

    // nota eredito tutte le crud della classe base di implementazione.

    public TagController(TagService service) {
        super(service);
    }

}
