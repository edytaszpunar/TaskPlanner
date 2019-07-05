package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Comment;
import pl.coderslab.model.Task;
import pl.coderslab.model.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TaskRepository;
import pl.coderslab.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @ModelAttribute("chooseUser")
    public List<User> usersList() {
        return userRepository.findAll();
    }

    @ModelAttribute("chooseTask")
    public List<Task> tasksList() {
        return taskRepository.findAll();
    }

    @RequestMapping(value = "/showComments/{taskId}", method = RequestMethod.GET)
    public String showComments(Model model, @PathVariable Long taskId) {
        List<Comment> taskComments = commentRepository.findByTaskId(taskId);
        model.addAttribute("comments", taskComments);
        return "comment/showComments";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allComment(Model model) {
        List<Comment> allComments = commentRepository.findAll();
        model.addAttribute("allComments", allComments);
        return "comment/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCommentForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addComment(@ModelAttribute Comment comment) {
        comment.setCreated(new Date());
        commentRepository.save(comment);
        return "redirect: all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editCommentForm(Model model, @PathVariable Long id) {
        Comment commentToEdit = commentRepository.findOne(id);
        model.addAttribute("comment", commentToEdit);
        return "comment/editForm";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editComment(@ModelAttribute Comment comment, @PathVariable Long id) {
        Comment dbComment = commentRepository.findOne(id);
        dbComment.setComment(comment.getComment());
        commentRepository.save(dbComment);
        return "redirect: /user/comment/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteComment(@PathVariable Long id) {
        commentRepository.delete(id);
        return "redirect: /user/comment/all";
    }
}

