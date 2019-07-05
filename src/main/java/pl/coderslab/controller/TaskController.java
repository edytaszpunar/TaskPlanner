package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Comment;
import pl.coderslab.model.Project;
import pl.coderslab.model.Task;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.TaskRepository;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ProjectRepository projectRepository;

    @ModelAttribute("comments")
    public List<Comment> commentList() {
        return commentRepository.findAll();
    }

    @ModelAttribute("chooseProject")
    public List<Project> projectList() {
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allTask(Model model) {
        List<Task> allTasks = taskRepository.findAll();
        model.addAttribute("allTasks", allTasks);
        return "task/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute Task task) {
        task.setCreated(new Date());
        taskRepository.save(task);
        return "redirect: all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTaskForm(Model model, @PathVariable Long id) {
        Task taskToEdit = taskRepository.findOne(id);
        model.addAttribute("task", taskToEdit);
        return "task/editForm";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editTask(@ModelAttribute Task task, @PathVariable Long id) {
        Task dbTask = taskRepository.findOne(id);
        dbTask.setName(task.getName());
        dbTask.setProject(task.getProject());
        dbTask.setDescription(task.getDescription());
        dbTask.setPriority(task.getPriority());
        dbTask.setUpdated(new Date());
        taskRepository.save(dbTask);
        return "redirect: /user/task/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteTask(@PathVariable Long id) {
        taskRepository.delete(id);
        return "redirect: /user/task/all";
    }
}
