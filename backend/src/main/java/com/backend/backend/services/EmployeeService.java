package com.backend.backend.services;

import com.backend.backend.entitys.Employee;
import com.backend.backend.repository.EmployeeRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ImageService imageService;

    public EmployeeService(EmployeeRepository employeeRepository,ImageService imageService) {
        this.employeeRepository = employeeRepository;
        this.imageService=imageService;
    }

    public Employee save(Employee employee,MultipartFile image) throws Exception {
        try {
            if (image.isEmpty()) {//if doesnt image recieve by parameter
               employee.setImage(List.of(imageService.setDefaultImageProfile()));//set by default "default image"
            }else{
               employee.setImage(List.of(imageService.save(image))); // set the image recieved
            }
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<Employee> findAll() throws Exception {
        if (!employeeRepository.findAll().isEmpty()) {
            return employeeRepository.findAll();
        } else {
            throw new Exception("no content");
        }
    }

    public Employee update(int id, Employee employee, MultipartFile image) throws Exception {
        if(employeeRepository.findById(id).get().getId() == (employee.getId())) {//if the recieved id doesn missmatch with the saved employee
            if(image.isEmpty()){ //ask if the image is empty
              if(employeeRepository.findById(id).get().getImage().isEmpty()) {//if the employee saved doesnt have one image 
                employee.setImage(List.of(imageService.setDefaultImageProfile()));//call the function for set one default image
            }else{
                employee.setImage(employeeRepository.findById(id).get().getImage());//set the same image 
              }
               return employeeRepository.saveAndFlush(employee);
            }
            employee.setImage(List.of(imageService.save(image)));
            return employeeRepository.saveAndFlush(employee);
        } else {
            throw new Exception("id's no missmatch");
        }
    }

    public boolean deleteById(int id) throws Exception {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Employee findById(int id) throws Exception {
        return employeeRepository.findById(id).orElseThrow();
    }

}
