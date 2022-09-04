package bagofideas.activities.controller;

import bagofideas.activities.model.Task;
import bagofideas.activities.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController
{
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("")
    List<Task> index()
    {
        return taskRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Task create (@RequestBody Task task)
    {
        return taskRepository.save(task);
    }

    @PutMapping("{id}")
    Task update (@PathVariable String id, @RequestBody Task task)
    {
        Task taskFromBD = taskRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        taskFromBD.setName(task.getName());
        taskFromBD.setComplete(task.isComplete());

        return taskRepository.save(taskFromBD);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete (@PathVariable String id)
    {
        Task taskFromBD = taskRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        taskRepository.delete(taskFromBD);
    }

}
