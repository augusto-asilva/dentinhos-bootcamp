package meli.bootcamp.dentinhos.service;

import meli.bootcamp.dentinhos.domain.Diary;
import meli.bootcamp.dentinhos.domain.Turn;
import meli.bootcamp.dentinhos.domain.TurnStatus;
import meli.bootcamp.dentinhos.domain.User;
import meli.bootcamp.dentinhos.repository.TurnRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TurnServiceTest {

    private TurnService turnService;

    @Mock
    private TurnRepository turnRepository;

    @BeforeEach
    void initializeMocks() {
        MockitoAnnotations.openMocks(this);
        turnService = new TurnService(turnRepository);
    }

    @Test
    void should_findCompletedTurns_whereTurnStatusIsCompleted() {
        // arrange
        List<Turn> completedTurns = this.createCompletedTurns();
        Mockito.when(turnRepository.findByTurnStatusId(1)).thenReturn(completedTurns);

        // action
        List<Turn> turns = turnService.findCompletedTurns();

        // assert
        assertEquals(1, turns.get(0).getTurnStatus().getId());
    }

    private List<Turn> createCompletedTurns() {
        List<Turn> turns = new ArrayList<>();
        turns.add(new Turn(LocalDate.now(), new Diary(), new TurnStatus("concluido", "concluido"), new User()));
        turns.get(0).getTurnStatus().setId(1);
        return turns;
    }

}
