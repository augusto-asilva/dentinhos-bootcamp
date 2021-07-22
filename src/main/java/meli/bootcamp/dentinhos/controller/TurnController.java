package meli.bootcamp.dentinhos.controller;

import meli.bootcamp.dentinhos.domain.Turn;
import meli.bootcamp.dentinhos.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("turns")
public class TurnController {

    @Autowired
    private TurnService turnService;

    @GetMapping("/completed")
    public List<Turn> completedTurns() {
        return turnService.findCompletedTurns();
    }
}
