package cog.caseStudy.roshan.QnAportal.springQnAportal.repository;

import cog.caseStudy.roshan.QnAportal.springQnAportal.model.Comment;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.Post;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
