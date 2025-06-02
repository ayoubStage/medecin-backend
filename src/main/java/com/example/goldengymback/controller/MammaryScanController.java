package com.example.goldengymback.controller;

import com.example.goldengymback.model.MammaryScan;
import com.example.goldengymback.service.MammaryScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mammary-scan")
public class MammaryScanController {

    private final MammaryScanService mammaryScanService;

    @Autowired
    public MammaryScanController(MammaryScanService mammaryScanService) {
        this.mammaryScanService = mammaryScanService;
    }
    @PostMapping("/add")
    public ResponseEntity<MammaryScan> addMammaryScan(@RequestBody MammaryScan mammaryScan) {
        MammaryScan createdScan = mammaryScanService.add(mammaryScan);
        return new ResponseEntity<>(createdScan, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<MammaryScan>> getAllMammaryScans() {
        List<MammaryScan> scans = mammaryScanService.getAllMammaryScans();
        return new ResponseEntity<>(scans, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MammaryScan> getMammaryScanById(@PathVariable Long id) {
        Optional<MammaryScan> scan = mammaryScanService.getMammaryScanById(id);
        return scan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @GetMapping("/by-densite/{densite}")
    public ResponseEntity<List<MammaryScan>> getMammaryScansByDensiteMammaire(@PathVariable String densite) {
        List<MammaryScan> scans = mammaryScanService.getByDensiteMammaire(densite);
        return new ResponseEntity<>(scans, HttpStatus.OK);
    }
    @GetMapping("/by-asymetrie/{asymetrie}")
    public ResponseEntity<List<MammaryScan>> getMammaryScansByAsymetrie(@PathVariable Boolean asymetrie) {
        List<MammaryScan> scans = mammaryScanService.getByAsymetrie(asymetrie);
        return new ResponseEntity<>(scans, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMammaryScan(@PathVariable Long id) {
        mammaryScanService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
