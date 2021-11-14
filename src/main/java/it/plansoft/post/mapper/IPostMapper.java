package it.plansoft.post.mapper;

import it.plansoft.post.dto.PostDto;
import it.plansoft.post.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@Mapper(componentModel = "spring")
@Named("PostMapper")
public interface IPostMapper extends IMapper<PostDto, Post> {

    IPostMapper INSTANCE = Mappers.getMapper(IPostMapper.class);

//    @Named("toDto")
//    @Mappings({
//            @Mapping(target = "tags")})
//    PostDto toDto(Post post);
//
//    @Named("toDtoWithoutTags")
//    @Mappings({
//            @Mapping(target = "tags", ignore = true)})
//    PostDto toDtoWithoutTag(Post father);
}
