package sofka.saintclairhospitalback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;
import sofka.saintclairhospitalback.dto.DTOPatient;
import sofka.saintclairhospitalback.model.MedicalSpecialty;
import sofka.saintclairhospitalback.model.Patient;
import sofka.saintclairhospitalback.service.ServiceMedicalSpecialty;
import sofka.saintclairhospitalback.service.ServicePatient;

@RestController
@RequestMapping("api/v1/hospital/")
@CrossOrigin("*")
public class CotrolelrPatient {

    @Autowired
    private ServicePatient servicepatient;
    @PostMapping("registerpatient")
    public DTOPatient registerpatient(@RequestBody DTOMedicalSpecialty dtomedical){
        return servicepatient.savePatientRegister(dtomedical);
    }
}
