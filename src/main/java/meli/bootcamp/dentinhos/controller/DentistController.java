package meli.bootcamp.dentinhos.controller;

import meli.bootcamp.dentinhos.dto.DentistDTO;
import meli.bootcamp.dentinhos.service.DentistService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    public DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/agenda/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public DentistDTO getId(@PathVariable Integer id) {
        return dentistService.findById(id);
    }


    @GetMapping("/twoturns/{date}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<String> getTwoTurnsInOneDay(@PathVariable String date) {
       return dentistService.getTwoTurnsInOneDayForDentist(LocalDate.parse(date));
    }
}
