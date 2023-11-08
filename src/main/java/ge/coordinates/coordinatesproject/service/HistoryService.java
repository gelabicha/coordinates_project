package ge.coordinates.coordinatesproject.service;

import ge.coordinates.coordinatesproject.entity.History;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoryService {
    List<History> getHistory();

    void historyCreateNew(Double latidude1, Double longitude1, String carNum1);
}
