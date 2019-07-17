package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

   @BeforeEach
    public void init(){
        caseRepository.deleteAll();
//        Case case1 = new Case("case1",123456789L);
//        Case case2 = new Case("case2",223456789L);
//        Case case3 = new Case("case3",323456789L);
//        Case case4 = new Case("case4",423456789L);
//        Case case5 = new Case("case5",523456789L);
//        caseRepository.save(case1);
//        caseRepository.save(case2);
//        caseRepository.save(case3);
//        caseRepository.save(case4);
//        caseRepository.save(case5);
    }


    @Test
    public void should_return_case_when_create_case(){
//        given
        Case aCase = new Case("case1",123456789L);
        caseRepository.save(aCase);
//         when
        List<Case> caseList = (List<Case>) caseRepository.findAll();

        //then
        Assertions.assertEquals(1, caseList.size());
        Assertions.assertEquals("case1",caseList.get(0).getCaseName());

    }

    @Test
    public void should_return_case_given_id(){

        //given
        Case case2 = new Case("case2",223456789L);
        caseRepository.save(case2);


//        when
        Case expect = caseRepository.findById(case2.getId()).get();

//        then
        Assertions.assertEquals(expect.getId(),case2.getId());
        Assertions.assertEquals(expect.getCaseName(),case2.getCaseName());
        Assertions.assertEquals(expect.getHappenTime(),case2.getHappenTime());
    }

    @Test
    public void should_return_all_cases_order_by_happen_time(){
        //given
        Case case1 = new Case("case1",123456789L);
        Case case2 = new Case("case2",223456789L);
        Case case3 = new Case("case3",323456789L);
        caseRepository.save(case1);
        caseRepository.save(case2);
        caseRepository.save(case3);
        
        //when
        List<Case> orderList = (List<Case>)caseRepository.findAll();
        orderList.sort(Comparator.comparing(Case::getHappenTime).reversed());

        //then
        Assertions.assertSame(case1,orderList.get(2));
        Assertions.assertSame(case2,orderList.get(1));
        Assertions.assertSame(case3,orderList.get(0));

    }
}