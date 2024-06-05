package com.example.spazio.repository;

import com.example.spazio.entity.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LugarRepository extends JpaRepository<Lugar,Long> {

    List<Lugar> findAllByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT l FROM Lugar l JOIN l.categorias c WHERE c.id = :categoriaId")
    List<Lugar> findAllByCategorias(@Param("categoriaId") Long categoriaId);
}
