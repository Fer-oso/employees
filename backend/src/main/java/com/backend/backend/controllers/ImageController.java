package com.backend.backend.controllers;


import com.backend.backend.services.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {
 
   private final ImageService imageServiceImp;
 
   public ImageController(ImageService imageServiceImp){
       this.imageServiceImp=imageServiceImp;
   }
   
   @PostMapping
   public ResponseEntity<?> save(@RequestPart("image") MultipartFile image)throws Exception{
       try {
           return ResponseEntity.status(HttpStatus.CREATED).body(imageServiceImp.save(image));
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
   }
   
   @GetMapping
   public ResponseEntity<?> findAll()throws Exception{
       try {
           return ResponseEntity.status(HttpStatus.OK).body(imageServiceImp.findAll());
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
       }
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteById(@PathVariable int id) throws Exception{
       try {
           return ResponseEntity.status(HttpStatus.OK).body(imageServiceImp.deleteById(id));
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<?> findById(@PathVariable int id) throws Exception{
       try {
           return ResponseEntity.status(HttpStatus.OK).body(imageServiceImp.findById(id));
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
   }
   
   
   
}