package sofka.saintclairhospitalback.dto;

import lombok.Data;
import sofka.saintclairhospitalback.model.MedicalSpecialty;

import java.util.List;
@Data
public class DTOPatient {
    private Integer id;
    private String name;
    private Integer age;
    private Long identificationNumber;
    private List<String> date;
    private Integer numberOfApointments;
}
