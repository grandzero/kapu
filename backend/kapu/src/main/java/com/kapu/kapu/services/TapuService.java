package com.kapu.kapu.services;

import com.kapu.kapu.exceptions.TapuNotFoundException.TapuNotFoundException;
import com.kapu.kapu.model.TapuModel;
import com.kapu.kapu.repo.TapuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TapuService {

    @Autowired
    private final TapuRepository tapuRepository;

    public TapuService(TapuRepository tapuRepository) {
        this.tapuRepository = tapuRepository;
    }

    public List<TapuModel> getAll(){
        List<TapuModel> list = tapuRepository.findAll();
        List<TapuModel> newLs = new ArrayList<>();
        for(TapuModel item : list){
            if(!(item.isArchived())){
                newLs.add(item);
            }
        }
        return newLs;
    }
    public TapuModel findById(Long id){
        return tapuRepository.findById(id)
                .orElseThrow(() -> new TapuNotFoundException("Tapu by id " + id + " was not found"));
    }
    public TapuModel addTapu(TapuModel tapu){
        tapu.setArchived(false);
        return tapuRepository.save(tapu);
    }
    public String archiveTapu(Long id){
        TapuModel tp = tapuRepository.findById(id).orElseThrow(() -> new TapuNotFoundException("Could not found tapu"));
        tp.setArchived(true);
        tapuRepository.save(tp);
        return "Deleted";
    }
    public List<TapuModel> findTapuListByState(String s){
        List<TapuModel> list = tapuRepository.findAll();
        List<TapuModel> newLs = new ArrayList<>();
        for(TapuModel item : list){
            if(item.getDescription().toLowerCase().contains(s.toLowerCase()) && !item.isArchived()){
                newLs.add(item);
            }
        }
        return newLs;
    }

    public List<TapuModel> findTapuListByDesc(String s){
        List<TapuModel> list = tapuRepository.findAll();
        List<TapuModel> newLs = new ArrayList<>();
        for(TapuModel item : list){
            if(item.getDescription().toLowerCase().contains(s.toLowerCase()) && !item.isArchived()){
                newLs.add(item);
            }
        }
        return newLs;
    }

    public List<TapuModel> findTapuListByTitle(String s){
        List<TapuModel> list = tapuRepository.findAll();
        List<TapuModel> newLs = new ArrayList<>();
        for(TapuModel item : list){
            if(item.getTitle().toLowerCase().contains(s.toLowerCase()) && !item.isArchived()){
                newLs.add(item);
            }
        }
        return newLs;
    }

}
