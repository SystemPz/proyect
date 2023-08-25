package mx.code.develop.sisab.service;

import mx.code.develop.sisab.dto.CitizenDetailData;
import mx.code.develop.sisab.dto.HomeAddressData;
import mx.code.develop.sisab.model.Citizen;
import mx.code.develop.sisab.model.HomeAddress;
import mx.code.develop.sisab.queries.CitizenQueries;
import mx.code.develop.sisab.queries.HomeAddressQueries;
import mx.code.develop.sisab.shared.AppFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitizenService {
    @Autowired private CitizenQueries citizenQueries;
    @Autowired private HomeAddressQueries homeAddressQueries;

    public String newCitizen(CitizenDetailData citizenData) {
        Citizen citizen = new Citizen(citizenData);
        if (!citizenQueries.isExistCitizen(citizenData.getIdentifier())) {
            citizen = citizenQueries.save(citizen);
            Citizen data = citizenQueries.findCitizenById(citizenData.getIdentifier());
            newAddress(citizenData.getAddress(), data);
        } else {
            if (citizenData.getId() != null || citizen.getId() != 0) {
                citizen = citizenQueries.save(citizen);
                Citizen data = citizenQueries.findCitizenById(citizenData.getIdentifier());
                newAddress(citizenData.getAddress(), data);
            }
        }
        return "Registro "+"atualizado" +"agredado"+" correctamente.";
    }

    private void newAddress(List<HomeAddressData> address, Citizen citizen) {
        List<HomeAddress> addressesList = new ArrayList<>();
        address.forEach(row->{
            System.out.println(row.getNameAddress());
            addressesList.add(new HomeAddress(row, citizen));
        });
        homeAddressQueries.save(addressesList);
    }

    public List<CitizenDetailData> getCitizenAll(Integer citizenId) {

        List<CitizenDetailData> citizenDetailData = new ArrayList<>();
        if (AppFunctions.positiveInteger(citizenId)) {
            citizenQueries.getCitizenById(citizenId).stream().forEach(row -> {
                List<HomeAddressData> addressData = homeAddressQueries.getHomeAddress(row.getId());
                citizenDetailData.add(new CitizenDetailData(row.getId(), row.getIdentifier(), row.getName(), row.getFirstLastName(), row.getSecondLastName(), row.getGender(), addressData));
            });
        } else {
            citizenQueries.getCitizenAll().stream().forEach(row -> {
                List<HomeAddressData> addressData = homeAddressQueries.getHomeAddress(row.getId());
                citizenDetailData.add(new CitizenDetailData(row.getId(), row.getIdentifier(), row.getName(), row.getFirstLastName(), row.getSecondLastName(), row.getGender(), addressData));
            });
        }
        return citizenDetailData;
    }

    public String deleteCitizen(Integer citizenId) {
        Citizen citizen = citizenQueries.searchCitizenById(citizenId);
        if (citizen != null) {
            List<HomeAddress> addresses = homeAddressQueries.searchCitizenById(citizen.getId());
            if (addresses.size() > 0) {
                homeAddressQueries.deleteAll(addresses);
                citizenQueries.delete(citizen);
            }
        }
        return "Registro eliminado";
    }


}
