package com.humber.finalProjGV.services;

import com.humber.finalProjGV.models.Haircut;
import com.humber.finalProjGV.repositories.HaircutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaircutService {

    private final HaircutRepository haircutRepository;

    public HaircutService(HaircutRepository haircutRepository) {
        this.haircutRepository = haircutRepository;
    }

    //get all haircuts
    public List<Haircut> getAllHaircuts() {
        return haircutRepository.findAll();
    }

    //add haircut
    public void addHaircut(Haircut haircut) {
        Haircut existingHaircut = haircutRepository.findHaircutByName(haircut.getName());

        if (existingHaircut != null) {
            throw new IllegalStateException("Haircut " + haircut.getName() + " already exists");
        }
        haircutRepository.save(haircut);
    }

    //find haircut by id
    public Haircut getHaircutById(int id) {
        return haircutRepository.findById(id).orElse(null);
    }

    //update haircut
    public void updateHaircut(int haircutId, Haircut haircut) {
        boolean exists = haircutRepository.existsById(haircutId);

        if (!exists) {
            throw new IllegalStateException("Haircut " + haircut.getName() + " does not exist");
        }

        haircut.setId(haircutId);
        haircutRepository.save(haircut);
    }

    //delete haircut
    public void deleteHaircut(int haircutId) {
        boolean exists = haircutRepository.existsById(haircutId);

        if (!exists) {
            throw new IllegalStateException("Haircut " + haircutId + " does not exist");
        }

        haircutRepository.deleteById(haircutId);
    }


}
