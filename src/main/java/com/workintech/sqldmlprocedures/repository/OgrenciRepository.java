package com.workintech.sqldmlprocedures.repository;

import com.workintech.sqldmlprocedures.entity.Ogrenci;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    @Query(value = "SELECT * FROM ogrencilistesi()", nativeQuery = true)
    List<Ogrenci> findAllOgrenci();

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "CALL sil(:ogrno)", nativeQuery = true)
    void removeOgrenci(@Param("ogrno") Long ogrno);

    List<Ogrenci> findBySinif(String sinif);
}
