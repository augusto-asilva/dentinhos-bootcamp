package meli.bootcamp.dentinhos.dto;

import meli.bootcamp.dentinhos.domain.Diary;
import meli.bootcamp.dentinhos.utils.ConvertUtils;

import java.util.List;

public class DentistDTO extends UserDTO {

    private String codeMp;
    private List<DiaryAgendaDTO> diaries;

    public DentistDTO() {
    }

    public DentistDTO(String codeMp, List<DiaryAgendaDTO> diaries) {
        this.codeMp = codeMp;
        this.diaries = diaries;
    }

    public DentistDTO(Integer id, String name, String lastName, String codeMp, List<DiaryAgendaDTO> diaries) {
        super(id, name, lastName);
        this.codeMp = codeMp;
        this.diaries = diaries;
    }

    public String getCodeMp() {
        return codeMp;
    }

    public void setCodeMp(String codeMp) {
        this.codeMp = codeMp;
    }

    public List<DiaryAgendaDTO> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<Diary> diaries) {
        this.diaries = ConvertUtils.mapAll(diaries, DiaryAgendaDTO.class);
    }
}
