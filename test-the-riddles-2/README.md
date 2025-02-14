<br />
<div align="center">
  <a href="https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-Tomocza">
    <img src="https://raw.githubusercontent.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-Tomocza/development/frontend/src/assets/images/logo_big.png" alt="Reptile Riddles project logo">
  </a>
</div>
<h3 align="center">Test the Riddles</h3>
<p align="left"></p>

## About The SUT

Reptile Riddles is a dynamic, full-stack web application designed to ignite the fun in learning through interactive quizzes. Users like you can:

- Become a Quiz Master: Craft compelling quizzes with ease. Add questions, set difficulty levels, and choose from various question types, including multiple choice, true/false, and open-ended. Edit and refine your quizzes anytime to keep them fresh and engaging.
- Challenge and Connect: Share your quizzes with friends, classmates, or colleagues. Invite them to test their knowledge. Witness your creativity come alive as others answer your questions and strive for the top spot.

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->


## Built with

### Frontend:

[![React]](https://react.dev/)
[![Tailwind]](https://tailwindcss.com/)
[![JavaScript]](https://www.javascript.com/)

### Backend: <br/>
[![Java]](https://www.java.com/en/)
[![SpringBoot]](https://spring.io/projects/spring-boot)
[![psql]](https://www.postgresql.org/)

###  Test Automation:
[![Java]](https://www.java.com/en/)
[![Selenium]](https://www.selenium.dev/)
[![JUnit5]](https://junit.org/junit5/)

## Usage

This application is a dockerized monolith.
Once you have the docker CLI installed, running the project will only take one command.

1. Ensure you have [Docker CLI][Docker-link] installed
2. Clone the repository from [here][reptile-riddles-url]
3. Navigate to the project root
4. Run the application:
```shell
$ docker compose up
```
5. Once the application is running, you can access the frontend at [http://localhost:3000/](http://localhost:3000/)
6. Stop the application:
```shell
$ docker compose down
```
7. If you encounter issues, check the Docker logs:
```shell
$ docker compose logs
```

## About the Automated Tests

This repository contains automated UI tests for Reptile Riddles using Selenium WebDriver. The project is built with Maven and is designed to be easily configurable and extendable.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Java Development Kit (JDK)][oracle-url]: Version 22 or higher.
- [Maven][Maven-url]: Version 4.0.0 or higher.
- WebDriver Executables: [Chrome Driver][chrome-driver-url] executables are installed.
- The application is up and running

## Setup

1. Clone repository:
    ```bash 
    git clone git@github.com:CodecoolGlobal/test-the-riddles-2-general-qutasi.git
    ```
2. Navigate to the project root
3. Install dependencies:
    ```bash
    mvn clean install
    ```

4. Running tests:
   ```bash
   mvn test
   ```


### Contributors:
- [Fabók Norbert](https://github.com/faboknorbert)
- [Kutasi Bálint](https://github.com/qutasi)


## User stories

### Here are the primary user stories that outline the goals of the application.
These user stories not only define the core functionalities of the application but also guide the scope of our test coverage. Each story corresponds to a specific set of test scenarios, ensuring that the application is thoroughly tested to meet user needs and maintain quality standards.
#### New User Features
- [ ] **1. As a new user**, I want to choose my own username and password during registration so that I can personalize my login credentials.
- [ ] **2. As a user**, I want an option to stay logged in, so that I don’t have to enter my credentials every time.

#### Quiz Master Features
- [ ] **3. As a quiz master**, I want to create quizzes so that I can invite others to play.
- [ ] **4. As a quiz master**, I want to select one correct answer for each question so that it is clear if a player got it right or not.
- [ ] **5. As a quiz master**, I want to add more answer options to each question so that I can create a versatile quiz.
- [ ] **6. As a quiz master**, I want to set the time players have to answer each question so that I can configure the difficulty of the questions.
- [ ] **7. As a quiz master**, I want to make modifications to quizzes I had created so that I can make my quizzes better.
- [ ] **8. As a quiz master**, I want to delete a quiz so that I can keep my dashboard clean.
- [ ] **9. As a quiz master**, I want to use my fellow quiz masters' quizzes so that I have more options to organize games.
- [ ] **10. As a quiz master**, I want to open a lobby for a quiz so that players can see what is about to be played and they can join in.
- [ ] **11. As a quiz master**, I want to see the results when the game ends so that I can reward the winner.

#### Player Features
- [ ] **12. As a player**, I want to play quizzes so that I can compete against others.
- [ ] **13. As a player**, I want to see what games accept players so that I can choose which one to join.

<p align="right">(<a href="#about-the-project">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[Tailwind]: https://img.shields.io/badge/Tailwind-000000?style=for-the-badge&logo=TailwindCSS

[JavaScript]: https://img.shields.io/badge/JavaScript-000000?style=for-the-badge&logo=JavaScript

[React]: https://img.shields.io/badge/React-000000?style=for-the-badge&logo=React

[Java]: https://img.shields.io/badge/Java-000000?style=for-the-badge&logo=openjdk

[SpringBoot]: https://img.shields.io/badge/SpringBoot-000000?style=for-the-badge&logo=SpringBoot

[psql]: https://img.shields.io/badge/postgresql-000000?style=for-the-badge&logo=postgresql

[JUnit5]: https://img.shields.io/badge/JUnit5-000000?style=for-the-badge&logo=junit5

[Selenium]: https://img.shields.io/badge/Selenium-000000?style=for-the-badge&logo=selenium

[oracle-url]: https://www.oracle.com/java/technologies/downloads/?er=221886

[Docker-link]: https://docs.docker.com/get-docker/

[reptile-riddles-url]: https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-Tomocza

[Maven-url]: https://maven.apache.org/

[chrome-driver-url]: https://developer.chrome.com/docs/chromedriver/downloads
