package meli.bootcamp.dentinhos.repository;

import meli.bootcamp.dentinhos.domain.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Integer> {
    List<Turn> findByTurnStatusId(Integer id);
}