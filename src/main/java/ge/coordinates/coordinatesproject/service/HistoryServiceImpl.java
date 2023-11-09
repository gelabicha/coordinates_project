package ge.coordinates.coordinatesproject.service;

import ge.coordinates.coordinatesproject.entity.History;
import ge.coordinates.coordinatesproject.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.Now;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    @Override
    public List<History> getHistory() {
       return historyRepository.findAll() ;
    }

    @Override
    public void historyCreateNew(Double latidude1, Double longitude1, String carNum1) {
        History history = new History();
        history.setLatitude(latidude1);
        history.setLongitude(longitude1);
        history.setCarNum(carNum1);
        history.setInTime(LocalDateTime.now());
        historyRepository.save(history);
    }
}
