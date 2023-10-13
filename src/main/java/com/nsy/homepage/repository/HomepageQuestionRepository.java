package com.nsy.homepage.repository;

import com.nsy.homepage.domain.HomepageQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomepageQuestionRepository extends JpaRepository<HomepageQuestion, Long> {
}
