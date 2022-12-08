package cog.caseStudy.roshan.QnAportal.springQnAportal.repository;

import cog.caseStudy.roshan.QnAportal.springQnAportal.model.SubQnA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubQnARepository extends JpaRepository<SubQnA, Long> {

    Optional<SubQnA> findByName(String subQnAName);
}
