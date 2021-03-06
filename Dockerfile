FROM openjdk:11

RUN apt-get update && apt-get install -y maven
COPY . /project
RUN  cd /project && mvn package

#run the spring boot application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dblabla", "-jar","/project/target/tour-planing-0.0.1-SNAPSHOT.war"]