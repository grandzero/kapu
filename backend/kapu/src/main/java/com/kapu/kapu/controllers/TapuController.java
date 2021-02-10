package com.kapu.kapu.controllers;

import com.kapu.kapu.model.TapuModel;
import com.kapu.kapu.services.TapuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TapuController {
    private final TapuService tapuService;

    public TapuController(TapuService tapuService) {
        this.tapuService = tapuService;
    }

    // Add New Tapu

    @PostMapping("/add")
    public ResponseEntity<TapuModel> add(@RequestBody TapuModel tapu){
        TapuModel createdTapu = tapuService.addTapu(tapu);
        return new ResponseEntity<>(createdTapu, HttpStatus.OK);
    }
    // Archive Tapu
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TapuModel> delete(@PathVariable("id") Long id){
        String s = tapuService.archiveTapu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // FindByState
    @GetMapping("/find/state/{state}")
    public ResponseEntity<List<TapuModel>> findByState(@PathVariable("state") String state){
        List<TapuModel> tapus = tapuService.findTapuListByState(state);
        return new ResponseEntity<>(tapus, HttpStatus.OK);
    }
    // FindByDesc
    @GetMapping("/find/desc/{desc}")
    public ResponseEntity<List<TapuModel>> findByDesc(@PathVariable("desc") String desc){
        List<TapuModel> tapus = tapuService.findTapuListByDesc(desc);
        return new ResponseEntity<>(tapus, HttpStatus.OK);
    }
    // FindByTitle
    @GetMapping("/find/title/{title}")
    public ResponseEntity<List<TapuModel>> findByTitle(@PathVariable("title") String title){
        List<TapuModel> tapus = tapuService.findTapuListByTitle(title);
        return new ResponseEntity<>(tapus, HttpStatus.OK);
    }

    // FindById
    @GetMapping("/find/{id}")
    public ResponseEntity<TapuModel> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(tapuService.findById(id), HttpStatus.OK);
    }
    // GetAll
    @GetMapping("/all")
    public ResponseEntity<List<TapuModel>> findAll(){
        return new ResponseEntity<>(tapuService.getAll(), HttpStatus.OK);
    }
}
