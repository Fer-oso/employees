package com.backend.backend.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="images")
public class Image{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  int id;
   
   private String name;
   
   private String type;
      
   public Image(String name, String type) {
        this.name = name;
        this.type = type;
    }
   
    
}