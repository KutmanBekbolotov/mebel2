package com.example.mebel2.Repositories;

import com.example.mebel2.Entities.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mebel2.Entities.Detail;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    List<Detail>findDetailByPaper(Paper paper);
}
