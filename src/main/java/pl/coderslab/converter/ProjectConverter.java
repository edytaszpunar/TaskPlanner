package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Project;
import pl.coderslab.repository.ProjectRepository;

public class ProjectConverter implements Converter<String, Project> {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project convert(String s) {
        return projectRepository.findOne(Long.valueOf(s));
    }
}
