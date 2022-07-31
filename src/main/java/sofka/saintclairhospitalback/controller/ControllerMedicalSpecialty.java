package sofka.saintclairhospitalback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;
import sofka.saintclairhospitalback.service.ServiceMedicalSpecialty;

import java.util.List;

@RestController
@RequestMapping("api/v1/hospital/")
@CrossOrigin("*")
public class ControllerMedicalSpecialty {

    @Autowired
    private ServiceMedicalSpecialty serviceMedicalSpecialty;

    @GetMapping("allmedicalspecialty")
    public List<DTOMedicalSpecialty> findallMedicalSpecialty() {
        return serviceMedicalSpecialty.findAllMedicalSpecialty();
    }

    @PostMapping("registerspecialty")
    public ResponseEntity registerspecialty(@RequestBody DTOMedicalSpecialty medicalspecialty) {
        if (medicalspecialty.getName().length() >= 5 && medicalspecialty.getPhysicianInCharge().length() <= 100 &&
                medicalspecialty.getPhysicianInCharge().length() >= 10 && medicalspecialty.getPhysicianInCharge().length() <= 45
        ) {

            return ResponseEntity.status(HttpStatus.OK).body(serviceMedicalSpecialty.saveSpecialtyRegister(medicalspecialty));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

    @PutMapping("updatespecialty")
    public ResponseEntity updatespecialty(@RequestBody DTOMedicalSpecialty medicalspecialty) {

        if (medicalspecialty.getName().length() >= 5 && medicalspecialty.getPhysicianInCharge().length() <= 100 &&
                medicalspecialty.getPhysicianInCharge().length() >= 10 && medicalspecialty.getPhysicianInCharge().length() <= 45
        ) {
            return ResponseEntity.status(HttpStatus.OK).body(serviceMedicalSpecialty.updateSpecialty(medicalspecialty));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);


    }


    @DeleteMapping("deletespecialty/{id}")
    public void deletespecialty(@PathVariable Integer id) {
        serviceMedicalSpecialty.deleteSpecialty(id);
    }

}
