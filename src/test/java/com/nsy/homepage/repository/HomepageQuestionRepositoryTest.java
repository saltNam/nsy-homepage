package com.nsy.homepage.repository;

import com.nsy.homepage.controller.dto.request.GetHomepageQuestionDto;
import com.nsy.homepage.domain.HomepageQuestion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
@SpringBootTest
@Transactional
public class HomepageQuestionRepositoryTest {

    HomepageQuestionRepository homepageQuestionRepository;


}
