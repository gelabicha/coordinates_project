package ge.coordinates.coordinatesproject.model;

import java.sql.Timestamp;

public record HistoryCreateModel(Double latidude, Double longitude, String carNum, Timestamp inTime) {
}
