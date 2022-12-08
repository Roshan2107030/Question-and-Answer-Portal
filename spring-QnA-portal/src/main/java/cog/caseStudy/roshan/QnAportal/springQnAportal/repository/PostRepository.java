package cog.caseStudy.roshan.QnAportal.springQnAportal.repository;

import cog.caseStudy.roshan.QnAportal.springQnAportal.model.Post;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.SubQnA;
import cog.caseStudy.roshan.QnAportal.springQnAportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubQnA(SubQnA subQnA);

    List<Post> findByUser(User user);
}
