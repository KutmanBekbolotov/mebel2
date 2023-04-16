package com.example.mebel2.Repositories;

import com.example.mebel2.Entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
//        ResultProjection saveByProjection(Result result);


}
