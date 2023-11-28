# React Challenge - Integration Java with React

## Run and test project:

	The application is hosted in: https://react-challenge-xwu1.onrender.com/
	

## Build project:
The project needs to be build to run locally or to create the docker container:

```
git clone https://github.com/elvisrrsilva/react-challenge.git
cd react-challenge
mvn clean install
```

## Running project:
In the main path of the project, please run (Before to run it, please start the docker application):

```
docker build -t react-challenge .
docker container run --name react-challenge -p 80:8080 react-challenge
```
When container its running, open your browser and access the url:

```
	http://localhost
```

## Dependecies:

The dependencies below must be installed before project run:

	Docker (https://www.docker.com/products/docker-desktop)
	Java 21 JDK (https://jdk.java.net/21/)
	Maven 3.x (https://maven.apache.org/download.cgi)
	Node 20.x (https://nodejs.org/en/download/)
	Git (https://git-scm.com/downloads)


# Requirements:

## 1. Create a branch into this public repository, with your name and lastname, and push it to the repo https://github.com/sebasworkana/react-challenge.git . Complete challenge and create a PR so that we can review and approve
	
	I created a fork in my repository: https://github.com/elvisrrsilva/react-challenge.git
	And created the Pull Request: 
	
## 2. The main challenge is that you create a Page with the following Style and format. 
## 3. You need to enumerate all Periodic table of the elements on CSS class and make use of it,  matching words in First name and last name “Highlighting” them as in the image.
	
	In questions 2 and 3. We decided to ignore Upper and Lower cases in the Label format.
	
## 4. You should create a class in Java to create the logic of the “Highlighting” feature with reg-ex if possible.

	I created a group of classes in Java using springboot and following patterns like Controller, Service, MVC, etc.

## 5. First, install “react-redux”, then use the useDispatch and useSelector react-redux hooks in the components.

	I did the install of react-redux and the useDispatch and useSelector.
	
## 6. For this challenge use redux-thunk in it. Moreover, use the react-redux hooks to give a better impression and avoid older techniques. Share data among components without using props.

	I used redux-trunk and redux hooks to manage slice and store logic.

## 7. Is mandatory to use linter like ESLINT 
## 8. Create npm scripts to run project and make sure to create a readme with instructions to run project

	The commands to build project locally are:
	
	git clone https://github.com/elvisrrsilva/react-challenge.git
	cd react-challenge
	mvn clean install
	
	You can run executing the Application class directly or by docker.

## 9. Will be valuable if you can create Docker compose file to run all environment (not mandatory)

	I created the Dockerfile and it can be called by:
	
	docker build -t react-challenge .
	docker container run --name react-challenge -p 80:8080 react-challenge
	
	I created the logic to the environments:
	
		* development: Enabled to the developer update and deploy the application
		* homolog: Used to Integration Tests and for test team;
		* production: Environment used after all tests

## 10. Use github pages to host web app and test 

	The application is hosted in: https://react-challenge-xwu1.onrender.com/
	