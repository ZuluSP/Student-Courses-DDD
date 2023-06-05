# 💻🏢 Java DDD PROJECT:

<img src="https://pluralsight2.imgix.net/paths/images/domain-driven-design-6d10f953a0.png" align="left" width="192px" height="192px"/>
<img align="left" width="0" height="192px" hspace="10"/>

> ⚡ A project to show a little bit my current experience -> 06/2023

## ℹ️ Introduction

The idea of this project is to build a DDD application with microservices using events, and following the SOLID principles.
And a good test case.

Efficiency + clean code.

## ▶️ How To run
This is a project based in gradle:
0. `./gradlew :build --warning-mode all"` to build the project.

1. `./gradlew :test --warning-mode all"` to run the tests of the project.

2. `./gradlew :run --args="mooc_backend api"` to run the server.

3. `./gradlew :run --args="fake"` to run a fake command and see how it works.

4. `./gradlew :run --args="mooc_backend domain-events:mysql:consume"` to run this time
a real event that persists in mysql.


## 🏁 How To Paticipate
Make sure you have installed Java in your pc.
1. Install Java 11: `brew cask install corretto`
2. Set it as your default JVM: `export JAVA_HOME='/Library/Java/JavaVirtualMachines/amazon-corretto-11.jdk/Contents/Home'`
3. Bring up the Docker environment: `make up`.
4. Execute some [Gradle lifecycle tasks](https://docs.gradle.org/current/userguide/java_plugin.html#lifecycle_tasks) in order to check everything is OK:
    1. Create [the project JAR](https://docs.gradle.org/current/userguide/java_plugin.html#sec:jar): `make build`
    2. Run the tests and plugins verification tasks: `make test`
5. Start developing!

## ☝️ How to update dependencies

* Gradle ([releases](https://gradle.org/releases/)): `./gradlew wrapper --gradle-version=WANTED_VERSION --distribution-type=bin`

