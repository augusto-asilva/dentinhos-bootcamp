package meli.bootcamp.dentinhos.dto;

import java.time.LocalDate;

public class PendingTurnDTO {

    private LocalDate day;
    private String turnStatus;
    private PatientDTO patientDTO;
    private DiaryDTO diaryDTO;

    public PendingTurnDTO() {
    }

    public PendingTurnDTO(LocalDate day, String turnStatus, PatientDTO patientDTO, DiaryDTO diaryDTO) {
        this.day = day;
        this.turnStatus = turnStatus;
        this.patientDTO = patientDTO;
        this.diaryDTO = diaryDTO;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(String turnStatus) {
        this.turnStatus = turnStatus;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public DiaryDTO getDiaryDTO() {
        return diaryDTO;
    }

    public void setDiaryDTO(DiaryDTO diaryDTO) {
        this.diaryDTO = diaryDTO;
    }
}
