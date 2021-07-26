package meli.bootcamp.dentinhos.service;

import meli.bootcamp.dentinhos.domain.Dentist;
import meli.bootcamp.dentinhos.dto.DentistDTO;
import meli.bootcamp.dentinhos.repository.DentistRepository;
import meli.bootcamp.dentinhos.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    public DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public DentistDTO findById(Integer id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        if (!dentist.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nenhum dentista encontrado");

        return ConvertUtils.map(dentist.get(), DentistDTO.class);
    }

    public List<String> getTwoTurnsInOneDayAtDentist(LocalDate date){

        return dentistRepository.dentists(date);
    }
}
