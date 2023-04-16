package com.example.mebel2.Repositories;

import com.example.mebel2.Entities.Paper;
import com.example.mebel2.Projections.PaperProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperRepository extends JpaRepository<Paper,Long> {
    @Query(nativeQuery = true, value = "SELECT name, width, height FROM tb_paper")
    List<PaperProjection>findAllProjections();
}
