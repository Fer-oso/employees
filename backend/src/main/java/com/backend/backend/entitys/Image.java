package com.backend.backend.entitys;

import java.io.Serializable;
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
public class Image implements Serializable{

    private static final long serialVersionUID = 1L;

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