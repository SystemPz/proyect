package mx.code.develop.sisab.controller;

import lombok.extern.log4j.Log4j;
import mx.code.develop.sisab.dto.CitizenDetailData;
import mx.code.develop.sisab.shared.AppException;
import mx.code.develop.sisab.shared.CustomResponseEntity;
import mx.code.develop.sisab.log.CitizenLogger;
import mx.code.develop.sisab.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/citizens")
@Log4j
public class CitizenController {
    @Autowired private CitizenService citizenService;

    @PostMapping("/addCitizen")
    public ResponseEntity<?> newCitizen(@RequestBody CitizenDetailData citizen) {
        try {
            String message = citizenService.newCitizen(citizen);
            return CustomResponseEntity.OK(message);
        } catch (AppException exception) {
            CitizenLogger.newCitizen(log, exception.getMessage(), citizen);
            return CustomResponseEntity.BAD_REQUEST(exception.getMessage());
        } catch (Exception exception) {
            CitizenLogger.newCitizen(log, exception.toString(), citizen);
            return CustomResponseEntity.INTERNAL_SERVER_ERROR();
        }
    }

    @GetMapping("/listCitizen/{citizenId}")
    public ResponseEntity<?> getCitizenAll(@PathVariable Integer citizenId) {
        try {
            List<CitizenDetailData> citizenDetailData = citizenService.getCitizenAll(citizenId);
            return CustomResponseEntity.OK(citizenDetailData);
        } catch (AppException exception) {
            CitizenLogger.getCitizenAll(log, exception.getMessage(), citizenId);
            return CustomResponseEntity.BAD_REQUEST(exception.getMessage());
        } catch (Exception exception) {
            CitizenLogger.getCitizenAll(log, exception.toString(), citizenId);
            return CustomResponseEntity.INTERNAL_SERVER_ERROR();
        }
    }

    @GetMapping("/delCitizen/{citizenId}")
    public ResponseEntity<?> deleteCitizen(@PathVariable Integer citizenId) {
        try {
            String message = citizenService.deleteCitizen(citizenId);
            return CustomResponseEntity.OK(message);
        } catch (AppException exception) {
            CitizenLogger.deleteCitizen(log, exception.getMessage(), citizenId);
            return CustomResponseEntity.BAD_REQUEST(exception.getMessage());
        } catch (Exception exception) {
            CitizenLogger.deleteCitizen(log, exception.toString(), citizenId);
            return CustomResponseEntity.INTERNAL_SERVER_ERROR();
        }
    }


}
