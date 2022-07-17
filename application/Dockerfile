FROM gradle:jdk11
COPY --chown=gradle:gradle . /app
USER gradle
WORKDIR /app
EXPOSE 8080
RUN gradle build
CMD java -jar build/libs/demo-app-springboot-gradle-war-0.0.1-SNAPSHOT.war
