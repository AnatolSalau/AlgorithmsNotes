package stream_api.grouping_examples;


import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * https://www.baeldung.com/java-groupingby-collector
 */
public class GroupingExamplesBaeldung {

      static enum BlogPostType {NEWS, REVIEW, GUIDE}

      static record BlogPost(String title, String author, BlogPostType type, int likes) {}


      public static void main(String[] args) {

            List<BlogPost> posts = Arrays.asList(
                  new BlogPost("Title1", "Autthor1", BlogPostType.NEWS, 1),
                  new BlogPost("Title2", "Autthor2", BlogPostType.REVIEW, 2),
                  new BlogPost("Title3", "Autthor3", BlogPostType.GUIDE, 3),
                  new BlogPost("Title4", "Autthor4", BlogPostType.NEWS, 4)
            );

            groupByBlogPostTypeTest(posts);
            groupByPairTypeNameTest(posts);
      }

      public static void groupByBlogPostType(List<BlogPost> posts) {
            Map<BlogPostType, List<BlogPost>> collect = posts.stream()
                  .collect(Collectors.groupingBy(BlogPost::type));
            System.out.println(collect);
      }

      public static void groupByBlogPostTypeTest(List<BlogPost> posts) {
            Map<BlogPostType, List<BlogPost>> collect = posts.stream()
                  .collect(Collectors.groupingBy(BlogPost::type));
            System.out.println(collect);
      }

      public static void groupByPairTypeName(List<BlogPost> posts) {
            Map<Pair<BlogPostType, String>, List<BlogPost>> collect = posts.stream()
                  .collect(Collectors.groupingBy(
                        post -> new Pair(post.type, post.author)
                  ));
            System.out.println(collect);
      }
      public static void groupByPairTypeNameTest(List<BlogPost> posts) {
            Map<String, List<BlogPost>> map = posts.stream()
                  .collect(Collectors.groupingBy(post -> post.author));
            System.out.println(map);
      }
}
