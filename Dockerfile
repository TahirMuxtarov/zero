FROM alpine
RUN apk add --no-cache openjdk11
COPY build/libs/OneToManyTest-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar","/app/OneToManyTest-0.0.1-SNAPSHOT.jar"]