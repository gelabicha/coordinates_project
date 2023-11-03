package ge.coordinates.coordinatesproject.controller;

import ge.coordinates.coordinatesproject.entity.Coordinate;
import ge.coordinates.coordinatesproject.repository.CoordinateRepository;
import ge.coordinates.coordinatesproject.service.CoordinateService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Comparator;
import java.util.List;

@RestController
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("file")
public class ReadExcelController {
    private final CoordinateRepository coordinateRepository;
    private final CoordinateService coordinateService;
    private double latidude;
    private double longitude;


    @GetMapping("{filename}")
    public ResponseEntity<?> getFile(@PathVariable String filename, HttpServletResponse response) {
        var prefix = "/home/malthaell/projects/java/test.xlsx";
        File f = new File(prefix);
        var bodyinfo = "";
        XSSFSheet sheet;
        try (XSSFWorkbook workbook = new XSSFWorkbook(f.getAbsolutePath())) {
            sheet = workbook.getSheetAt(0);

            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    bodyinfo = bodyinfo + row.getCell(j) + " " + "\n";
                }
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        for (Row row : sheet){
            Coordinate coordinate = new Coordinate();
            coordinate.setLongitude(row.getCell(0).getNumericCellValue());
            coordinate.setLatitude(row.getCell(1).getNumericCellValue());
            coordinate.setCarNum(row.getCell(2).getStringCellValue());
            coordinateRepository.save(coordinate);

        }
        return ResponseEntity.ok(bodyinfo);
    }
    @GetMapping("/call")
    public ResponseEntity<List<Coordinate>> calDis(@RequestParam("latitude") Double latidude,@RequestParam("longitude")  Double longitude){
        this.latidude = latidude;
        this.longitude = longitude;
        List<Coordinate> coordinateList = coordinateService.getCoordinate();
        for(Coordinate coordinate : coordinateList){
            Double distance = distanceCal(latidude,latidude,coordinate.getLatitude(),coordinate.getLongitude());
            coordinate.setDistance(distance);
        }
        coordinateList.sort(Comparator.comparingDouble(Coordinate::getDistance));
        return new ResponseEntity<>(coordinateList, HttpStatus.OK);

    }
    public static double distanceCal(double lat1,
                                     double lat2, double lon1,
                                     double lon2)
    {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        double r = 6371;

        return(c * r);
    }
}

