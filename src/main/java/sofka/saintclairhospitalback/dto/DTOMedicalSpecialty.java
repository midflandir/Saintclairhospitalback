package sofka.saintclairhospitalback.dto;

import lombok.Data;
import sofka.saintclairhospitalback.model.Patient;

import java.util.ArrayList;
import java.util.List;
@Data
public class DTOMedicalSpecialty {
    private Integer id;
    private String name;
    private String physicianInCharge;
    private List<DTOPatient> patients = new ArrayList<>();
}
