package semi.minor.pro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import semi.minor.pro.entity.Instructor;

public interface InstructorRepository extends MongoRepository<Instructor,Integer> {
}
