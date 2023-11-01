package com.example.monopatinmanager.repository;

import com.example.monopatinmanager.dto.StatusDTO;
import com.example.monopatinmanager.entity.Monopatin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MonopatinRepository extends JpaRepository<Monopatin, Long> {

    @Query("""
        SELECT m 
        FROM Monopatin m
        WHERE m.status = :status
    """)
    List<Monopatin> getMonopatines(String status);

    @Query("""
        SELECT new com.example.monopatinmanager.dto.StatusDTO(m.status, COUNT(m.status))
        FROM Monopatin m
        GROUP BY m.status
    """)
    List<StatusDTO> getStatusMonopatines();
}
