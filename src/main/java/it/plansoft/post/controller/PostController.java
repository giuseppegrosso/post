package it.plansoft.post.controller;

import it.plansoft.post.controller.interfaces.IPostController;
import it.plansoft.post.dto.PostDto;
import it.plansoft.post.mapper.IPostMapper;
import it.plansoft.post.model.Post;
import it.plansoft.post.repository.PostRepository;
import it.plansoft.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * @author Giuseppe Grosso
 * @project post
 * @since 13/11/2021
 */
@RestController
@RequestMapping("/post")
@Transactional
public class PostController
        extends BaseCrudController<PostService, PostRepository, IPostMapper, PostDto, Post, Long>
        implements IPostController<Post> {

    // nota eredito tutte le crud della classe base di implementazione.

    public PostController(PostService service) {
        super(service);
    }

    @PostMapping("/tagga")
    public ResponseEntity<PostDto> save(@RequestBody PostDto model) {
        return ResponseEntity.ok(service.tagga(model));
    }
}
