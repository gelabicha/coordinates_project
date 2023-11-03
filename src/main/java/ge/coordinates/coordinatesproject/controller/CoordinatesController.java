package ge.coordinates.coordinatesproject.controller;

import ge.coordinates.coordinatesproject.entity.Coordinate;
import ge.coordinates.coordinatesproject.model.CoordinateCreateModel;
import ge.coordinates.coordinatesproject.service.CoordinateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CoordinatesController {
    private final CoordinateService coordinateService;
    @PostMapping("files")
    public Coordinate coordinateCreateNew(@RequestBody CoordinateCreateModel coordinateCreateModel){
        return coordinateService.coordinateCreateNew(coordinateCreateModel);
    }

}
