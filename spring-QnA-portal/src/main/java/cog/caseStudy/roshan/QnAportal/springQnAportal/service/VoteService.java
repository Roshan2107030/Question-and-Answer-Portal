package cog.caseStudy.roshan.QnAportal.springQnAportal.service;

import cog.caseStudy.roshan.QnAportal.springQnAportal.dto.VoteDto;
import cog.caseStudy.roshan.QnAportal.springQnAportal.exceptions.PostNotFoundException;
import cog.caseStudy.roshan.QnAportal.springQnAportal.exceptions.SpringQnAException;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.Post;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.Vote;
import cog.caseStudy.roshan.QnAportal.springQnAportal.repository.PostRepository;
import cog.caseStudy.roshan.QnAportal.springQnAportal.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static cog.caseStudy.roshan.QnAportal.springQnAportal.model.VoteType.UPVOTE;

@Service
@AllArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final PostRepository postRepository;
    private final AuthService authService;

    @Transactional
    public void vote(VoteDto voteDto) {
        Post post = postRepository.findById(voteDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException("Post Not Found with ID - " + voteDto.getPostId()));
        Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, authService.getCurrentUser());
        if (voteByPostAndUser.isPresent() &&
                voteByPostAndUser.get().getVoteType()
                        .equals(voteDto.getVoteType())) {
            throw new SpringQnAException("You have already "
                    + voteDto.getVoteType() + "'d for this post");
        }
        if (UPVOTE.equals(voteDto.getVoteType())) {
            post.setVoteCount(post.getVoteCount() + 1);
        } else {
            post.setVoteCount(post.getVoteCount() - 1);
        }
        voteRepository.save(mapToVote(voteDto, post));
        postRepository.save(post);
    }

    private Vote mapToVote(VoteDto voteDto, Post post) {
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .post(post)
                .user(authService.getCurrentUser())
                .build();
    }
}
