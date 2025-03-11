package com.traini8.backend_traini8.repository;

import com.traini8.backend_traini8.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {


//  |  --------for applying only one filter at a time-------- |
//  ----------------------------------------------------------
//    List<TrainingCenter> findByAddress_City(String city);
//
//    List<TrainingCenter> findByAddress_State(String state);
//
//    List<TrainingCenter> findByCoursesOfferedContaining(String course);


//  |  --------for applying multiple filters at a time-------- |
@Query("SELECT t FROM TrainingCenter t WHERE " +
        "(:city IS NULL OR t.address.city = :city) AND " +
        "(:state IS NULL OR t.address.state = :state) AND " +
        "(:course IS NULL OR :course MEMBER OF t.coursesOffered)")
List<TrainingCenter> findByFilters(@Param("city") String city,
                                   @Param("state") String state,
                                   @Param("course") String course);
}
