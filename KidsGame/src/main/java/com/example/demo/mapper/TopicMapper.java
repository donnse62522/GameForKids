package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.example.demo.controller.vm.TopicVM;
import com.example.demo.model.Topic;

@Mapper
public interface TopicMapper {

	TopicMapper INSTANCE = Mappers.getMapper( TopicMapper.class );
	
	@Mappings({ @Mapping(target = "idTopic", source = "id"),
			@Mapping(target = "description", source = "name"), 
			@Mapping(target = "urlImage", source = "description") })
	TopicVM toTopicVM(Topic vm);

}
