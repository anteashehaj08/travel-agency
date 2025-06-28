
import com.example.travel_agency.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    public interface CityRepository extends JpaRepository<City, Long> {
    }



