package it.plansoft.post.mapper;

import it.plansoft.post.dto.TagDto;
import it.plansoft.post.model.Tag;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@Mapper(componentModel = "spring")
@Named("TagMapper")
public interface ITagMapper extends IMapper<TagDto, Tag> {

    ITagMapper INSTANCE = Mappers.getMapper(ITagMapper.class);

//    @Named("toDto")
//    @Mappings({
//            @Mapping(target = "posts", qualifiedByName = {"PostMapper", "toDtoWithoutTags"})})
//    TagDto toDto(Tag child);
//
//    @Named("toDtoWithoutPost")
//    @Mappings({
//            @Mapping(target = "posts", ignore = true)})
//    TagDto toDtoWithoutPost(Tag child);
}
