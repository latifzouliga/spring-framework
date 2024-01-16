# Baseimage /it has to be in any dockerfile

# it already include operating system
FROM openjdk:17-jdk

# we need to run mvn clean install to generate the ./target file and then copy .jar file
# create a /usr/app/ folder and copy my applicatio to it
COPY ./target/Spring-24-Docker-0.0.1-SNAPSHOT.jar /usr/app/

# cd to /usr/app/
WORKDIR /usr/app/

# will provide executable application when container starts the run
# run
#CMD ["java","-jar","Spring-24-Docker-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java","-jar","Spring-24-Docker-0.0.1-SNAPSHOT.jar"]

