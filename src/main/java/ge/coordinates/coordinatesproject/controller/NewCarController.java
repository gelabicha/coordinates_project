package ge.coordinates.coordinatesproject.controller;

import ge.coordinates.coordinatesproject.entity.Coordinate;
import ge.coordinates.coordinatesproject.entity.History;
import ge.coordinates.coordinatesproject.model.CoordinateCreateModel;
import ge.coordinates.coordinatesproject.repository.CoordinateRepository;
import ge.coordinates.coordinatesproject.repository.HistoryRepository;
import ge.coordinates.coordinatesproject.service.CoordinateService;
import ge.coordinates.coordinatesproject.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("newcar")
public class NewCarController {
    private final CoordinateRepository coordinateRepository;
    private final CoordinateService coordinateService;
    private final HistoryRepository historyRepository;
    private final HistoryService historyService;
    @GetMapping("car")
    public void newcar(@RequestParam("latitude") Double latidude1, @RequestParam("longitude")  Double longitude1,
                             @RequestParam("carNum") String carNum1) {
        var cars= coordinateRepository.findAllByCarNum(carNum1);
        if(cars.isEmpty()){
            coordinateService.coordinateCreateNew(latidude1,longitude1,carNum1);
        }else {
          var carrr = cars.get(0);
          carrr.setLatitude(latidude1);
          carrr.setLongitude(longitude1);
          coordinateRepository.save(carrr);
        }
        historyService.historyCreateNew(latidude1,longitude1,carNum1);
    }
    public List<Coordinate> search(String carNum){
        return coordinateRepository.findAllByCarNum(carNum);
    }


    }





