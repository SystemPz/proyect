package mx.code.develop.sisab.queries;

import mx.code.develop.sisab.model.Citizen;
import mx.code.develop.sisab.repository.CitizenRepository;
import mx.code.develop.sisab.shared.AppException;
import mx.code.develop.sisab.shared.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitizenQueries {
    @Autowired EntityManager entityManager;
    @Autowired private CitizenRepository citizenRepository;

    public Citizen save(Citizen citizen) {
        return citizenRepository.saveAndFlush(citizen);
    }

    public boolean isExistCitizen(String identifier) {
        return citizenRepository.isExistCitizen(identifier) > 0;
    }

    public Citizen findCitizenById(String identifier) {
        return citizenRepository.findCitizenById(identifier);
    }

    public List<Citizen> getCitizenAll() {
        return citizenRepository.findAll();
    }

    public List<Citizen> getCitizenById(Integer citizenId) {
        return citizenRepository.findAll().stream().filter(row->row.getId().equals(citizenId)).collect(Collectors.toList());
    }

    public Citizen searchCitizenById(Integer citizenId) {
        return citizenRepository.findById(citizenId).orElseThrow(()->new AppException(Messages.database_cantFindResource));
    }

    public void delete(Citizen citizen) {
        citizenRepository.delete(citizen);
    }
}
