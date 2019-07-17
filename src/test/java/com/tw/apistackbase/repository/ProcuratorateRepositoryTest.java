package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Procuratorate;
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
public class ProcuratorateRepositoryTest {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    public void should_return_procuratorate_when_create_procuratorate(){
        Procuratorate procuratorate = new Procuratorate("oocl");
        procuratorateRepository.save(procuratorate);

//         when

        List<Procuratorate> procuratorates = (List<Procuratorate>) procuratorateRepository.findAll();

        //then
        Assertions.assertEquals(procuratorate.getId(),procuratorates.get(0).getId());
        Assertions.assertEquals(procuratorate.getName(),procuratorates.get(0).getName());

    }

}