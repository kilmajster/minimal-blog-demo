##### short project description
This is very first version of this project - idea is to create easy to use and minimal configured 
blog engine for spring boot. Then it can be used for example like here, for manage versioning & docs.
Only  requirements are that file types of posts needs to be HTML or Markdown, 
and posts needs to be keep in some defined structure, like below:
```
blog
  ├── 2020-04-20
  │   └── example-blog-post.html
  ├── 2020-05-01
  │   └── ✅-markdown-is-now-supported!.md
  └── 2020-06-23
      └── PoC-&-examples.md
```
Date format of directories names pattern is `yyyy-mm-dd`.

### usage & minimal configuration
To make usage of this project you need to:
 - add maven dependency, eg:
   ```xml
    <dependency>
      <groupId>io.github.kilmajster</groupId>
      <artifactId>minimal-blog-spring-boot-starter</artifactId>
      <version>0.1-05062020-1</version>
    </dependency>
   ```
   so your final pom.xml file could look like following:
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
     <modelVersion>4.0.0</modelVersion>
        
     <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>2.2.5.RELEASE</version>
       <relativePath/>
     </parent>
        
     <groupId>com.example</groupId>
     <artifactId>blog</artifactId>
     <version>1.0</version>
     <name>demo</name>
     
     <dependencies>
       <dependency>
         <groupId>io.github.kilmajster</groupId>
         <artifactId>minimal-blog-spring-boot-starter</artifactId>
         <version>0.1-05062020-1</version>
       </dependency>
     </dependencies>
     
     <build>
       <plugins>
         <plugin>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-maven-plugin</artifactId>
         </plugin>
       </plugins>
     </build>
   </project>
   ```
 - then define `MinimalBlog` bean, like below:
   ```java
   @SpringBootApplication
   public class DemoApplication {
   
     public static void main(String[] args) { SpringApplication.run(DemoApplication.class, args); }
   
     @Bean
     public MinimalBlog configureBlog() {
       return new MinimalBlog()
           .withBlogName("Minimal blog spring boot starter 💡")
           .withAuthor("Łukasz")
           .withResourcesRootDir("blog")
           .withPostsOnPage(2)
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
   ```
 - then, for eg. if you got `withResourcesRootDir("blog")` you need to add directory with same name to your resources
 folder, and add some post files, so in the end you will got structure like below:
    ```xml
    src
    └── main
        ├── java
        │   └── com
        │       └── example
        │           └── demo
        │               └── DemoApplication.java
        └── resources
            ├── application.properties
            └── blog
                ├── 2020-04-20
                │   └── example-blog-post.html
                ├── 2020-05-01
                │   └── ✅-markdown-is-now-supported!.md
                └── 2020-06-23
                    └── PoC-&-examples.md
    ```
 
 - then you can compile & run app in any way you want, eg:
    ```bash
   $ mvn spring-boot:run 
    ```

### v0.1 Release notes
 - File based blog engine and minimal layout based on bootstrap and [@mdo](https://twitter.com/mdo) template.
 - Support for `.html` and `.md` files
 
