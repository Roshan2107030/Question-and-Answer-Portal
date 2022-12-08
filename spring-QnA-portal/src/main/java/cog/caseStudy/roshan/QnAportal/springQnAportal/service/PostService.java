package cog.caseStudy.roshan.QnAportal.springQnAportal.service;

import cog.caseStudy.roshan.QnAportal.springQnAportal.dto.PostRequest;
import cog.caseStudy.roshan.QnAportal.springQnAportal.dto.PostResponse;
import cog.caseStudy.roshan.QnAportal.springQnAportal.exceptions.PostNotFoundException;
import cog.caseStudy.roshan.QnAportal.springQnAportal.exceptions.SubQnANotFoundException;
import cog.caseStudy.roshan.QnAportal.springQnAportal.mapper.PostMapper;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.Post;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.SubQnA;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.User;
import cog.caseStudy.roshan.QnAportal.springQnAportal.repository.PostRepository;
import cog.caseStudy.roshan.QnAportal.springQnAportal.repository.SubQnARepository;
import cog.caseStudy.roshan.QnAportal.springQnAportal.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final SubQnARepository subQnARepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    public void save(PostRequest postRequest) {
        SubQnA subQnA = subQnARepository.findByName(postRequest.getSubQnAName())
                .orElseThrow(() -> new SubQnANotFoundException (postRequest.getSubQnAName()));
        postRepository.save(postMapper.map(postRequest, subQnA, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsBySubQnA(Long subQnAId) {
        SubQnA subQnA = subQnARepository.findById(subQnAId)
                .orElseThrow(() -> new SubQnANotFoundException (subQnAId.toString()));
        List<Post> posts = postRepository.findAllBySubQnA(subQnA);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
