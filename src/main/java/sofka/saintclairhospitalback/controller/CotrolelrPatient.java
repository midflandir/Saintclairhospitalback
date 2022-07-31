package sofka.saintclairhospitalback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;
import sofka.saintclairhospitalback.dto.DTOPatient;
import sofka.saintclairhospitalback.service.ServicePatient;

@RestController
@RequestMapping("api/v1/hospital/")
@CrossOrigin("*")
public class CotrolelrPatient {

    @Autowired
    private ServicePatient servicepatient;
    @PostMapping("registerpatient")
    public ResponseEntity registerpatient(@RequestBody DTOMedicalSpecialty dtomedicalpatient){

        if (dtomedicalpatient.getPatients().get(0).getName().length() >= 10 &&
                dtomedicalpatient.getPatients().get(0).getName().length() <=45){
            return ResponseEntity.status(HttpStatus.OK).body(servicepatient.savePatientRegister(dtomedicalpatient));
        }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }
    @DeleteMapping("deletepatient/{id}")
    public void deletepatient(@PathVariable Integer id){
        servicepatient.deletePatient(id);
    }
    @PutMapping("adddatepatient")
    public ResponseEntity adddatepatient(@RequestBody DTOMedicalSpecialty dtomedicalpatient){
        if (dtomedicalpatient.getPatients().get(0).getName().length() >= 10 &&
                dtomedicalpatient.getPatients().get(0).getName().length() <=45){
            return ResponseEntity.status(HttpStatus.OK).body(servicepatient.savePatientdate(dtomedicalpatient));
        }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

}
