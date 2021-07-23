package meli.bootcamp.dentinhos.service;

import meli.bootcamp.dentinhos.domain.*;
import meli.bootcamp.dentinhos.repository.TurnRepository;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    void should_findRescheduledTurnsforAValidDentist() {
        // arrange
        Diary diary = this.createDiary();
        Dentist dentist = diary.getDentist();
        Turn turn = this.createRescheduledTurn();;
        turn.setDiary(diary);
        List<Turn> rescheduledDentistTurns = new ArrayList<>();
        rescheduledDentistTurns.add(turn);
        Mockito.when(turnRepository.findByTurnStatusIdAndDiaryDentistId(turn.getTurnStatus().getId(), dentist.getId()))
                .thenReturn(rescheduledDentistTurns);

        // action
        List<Turn> turns = turnService.findRescheduledDentistTurns(dentist.getId());

        // assertion
        assertEquals(turns, rescheduledDentistTurns);
    }

    private Turn createRescheduledTurn() {
        Turn turn = new Turn();
        TurnStatus rescheduledTurnStatus = new TurnStatus("Reprogramado", "unit_test");
        rescheduledTurnStatus.setId(4);
        turn.setTurnStatus(rescheduledTurnStatus);
        return turn;
    }

    private Diary createDiary() {
        LocalDateTime startTime = LocalDateTime.of(2021, Month.JUNE, 21, 9, 30);
        LocalDateTime endTime = LocalDateTime.of(2021, Month.JUNE, 21, 10, 30);
        Dentist dentist = new Dentist("DTEST1", new ArrayList<>());
        Diary diary = new Diary(1, startTime, endTime, dentist, new ArrayList<>());
        dentist.setId(1);
        dentist.setDiaries(Arrays.asList(diary));
        diary.setDentist(dentist);
        return diary;
    }

    private List<Turn> createCompletedTurns() {
        List<Turn> turns = new ArrayList<>();
        TurnStatus turnStatus = new TurnStatus("concluido", "concluido");
        turnStatus.setId(1);
        turns.add(new Turn(LocalDate.now(), new Diary(), turnStatus, new User()));
        return turns;
    }

}
