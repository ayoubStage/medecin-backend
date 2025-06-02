package com.example.goldengymback.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class MammaryScan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MAMMOGRAPHIE
    private String densiteMammaire;

    private boolean asymetrie;
    private String typeAsymetrie;

    private boolean distorsionArchitecturale;
    private String optionDistorsionArchitecturale;

    private boolean calcifications;
    private String typesCalcifications;
    private String calcificationsBenignes;
    private String calcificationsSuspectes;
    private String distributionMicrocalcifications;

    private String signesAssociesMammographie;

    // ÉCHOGRAPHIE MAMMAIRE
    private String echostructureMammaire;
    private String signesAssociesEchostructure;

    private String casSpeciaux;
    private String conclusionRadiologue;
    private String conclusionIA;
    private String conduiteATenir;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "mammaryScan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<MasseMammographie> massesMammographie = new ArrayList<>();

    @OneToMany(mappedBy = "mammaryScan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<MasseEchostructure> massesEchostructure = new ArrayList<>();
}
