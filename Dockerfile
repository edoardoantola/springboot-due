FROM openjdk:21
ADD target/springboot-due.jar app1.jar
ENTRYPOINT [ "java", "-jar","app.jar" ]  