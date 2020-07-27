# Multiple_file_upload_using_Spring_Boot_And_MYSQL
Upload Multiple Images using Spring Boot And MYSQL

In this project you can upload multiple images and multiple files in our database. User can store your your data into database using Thymleaf in spring boot and Web services. In this pom.xml file, the main dependency is JPA, WEB, THYMLEAF, WEB SERVICES, SPRING DEV TOOLS, MYSQL, COMMONS. In ths application.properities, you should change on system:

              spring.datasource.url = PLEASE ENTER YOUR MYSQL DATABASE URL/PROT NO./SCHEAMA/
              spring.datasource.username = PLEASE ENTER YOUR MYSQL "USERNAME"
              spring.datasource.password = PLEASE ENTER YOUR MYSQL "PASSWORD"
              
              server.port=8082
              spring.servlet.multipart.max-file-size=2000MB
              spring.servlet.multipart.max-request-size=215MB

              spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
              spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
              spring.jpa.hibernate.ddl-auto=update
Plase run your application in our browser "http://localhost:8082/"
