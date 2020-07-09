package io.github.kilmajster.blog;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.kilmajster.blog.config.ElsewhereLink;
import io.github.kilmajster.blog.config.MinimalBlog;

@SpringBootApplication
public class MinimalBlogDemo {

  public static void main(String[] args) {
    SpringApplication.run(MinimalBlogDemo.class, args);
  }

  @Bean
  public MinimalBlog configureBlog() {
    return new MinimalBlog()
        .withBlogName("Minimal blog spring boot starter 💡")
        .withAuthor("Łukasz Włódarczyk")
        .withResourcesRootDir("blog")
        .withPostsOnPage(1)
        .withAboutContent(// @formatter:off
          "This is example content of about section, about is great for not too " +
          "long but also not too short texts quotes, it will be show every time " +
          "on the main page. This one contain (190) characters! 🎉" // @formatter:on
        ).withElsewhereLinks(Arrays.asList(
            new ElsewhereLink()
                .withName("Project github page")
                .withLink("https://github.com/kilmajster/minimal-blog-spring-boot-starter"),
            new ElsewhereLink()
                .withName("Cool link 🌵")
                .withLink("http://www.google.com")
        )).withHideTemplateInfo(false)
        .withTemplateInfoOverride(// @formatter:off
          "<code>Developed with 🍀 for <a href=\"https://spring.io/projects/spring-boot\">spring-boot</a> " +
          "by <a href=\"https://github.com/kilmajster\">@kilmajster</a></code>"); // @formatter:on
  }
}
