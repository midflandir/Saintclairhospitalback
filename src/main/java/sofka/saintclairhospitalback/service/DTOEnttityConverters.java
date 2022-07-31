package sofka.saintclairhospitalback.service;

import org.springframework.context.annotation.Configuration;

import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;
import sofka.saintclairhospitalback.dto.DTOPatient;
import sofka.saintclairhospitalback.model.MedicalSpecialty;
import sofka.saintclairhospitalback.model.Patient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class DTOEnttityConverters {

    public DTOMedicalSpecialty adddate(DTOMedicalSpecialty dtoMedicalSpecialty) {
        List<String> dates;
        dates = dtoMedicalSpecialty.getPatients().get(0).getDate();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        dates.add(formatter.format(date));
        dtoMedicalSpecialty.getPatients().get(0).setDate(dates);
        return dtoMedicalSpecialty;
    }

    public Patient convertDTOtoPatientEntity(DTOPatient DTOpatient, DTOMedicalSpecialty dtoMedicalSpecialty) {
        Patient aux_patient = new Patient();

        aux_patient.setId(DTOpatient.getId());
        aux_patient.setName(DTOpatient.getName());
        aux_patient.setAge(DTOpatient.getAge());
        aux_patient.setIdentificationNumber(DTOpatient.getIdentificationNumber());
        aux_patient.setDate(String.join(",", DTOpatient.getDate()));
        aux_patient.setNumberOfApointments(DTOpatient.getNumberOfApointments());
        aux_patient.setFkMedicalSpecialty(convertDTOtoEntity(dtoMedicalSpecialty));

        return aux_patient;
    }

    public MedicalSpecialty convertDTOtoEntity(DTOMedicalSpecialty specialty) {

        MedicalSpecialty auxdtospeciualty = new MedicalSpecialty();
        auxdtospeciualty.setId(specialty.getId());
        auxdtospeciualty.setPhysicianInCharge(specialty.getPhysicianInCharge());
        auxdtospeciualty.setName(specialty.getName());
        auxdtospeciualty.setPatients(null);

        return auxdtospeciualty;
    }

    public DTOMedicalSpecialty convertMedicalEntitytoDTOsingle(MedicalSpecialty medicalspecialty) {

        DTOMedicalSpecialty auxdtospeciualty = new DTOMedicalSpecialty();
        auxdtospeciualty.setId(medicalspecialty.getId());
        auxdtospeciualty.setPhysicianInCharge(medicalspecialty.getPhysicianInCharge());
        auxdtospeciualty.setName(medicalspecialty.getName());
        auxdtospeciualty.setPatients(null);

        return auxdtospeciualty;
    }
    public List<DTOMedicalSpecialty> convertMedicalEntitytoDTO(List<MedicalSpecialty> medicalspecialtylist) {
        List<DTOMedicalSpecialty> EntitytoDTO = new ArrayList<>();
        for (int i = 0; i < medicalspecialtylist.size(); i++) {
            DTOMedicalSpecialty auxdtospeciualty = new DTOMedicalSpecialty();
            auxdtospeciualty.setId(medicalspecialtylist.get(i).getId());
            auxdtospeciualty.setPhysicianInCharge(medicalspecialtylist.get(i).getPhysicianInCharge());
            auxdtospeciualty.setName(medicalspecialtylist.get(i).getName());
            auxdtospeciualty.setPatients(convertPatientlistEntitytoDTO(medicalspecialtylist.get(i).getPatients()));
            EntitytoDTO.add(auxdtospeciualty);
        }

        return EntitytoDTO;
    }

    private List<DTOPatient> convertPatientlistEntitytoDTO(List<Patient> patientlist) {
        List<DTOPatient> DTOpatientlist = new ArrayList<>();
        for (int i = 0; i < patientlist.size(); i++) {

            DTOPatient auxdtopatient = new DTOPatient();

            auxdtopatient.setId(patientlist.get(i).getId());
            auxdtopatient.setName(patientlist.get(i).getName());
            auxdtopatient.setAge(patientlist.get(i).getAge());
            auxdtopatient.setIdentificationNumber(patientlist.get(i).getIdentificationNumber());

            String[] dates = patientlist.get(i).getDate().split(",");
            auxdtopatient.setDate(Arrays.stream(dates).collect(Collectors.toList()));

            auxdtopatient.setNumberOfApointments(patientlist.get(i).getNumberOfApointments());
            DTOpatientlist.add(auxdtopatient);
        }

        return DTOpatientlist;
    }
    public DTOPatient convertPatientEntitytoDTO(Patient patient) {

        DTOPatient auxdtopatient = new DTOPatient();

        auxdtopatient.setId(patient.getId());
        auxdtopatient.setName(patient.getName());
        auxdtopatient.setAge(patient.getAge());
        auxdtopatient.setIdentificationNumber(patient.getIdentificationNumber());

        String[] dates = patient.getDate().split(",");
        auxdtopatient.setDate(Arrays.stream(dates).collect(Collectors.toList()));

        auxdtopatient.setNumberOfApointments(patient.getNumberOfApointments());

        return auxdtopatient;
    }
}
