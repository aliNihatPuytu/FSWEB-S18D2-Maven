package com.workintech.sqldmlprocedures.repository;


import com.workintech.sqldmlprocedures.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface KitapRepository extends JpaRepository<Kitap, Long> {

    Kitap findByAd(String ad);

    @Transactional
    @Modifying
    @Query(value = "CALL public.ekle(:ad, :sayfa, :yazarno, :turno)", nativeQuery = true)
    void addNewKitap(String ad, int sayfa, long yazarno, long turno);

}

