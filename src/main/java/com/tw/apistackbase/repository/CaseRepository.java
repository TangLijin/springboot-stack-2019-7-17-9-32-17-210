package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import org.springframework.data.repository.CrudRepository;

public interface CaseRepository extends CrudRepository<Case,Long> {


}
//public interface CaseRepository extends JpaRepository<Case,Long> {
//
//
//}