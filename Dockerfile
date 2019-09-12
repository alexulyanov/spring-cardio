### BUILD image
FROM maven:3-jdk-11 as builder
# create app folder for sources
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
#Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins
#Copy source code
COPY src /build/src
# Build application
RUN mvn package


FROM openjdk:11-slim as runtime
EXPOSE 8080
ENV APP_HOME /app

RUN mkdir $APP_HOME
WORKDIR $APP_HOME

COPY --from=builder /build/target/*.jar app.jar

ENTRYPOINT [ "sh", "-c", "java -jar app.jar" ]
