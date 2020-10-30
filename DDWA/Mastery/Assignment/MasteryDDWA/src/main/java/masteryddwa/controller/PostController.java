/*
Created by: Margaret Donin
Date created: 10/26/20
Date revised:
 */
package masteryddwa.controller;

import static java.lang.Boolean.parseBoolean;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import masteryddwa.dao.CommentDao;
import masteryddwa.dao.PostDao;
import masteryddwa.dao.UserDao;
import masteryddwa.dto.Comment;
import masteryddwa.dto.Hashtag;
import masteryddwa.dto.Post;
import masteryddwa.dto.User;
import masteryddwa.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private HashtagService hashtagService;

    Set<ConstraintViolation<Post>> postViolations = new HashSet<>();
    Set<ConstraintViolation<Comment>> commentViolations = new HashSet<>();

    @GetMapping({"/", "/home"})
    public String displayHomePage(Model model) {
        List<Post> blogs = postDao.getAllEnabledBlogs();
        List<Post> statics = postDao.getAllEnabledStatics();

        model.addAttribute("blogs", blogs);
        model.addAttribute("statics", statics);

        return "index";
    }

    @GetMapping("postsAll")
    public String postsAll(Model model) {
        List<Post> blogs = postDao.getAllPosts();
        List<Post> statics = postDao.getAllEnabledStatics();

        model.addAttribute("blogs", blogs);
        model.addAttribute("statics", statics);

        return "postsAll";
    }

    @GetMapping("post")
    public String displayPost(Integer id, Model model) {
        commentViolations = new HashSet<>();

        List<Post> statics = postDao.getAllEnabledStatics();
        Post post = postDao.getPostById(id);
        List<Comment> comments = commentDao.getAllEnabledCommentsByPostId(id);

        model.addAttribute("statics", statics);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("errors", commentViolations);

        return "post";
    }

    @GetMapping("postAdd")
    public String postAdd(Model model) {
        postViolations = new HashSet<>();

        List<Post> statics = postDao.getAllEnabledStatics();
        model.addAttribute("statics", statics);
        model.addAttribute("errors", postViolations);

        return "postAdd";
    }

    @PostMapping("postAdd")
    public String postAddAction(HttpServletRequest request) {

        List<Hashtag> tags = hashtagService.getHashtags(request.getParameter("hashtags"));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.getUserByLogin(authentication.getName());

        Post post = new Post();
        post.setEnabled(parseBoolean(request.getParameter("enabled")));
        post.setStaticPost(parseBoolean(request.getParameter("staticPost")));
        post.setBody(request.getParameter("text"));
        post.setStart(LocalDate.parse(request.getParameter("start"), DateTimeFormatter.ISO_DATE));
        post.setEnd(LocalDate.parse(request.getParameter("end"), DateTimeFormatter.ISO_DATE));
        post.setTitle(request.getParameter("title"));
        post.setUser(user);
        post.setHashtags(tags);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        postViolations = validate.validate(post);

        if (postViolations.isEmpty()) {
            postDao.addPost(post);
            return "redirect:/post?id=" + post.getId();
        } else {

            return "postAdd";
        }

    }

    @PostMapping("commentAdd")
    public String addComment(Integer postId, String text, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Comment comment = new Comment();
        comment.setPostId(postId);
        comment.setUser(userDao.getUserByLogin(authentication.getName()));
        comment.setText(text);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        commentViolations = validate.validate(comment);

        if (commentViolations.isEmpty()) {
            commentDao.addComment(comment);
            return "redirect:/post?id=" + postId;
        } else {
            
            return "commentAdd";
        }

    }

    @GetMapping("postEdit")
    public String postEdit(Integer id, Model model) {
        postViolations = new HashSet<>();
        List<Post> statics = postDao.getAllEnabledStatics();
        Post post = postDao.getPostById(id);

        model.addAttribute("statics", statics);
        model.addAttribute("post", post);
        model.addAttribute("errors", postViolations);

        return "postEdit";
    }

    @PostMapping("postEdit")
    public String postEditAction(Integer id, String title, boolean enabled,
            boolean staticPost, String text, String start, String end, Model model,
            String hashtags) {

        List<Hashtag> tags = hashtagService.getHashtags(hashtags);

        Post post = postDao.getPostById(id);
        post.setStaticPost(staticPost);
        post.setBody(text);
        post.setStart(LocalDate.parse(start, DateTimeFormatter.ISO_DATE));
        post.setEnd(LocalDate.parse(end, DateTimeFormatter.ISO_DATE));
        post.setTitle(title);
        post.setHashtags(tags);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getCredentials() == "ROLE_ADMIN") {
            post.setEnabled(enabled);
        } else {
            post.setEnabled(false);
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        postViolations = validate.validate(post);

        if (postViolations.isEmpty()) {
            postDao.editPost(post);
            return "redirect:/post?id=" + id;
        }
        model.addAttribute("errors", postViolations);

        return "postEdit";
    }

    @GetMapping("postDelete")
    public String postDelete(Integer id) {
        postDao.deletePost(id);

        return "redirect:/postsAll)";
    }

    @GetMapping("postDeleteExpired")
    public String postDelete() {
        postDao.deleteExpiredPosts();

        return "redirect:/postsAll";
    }

}
