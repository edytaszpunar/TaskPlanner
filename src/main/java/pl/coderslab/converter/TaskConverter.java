package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Task;
import pl.coderslab.repository.TaskRepository;

public class TaskConverter implements Converter<String, Task> {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task convert(String s) {
        return taskRepository.findOne(Long.valueOf(s));
    }
}
