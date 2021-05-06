FROM openjdk:8
COPY ./src /src/java
WORKDIR /src/java
RUN [ "javac", "App.java" ]
ENTRYPOINT [ "java", "App" ]
ENV customVar = "This is the Sample."