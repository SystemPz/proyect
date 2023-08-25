package mx.code.develop.sisab.controller;

import lombok.extern.log4j.Log4j;
import mx.code.develop.sisab.service.HomeAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
@Log4j
public class HomeAddressController {
    @Autowired private HomeAddressService homeAddressService;

}
