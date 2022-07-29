package sofka.saintclairhospitalback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;
import sofka.saintclairhospitalback.service.ServiceMedicalSpecialty;

import java.util.List;

@RestController
@RequestMapping("api_hospital/")
@CrossOrigin("*")
public class ControllerMedicalSpecialty {

@Autowired
    private ServiceMedicalSpecialty serviceMedicalSpecialty;

    @GetMapping("allmedicalspecialty")
    public List<DTOMedicalSpecialty> findallMedicalSpecialty(){
        return serviceMedicalSpecialty.findAllMedicalSpecialty();
    }



}
