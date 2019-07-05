package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Project;
import pl.coderslab.model.Task;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.TaskRepository;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/details/{projectId}", method = RequestMethod.GET)
    public String projectDetails(Model model, @PathVariable Long projectId) {
        List<Task> projectTasks = taskRepository.findAllByProjectId(projectId);
        model.addAttribute("tasks", projectTasks);
        return "project/details";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allProjects(Model model) {
        List<Project> allProjects = projectRepository.findAll();
        model.addAttribute("allProjects", allProjects);
        return "project/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "project/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProject(@ModelAttribute Project project) {
        project.setCreated(new Date());
        projectRepository.save(project);
        return "redirect: all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editProjectForm(Model model, @PathVariable Long id) {
        Project projectToEdit = projectRepository.findOne(id);
        model.addAttribute("project", projectToEdit);
        return "project/editForm";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editProject(@ModelAttribute Project project, @PathVariable Long id) {
        Project dbProject = projectRepository.findOne(id);
        dbProject.setName(project.getName());
        dbProject.setDescription(project.getDescription());
        dbProject.setUpdated(new Date());
        projectRepository.save(dbProject);
        return "redirect: /user/project/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteProject(@PathVariable Long id) {
        projectRepository.delete(id);
        return "redirect: /user/project/all";
    }
}
