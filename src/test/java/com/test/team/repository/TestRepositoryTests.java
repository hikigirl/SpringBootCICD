package com.test.team.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

// JUnit5(Jupiter), 접근지정자 생략 권장
@SpringBootTest //단위 테스트 시 사용하는 어노테이션(필수)
public class TestRepositoryTests {
    @Autowired
    private TestRepository repo;

    @Test @DisplayName("숫자 테스트")
    void testNum() {
        assertEquals(100, repo.num());
    }
}
