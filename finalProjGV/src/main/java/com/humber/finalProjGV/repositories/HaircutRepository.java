package com.humber.finalProjGV.repositories;

import com.humber.finalProjGV.models.Haircut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HaircutRepository extends JpaRepository<Haircut, Integer> {

    @Query("SELECT d FROM Haircut d WHERE d.name = :name")
    Haircut findHaircutByName(@Param("name") String name);

}
