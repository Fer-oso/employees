package com.backend.backend.repository;

import com.backend.backend.entitys.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{

    public Image findByName(String name);

}