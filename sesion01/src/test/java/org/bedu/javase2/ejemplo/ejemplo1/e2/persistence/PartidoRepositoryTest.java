package org.bedu.javase2.ejemplo.ejemplo1.e2.persistence;

import org.bedu.javase2.ejemplo.ejemplo1.e2.models.Equipo;
import org.bedu.javase2.ejemplo.ejemplo1.e2.models.Partido;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.javase2.ejemplo.ejemplo1")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PartidoRepositoryTest {
    @Autowired
    private PartidoRepository repository;

    @Autowired
    private EquipoRepository equipoRepository;

    Equipo equipoAme;
    Equipo equipoMtr;

    @BeforeAll
    void setupDatabase() {
        repository.deleteAll();
        equipoRepository.deleteAll();
        equipoAme = new Equipo();
        equipoAme.setNombre("Equipo America Campeon");
        equipoRepository.save(equipoAme);
        equipoMtr = new Equipo();
        equipoMtr.setNombre("Equipo Monterrey");
        equipoRepository.save(equipoMtr);
    }
    @Test
    @DisplayName("Busca por nombres")
    void searchMatchByNames() {

        Partido partido = new Partido();
        partido.setEquipo1(equipoAme);
        partido.setEquipo2(equipoMtr);
        partido.setMarcadorEquipo1(0);
        partido.setMarcadorEquipo2(0);

        repository.save(partido);

        Iterable<Partido> conjuntoPartidos = repository.findAllByEquipo1NombreAndEquipo2Nombre("Equipo America Campeon", "Equipo Monterrey");

    }
}


