package com.exception.controller;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.handling.EnterValue;
import com.exception.handling.ValueNotFoundException;
import com.exception.model.Data;

@RestController
public class DataController {
	   private static Map<String, Data> datarep = new HashMap<>();
	   static {
		   Data a = new Data();
	      a.setId("1");
	      a.setName("asish");
	      datarep.put(a.getId(), a);
	      
	      Data b = new Data();
	      b.setId("2");
	      b.setName("balaram");
	      datarep.put(b.getId(), b);
	   }
	   
	   @PutMapping("show/{id}")
	   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Data data) { 
	      if(!datarep.containsKey(id))throw new ValueNotFoundException();
	      datarep.remove(id);
	      datarep.put(id, data);
	      return new ResponseEntity<>("data is updated", HttpStatus.OK);
	   }
	   
	   @PostMapping("/upload")
	   public ResponseEntity<Object> addUser(@Valid @RequestBody Data data, BindingResult result) {
		   if (result.hasErrors()) throw new EnterValue();
		   	datarep.put(data.getId(), data);
	        return ResponseEntity.ok("Uploaded");
	    }
	   
	   @GetMapping("getdetails")
	   public Map<String, Data> getdetails(){
		   return datarep;
	   }
}
