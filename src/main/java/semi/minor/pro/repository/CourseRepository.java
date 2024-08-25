package semi.minor.pro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import semi.minor.pro.entity.Course;

@Repository
public interface CourseRepository extends MongoRepository<Course,Integer> {
}
