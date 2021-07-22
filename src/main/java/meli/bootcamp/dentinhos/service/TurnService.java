package meli.bootcamp.dentinhos.service;

import meli.bootcamp.dentinhos.domain.Turn;
import meli.bootcamp.dentinhos.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnService {
    @Autowired
    private TurnRepository turnRepository;

    private final Integer COMPLETED_TURN_ID = 1;

    public List<Turn> findCompletedTurns() {
        return turnRepository.findByTurnStatusId(COMPLETED_TURN_ID);
    }
}
