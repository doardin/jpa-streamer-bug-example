FROM amazoncorretto:17-alpine

WORKDIR /app

COPY .mvn/ ./.mvn

COPY mvnw pom.xml ./

RUN mkdir /opt/app && mkdir ./src && ./mvnw clean

COPY src ./src

EXPOSE 9150

ENTRYPOINT [ "./mvnw", "spring-boot:run" ]