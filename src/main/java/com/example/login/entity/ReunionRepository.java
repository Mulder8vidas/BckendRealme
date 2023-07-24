package com.example.login.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReunionRepository  extends JpaRepository<ReunionEntity,Integer> {

    @Query("select r from reunion  r inner join reunion_usuarios  ru on ru.idReunion=r where ru.idUser.username=?1")
    List<ReunionEntity> misReuniones(String name);
}
