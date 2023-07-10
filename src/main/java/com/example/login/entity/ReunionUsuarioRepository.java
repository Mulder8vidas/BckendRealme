package com.example.login.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReunionUsuarioRepository extends JpaRepository<ReunionUsuarioEntity,Integer> {


    @Query("select d from reunion  f inner join reunion_usuarios  d on d.idReunion=f where f.id=?1")
    List<ReunionUsuarioEntity> findByIdReunion(int data);



}
