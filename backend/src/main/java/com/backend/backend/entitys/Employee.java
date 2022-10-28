package com.backend.backend.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/** Entity in charge of creating Employees*/
@Entity
@Data
@Table(name = "employees")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "charge")
    private String charge;
   
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="employee_image",joinColumns = @JoinColumn(name="id_employee",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="id_image",referencedColumnName = "id"))
    private List<Image> image;
   
    
}
