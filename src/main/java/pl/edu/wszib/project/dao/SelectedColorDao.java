package pl.edu.wszib.project.dao; //interfejs repozytorium do zapisu io usuwania do bazy

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.project.domain.SelectedColor;

import java.util.List;


@Repository
public interface SelectedColorDao extends CrudRepository<SelectedColor, Integer> {//<argumenty z klasy Selected kolor>
    List<SelectedColor> findByColor(String color);// to wyszuka w bazie danych wiersze których jest dany kolor
}
