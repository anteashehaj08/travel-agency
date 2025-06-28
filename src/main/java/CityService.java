
import com.example.travel_agency.entities.City;

import java.util.List;
import java.util.Optional;

    public interface CityService {
        City createCity(City city);
        List<City> getAllCities();
        Optional<City> getCityById(Long id);
        City updateCity(Long id, City city);
        void deleteCity(Long id);
    }

