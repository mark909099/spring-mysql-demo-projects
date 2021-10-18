package com.spring.mysql.VisitorProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

    @Query(value="SELECT * FROM visitors1 WHERE city=\"haifa\"",
    nativeQuery = true)
    List<Visitor> findAllInHaifa();

    @Query(value="SELECT * FROM visitors1 WHERE city=\"jerusalem\"",
            nativeQuery = true)
    List<Visitor> findAllInJerusalem();
    @Query(value="SELECT * FROM visitors1 WHERE city=\"tel aviv\"",
            nativeQuery = true)
    List<Visitor> findAllInTelAviv();
}
