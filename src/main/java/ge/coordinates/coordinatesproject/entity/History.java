package ge.coordinates.coordinatesproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(schema = "public", name = "history")
public class History {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="history_seq_generation")
    @SequenceGenerator(name="history_seq_generation", sequenceName="history_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "car_num")
    private String carNum;

    @Column(name = "intime")
    private LocalDateTime inTime;
}
