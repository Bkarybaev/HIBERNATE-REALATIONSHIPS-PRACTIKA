package java16;

import java16.config.DataBaseConfig;
import java16.dao.impl.PostDaoImpl;
import java16.enums.Gender;
import java16.models.Comment;
import java16.models.Post;
import java16.models.Profile;
import java16.models.User;
import java16.service.PostService;
import java16.service.impl.CommentServiceImpl;
import java16.service.impl.PostServiceImpl;
import java16.service.impl.ProfileServiceImpl;
import java16.service.impl.UserServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserServiceImpl userService = new UserServiceImpl();
        ProfileServiceImpl profileService = new ProfileServiceImpl();
        PostServiceImpl postService = new PostServiceImpl();
        CommentServiceImpl commentService = new CommentServiceImpl();
//
//        userService.save(User.builder()
//                        .username("Aibek")
//                        .email("Aibek@gmail.com")
//                .password("Aibek")
//                        .profile(new Profile(
//                                "Aibek Duisho uulu",
//                                LocalDate.of(2003,1,2),
//                                Gender.MALE,
//                                "Developer java language well"
//                        ))
//                .build());

//        userService.delete(252L);
//        System.out.println(userService.findById(52L));

//        profileService.delete(52L);


//        System.out.println(userService.updateUserProfile(302L, new Profile(
//                "Baiel Karybaev",
//                LocalDate.of(2004, 1, 18),
//                Gender.MALE,
//                "molodes lesson well study"
//        )));

//        System.out.println(profileService.findProfileByUserId(52L));

//        postService.savePost(302L,
//                new Post("https://user/is//17-jepandlfhsl23lasdf",
//                        "sdfvb wefdbailebialell"));

//        postService.getPostsByUserId(252L).forEach(System.out::println);

//        System.out.println(postService.searchPost("bail"));

//        postService.deletePostById(402L);
//
//        commentService.saveComment(402L,302L,
//                Comment.builder()
//                        .text("This is a comment")
//                        .build());

//        commentService.findCommentByPostId(452L).forEach(System.out::println);

//        commentService.updateComment(702L,"comment");

//        commentService.deleteComment(502L);

    }
}
