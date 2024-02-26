package com.application.rest.persistence.impl;

import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.repository.MakerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    private MakerRespository makerRespository;

    @Override
    public List<Maker> findAll() {
        return makerRespository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRespository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerRespository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRespository.deleteById(id);
    }
}
