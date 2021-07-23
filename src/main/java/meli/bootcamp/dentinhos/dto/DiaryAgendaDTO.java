package meli.bootcamp.dentinhos.dto;

import meli.bootcamp.dentinhos.domain.Turn;
import meli.bootcamp.dentinhos.utils.ConvertUtils;

import java.time.LocalDateTime;
import java.util.List;

public class DiaryAgendaDTO {

    private Integer id;

    private LocalDateTime startTime;

    private LocalDateTime endingTime;
    private List<TurnDTO> turns;

    public DiaryAgendaDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime) {
        this.endingTime = endingTime;
    }

    public List<TurnDTO> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = ConvertUtils.mapAll(turns, TurnDTO.class);
    }
}
