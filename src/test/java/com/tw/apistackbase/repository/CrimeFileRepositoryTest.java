package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CrimeFile;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CrimeFileRepositoryTest {

    @Autowired
    private CrimeFileRepository crimeFileRepository;

    @BeforeEach
    public void init(){
        crimeFileRepository.deleteAll();
    }

    @Test
    public void should_return_crime_file_when_create_crime_file(){
//        given
        CrimeFile crimeFile = new CrimeFile("badbadbad","good");
        crimeFileRepository.save(crimeFile);

//         when
        List<CrimeFile> crimeFiles = (List<CrimeFile>) crimeFileRepository.findAll();

        //then
        Assertions.assertEquals(crimeFile.getId(),crimeFiles.get(0).getId());
        Assertions.assertEquals(crimeFile.getObjectiveDescription(),crimeFiles.get(0).getObjectiveDescription());
        Assertions.assertEquals(crimeFile.getSubjectiveDescription(),crimeFiles.get(0).getSubjectiveDescription());

    }
}