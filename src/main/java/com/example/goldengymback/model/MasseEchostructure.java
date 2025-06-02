package com.example.goldengymback.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class MasseEchostructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localisation;
    private String mesure;
    private String forme;
    @ManyToOne
    @JoinColumn(name = "mammary_scan_id")
    @JsonBackReference
    private MammaryScan mammaryScan;

}
