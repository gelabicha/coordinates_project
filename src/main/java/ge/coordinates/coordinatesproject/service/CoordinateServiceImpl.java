package ge.coordinates.coordinatesproject.service;

import ge.coordinates.coordinatesproject.entity.Coordinate;
import ge.coordinates.coordinatesproject.model.CoordinateCreateModel;
import ge.coordinates.coordinatesproject.repository.CoordinateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CoordinateServiceImpl implements CoordinateService {
    private final CoordinateRepository coordinateRepository;
    @Override
    public Coordinate coordinateCreateNew(CoordinateCreateModel coordinateCreateModel) {
        Coordinate coordinate = new Coordinate();
        coordinate.setLatitude(coordinateCreateModel.latitude());
        coordinate.setLongitude(coordinateCreateModel.longitude());
        coordinate.setCarNum(coordinateCreateModel.carNum());
        coordinateRepository.save(coordinate);
        return coordinate;
    }

    @Override
    public List<Coordinate> getCoordinate() {
        return coordinateRepository.findAll();
    }
}
