package cog.caseStudy.roshan.QnAportal.springQnAportal.mapper;

import cog.caseStudy.roshan.QnAportal.springQnAportal.dto.SubQnADto;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.Post;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.SubQnA;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubQnAMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subQnA.getPosts()))")
    SubQnADto mapSubQnAToDto(SubQnA subQnA);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    SubQnA mapDtoToSubQnA(SubQnADto subQnADto);
}
