FROM openjdk:17-alpine

LABEL author="d3kumar"
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} skillmatrix-0.0.1-SNAPSHOT.jar
#changing owner permission using --chown command
COPY --chown=appuser:appuser /target/classes/static static/
#giving permission to read,write and exec to static folder...
RUN chmod 744 static/
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "skillmatrix-0.0.1-SNAPSHOT.jar"]
