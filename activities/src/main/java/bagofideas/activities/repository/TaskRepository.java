package bagofideas.activities.repository;

import bagofideas.activities.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String>
{
}
