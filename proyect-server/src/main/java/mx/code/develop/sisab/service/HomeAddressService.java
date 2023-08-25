package mx.code.develop.sisab.service;

import mx.code.develop.sisab.queries.HomeAddressQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeAddressService {
    @Autowired private HomeAddressQueries homeAddressQueries;
}
