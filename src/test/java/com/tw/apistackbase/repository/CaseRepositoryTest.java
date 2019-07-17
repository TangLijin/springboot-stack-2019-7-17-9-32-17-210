package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Test
    public void should_return_case_when_create_case(){
        //given
        Case aCase = new Case("case1",123456789L);
        caseRepository.save(aCase);
         //when
        List<Case> caseList = (List<Case>) caseRepository.findAll();

        //then
        Assertions.assertEquals(1, caseList.size());
        Assertions.assertEquals("case1",caseList.get(0).getCaseName());

    }
}