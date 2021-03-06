package it.plansoft.post.mapper;

import org.mapstruct.Context;

import java.util.List;
import java.util.Set;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
public interface IMapper<DTO, MODEL> {

    DTO toDto(MODEL model, @Context CycleAvoidingMappingContext context);
    MODEL dtoToModel(DTO dto);
    List<DTO> toDtos(List<MODEL> models, @Context CycleAvoidingMappingContext context);
    List<MODEL> toModels(List<DTO> dtos);
    // set
    Set<DTO> toSetDtos(Set<MODEL> model);
    // set
    Set<DTO> toSetDtos(List<MODEL> model);
    // ... aggiungere eventuali altre collection
}