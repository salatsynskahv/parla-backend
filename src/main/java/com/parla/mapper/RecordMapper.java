package com.parla.mapper;

import com.parla.pojo.Record;
import com.parla.pojo.front.RecordView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecordMapper {

    RecordMapper INSTANCE = Mappers.getMapper(RecordMapper.class);


    @Mappings(
            @Mapping(target = "id", ignore = true)
    )
    Record mapToDto(RecordView recordView);

}
