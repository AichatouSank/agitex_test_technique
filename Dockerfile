FROM openjdk:17-jdk-slim
RUN mkdir /app
COPY target/*.jar /app/app.jar
CMD ["./mvnw", "spring-boot:run"]
ENTRYPOINT ["java","-jar","/app/app.jar"]

