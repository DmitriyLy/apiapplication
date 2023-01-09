FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY /src /app/src
RUN mvn clean
RUN mvn package -X -DskipTests

FROM openjdk:17-jdk
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 9080
EXPOSE 5005
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "app.jar"]