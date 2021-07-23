package meli.bootcamp.dentinhos.repository;

import meli.bootcamp.dentinhos.domain.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Integer> {

    List<Turn> findByTurnStatus_NameAndDays(String name, LocalDate date);

    List<Turn> findByTurnStatusId(Integer id);

    List<Turn> findByTurnStatusIdAndDays(Integer id, LocalDate days);
}
