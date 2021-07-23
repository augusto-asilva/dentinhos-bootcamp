package meli.bootcamp.dentinhos.controller;

import meli.bootcamp.dentinhos.domain.Turn;
import meli.bootcamp.dentinhos.dto.PendingTurnDTO;
import meli.bootcamp.dentinhos.dto.UserContactResponseDTO;
import meli.bootcamp.dentinhos.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import meli.bootcamp.dentinhos.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turns")
public class TurnController {

    private TurnService turnService;

    @Autowired
    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @GetMapping("/completed")
    public List<Turn> completedTurns() {
        return turnService.findCompletedTurns();
    }

    @GetMapping("/rescheduled")
    public List<Turn> rescheduledurns() {
        return turnService.findRescheduledTurns();
    }

    @GetMapping("/completed/{day}/patients")
    public List<UserContactResponseDTO> completedTurns(@PathVariable String day) {
        LocalDate days = LocalDate.parse(day);
        List<UserContactResponseDTO> users = new ArrayList<>();
        List<Turn> turns = turnService.findCompletedTurnsOnAGivingDay(days);
        turns.forEach(turn -> users.add(new UserContactResponseDTO(turn.getPatient())));
        return users;
    }

    @GetMapping("/pending/{date}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<PendingTurnDTO> getPendingTurns(@PathVariable String date) {
        return turnService.getPendingTurnsByDay(LocalDate.parse(date));
    }
}