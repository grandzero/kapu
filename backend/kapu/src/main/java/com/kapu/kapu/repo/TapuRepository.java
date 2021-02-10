package com.kapu.kapu.repo;

import com.kapu.kapu.model.TapuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TapuRepository extends JpaRepository<TapuModel, Long> {


}
