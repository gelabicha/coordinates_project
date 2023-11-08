package ge.coordinates.coordinatesproject.service;

import ge.coordinates.coordinatesproject.entity.Coordinate;
import ge.coordinates.coordinatesproject.model.CoordinateCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoordinateService {
    Coordinate coordinateCreateNew(CoordinateCreateModel coordinateCreateModel);

    List<Coordinate> getCoordinate();

    Coordinate getCoordinate(String carNum);

    void coordinateCreateNew(Double latidude1, Double longitude1, String carNum1);
}