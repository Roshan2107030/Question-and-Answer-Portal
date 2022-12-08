package cog.caseStudy.roshan.QnAportal.springQnAportal.repository;

import cog.caseStudy.roshan.QnAportal.springQnAportal.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}
