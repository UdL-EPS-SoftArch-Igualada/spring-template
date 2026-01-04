FROM ibm-semeru-runtimes:open-21-jdk-focal

WORKDIR /home/app

COPY ./target/*.jar ./app.jar
COPY ./docker/entrypoint.sh ./entrypoint.sh

ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8080
CMD ["./entrypoint.sh"]
