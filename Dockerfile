FROM openjdk:8

# Adding files
RUN mkdir /opt/appl-poi/
COPY ./target/appl-0.0.2.jar /
COPY ./application.properties /opt/appl-poi/
COPY ./application-dev.properties /opt/appl-poi/

EXPOSE 8080

CMD ["java", "-jar", "appl-0.0.2.jar"]