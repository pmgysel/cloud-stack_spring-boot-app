# Containerize a simple SpringBoot app

Run app locally:
```shell
$ git clone https://github.com/pmgysel/cloud-stack_spring-boot-app.git
$ cd cloud-stack_spring-boot-app
$ mvn clean install
```

Build Docker image:
```shell
$ docker build -t <Your Docker ID>/<Repository Name>:<tag> .
```

Start Docker container locally:
```shell
$ docker run -p 8080:8080 <Your Docker ID>/<Repository Name>:<tag>
```

Test running container locally:
In your favorite web browser, go to [http://localhost:8080/api/ping](http://localhost:8080/api/ping)

Push Docker image to Docker hub:
```shell
$ docker push <Your Docker ID>/<Repository Name>:<tag>
```