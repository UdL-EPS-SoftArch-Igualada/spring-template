FROM ibm-semeru-runtimes:open-21-jdk-focal

WORKDIR /home/app

COPY ./target/*.jar ./app.jar
COPY ./docker/entrypoint.sh ./entrypoint.sh

EXPOSE 8080
CMD ["./entrypoint.sh"]
