package ge.coordinates.coordinatesproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "public", name = "coordinates")
public class Coordinate {
    @Id

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="coordinates_seq_generation")
    @SequenceGenerator(name="coordinates_seq_generation", sequenceName="coordinates_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "car_num")
    private String carNum;

    @Column(name = "distance")
    private Double distance;

}
