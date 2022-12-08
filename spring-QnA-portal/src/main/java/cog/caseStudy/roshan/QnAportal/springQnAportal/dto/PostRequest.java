package cog.caseStudy.roshan.QnAportal.springQnAportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private Long postId;
    private String subQnAName;
    private String postName;
    private String url;
    private String description;
}
