package com.example.goldengymback.service;

import com.example.goldengymback.model.MammaryScan;

import java.util.List;
import java.util.Optional;

public interface MammaryScanService {

    // Create or add a new MammaryScan
    MammaryScan add(MammaryScan mammaryScan);

    // Delete a MammaryScan by its ID
    void delete(Long id);

    // Get all MammaryScans
    List<MammaryScan> getAllMammaryScans();

    // Get MammaryScan by ID
    Optional<MammaryScan> getMammaryScanById(Long id);

    // Custom query example: Get MammaryScan entries by densiteMammaire
    List<MammaryScan> getByDensiteMammaire(String densiteMammaire);

    // Custom query example: Get MammaryScan entries by asymetrie
    List<MammaryScan> getByAsymetrie(Boolean asymetrie);

}
