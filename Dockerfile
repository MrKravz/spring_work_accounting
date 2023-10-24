FROM openjdk:17
RUN mkdir /app
WORKDIR /app
COPY target/spring_work_accounting-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT java -jar /app/spring_work_accounting-0.0.1-SNAPSHOT.jar
