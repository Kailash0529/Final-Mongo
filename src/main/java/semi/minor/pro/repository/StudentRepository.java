package semi.minor.pro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import semi.minor.pro.entity.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {


}
