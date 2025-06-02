package com.example.goldengymback.serviceImpl;

import com.example.goldengymback.model.MammaryScan;
import com.example.goldengymback.repository.MammaryScanRepo;
import com.example.goldengymback.service.MammaryScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MammaryScanServiceImpl implements MammaryScanService {

    private final MammaryScanRepo mammaryScanRepository;

    @Autowired
    public MammaryScanServiceImpl(MammaryScanRepo mammaryScanRepository) {
        this.mammaryScanRepository = mammaryScanRepository;
    }
    @Override
    public MammaryScan add(MammaryScan mammaryScan) {
        return mammaryScanRepository.save(mammaryScan);
    }

    // Delete a MammaryScan by ID
    @Override
    public void delete(Long id) {
        mammaryScanRepository.deleteById(id);
    }

    // Get all MammaryScans
    @Override
    public List<MammaryScan> getAllMammaryScans() {
        return mammaryScanRepository.findAll();
    }

    // Get a MammaryScan by ID
    @Override
    public Optional<MammaryScan> getMammaryScanById(Long id) {
        return mammaryScanRepository.findById(id);
    }

    // Get MammaryScans by densiteMammaire
    @Override
    public List<MammaryScan> getByDensiteMammaire(String densiteMammaire) {
        return mammaryScanRepository.findByDensiteMammaire(densiteMammaire);
    }

    // Get MammaryScans by asymetrie
    @Override
    public List<MammaryScan> getByAsymetrie(Boolean asymetrie) {
        return mammaryScanRepository.findByAsymetrie(asymetrie);
    }
}
