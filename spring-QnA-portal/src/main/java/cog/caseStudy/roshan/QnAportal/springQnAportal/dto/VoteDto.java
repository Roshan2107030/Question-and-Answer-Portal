package cog.caseStudy.roshan.QnAportal.springQnAportal.dto;

import cog.caseStudy.roshan.QnAportal.springQnAportal.model.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto {
    private VoteType voteType;
    private Long postId;
}
