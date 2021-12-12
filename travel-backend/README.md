# travel-backend
Travel Hand Book server side 

This is an all-purpose travel directory, providing essential information and advice for planning any kind of trip anywhere in the world. 
It has top tips from famous travellers, distinguished experts and insiders in the travel industry.

![Alt Text](/static/c1.PNG)

- Home
  - Display home page.
- Destination
  - Display available destinations
    ![Alt Text](/static/C2.PNG)
- Display Destination details
  - ![Alt Text](/static/C3.PNG)
- Add a Review for a destination
  - ![Alt Text](/static/C4.PNG)


# My way of Microservice

An autonoumus software component that is independently upgradeable, replacable and scalable
True up to some extent but not completely due to changing real-time scenarios

```
This is a very small system landscape of cooperating microservices.
The surrounding support services that we will add might look overwhelmingly complex for these few microservices.
But keep in mind that the solutions presented here aim to support a much larger system landscape.

```

![Alt Text](/static/C6.PNG)

![Alt Text](/static/C5.PNG)

There is plan for document complete team formation and managing Microservice application.

Microservices which we would be working is **Destination, Review and Recommend**.
These microservices deals with one type of resources and a composite microservice called **Travel Composite** which aggregates the information from other core service and i think this would be best for **Backend-FOR-Frontend**

- Destination Service
  The **destination** service manages destination information.
  - destId
  - place
  - country
  - latitude
  - longitude
  - info
  - image
- Review Service
  - destId
  - reviewId
  - author
  - subject
  - content
- Recommend
  - destId
  - recommendationId
  - author
  - rate
  - content
- Travel Composite
  The Composite service gets the information from core microservices and presents information about the destination.

  - A Destination information as described in **Destination** service.
  - A list of destination reviews for the specific destination , described in **review** service.
  - A list of travel recommendation for the specific destination, described in **recommend** service.

  _It will be good to add service address attribute in each microservice resources to know which conatiner is responding._

My way of micorservices design is to try to have single responsible services as much possible.

```
    microservice/
    |---TravelCompositeService
    |---DestinationService
    |---ReviewService
    |---RecommendService
```

**_NOTE:_**

It is debatable whether it is good proactice to have **API** in a common module or not.

_To me, it is good practice for microservices that are part of the same delivery organization, that is , same whose release is giverned by same organization.Again From DevOps perspective it is preferabble to build each project in its own build pipeline_

**Sample Project Structure**

```
microservices/
  |---TravelCompositeService
  |---DestinationService
  |---ReviewService
  |---RecommendService
api/
util/
---
---
```

# Thinking Solution Building Block

These Instruction will get you a copy of the project up and running on local machine.
We will develop microservice that conain buisness logic based on Spring Beans and expose REST API using **Spring WEB-FLUX**

> The API will be docuemnted based on **OpenAPI** specification using **springdoc-openapi**

### Prerequisites

What things you need to install the software and how to install them?

It is recommended you have the Chocolatey Package Manager installed for windows
to ease up the setup process. Please install using instructions
[here](https://chocolatey.org/install).

Once you have have that please proceed with rest of the steps:

```
choco install maven
choco install docker-desktop
choco install istioctl
choco install kubernetes-helm
choco install kubernetes-cli
choco install cygwin
```

Let's use **spring-init** tool for easier way of creating microservices.

For each microservice , we will create a Spring boot project that does the following

- Uses **gradle** build tool.
- Generates Java code for Version 8 .
- Packages the project as _Fat Jar_ .
- Brings in dependencies for the **Actutator** and **Web-Flux** .
- Is Based on Spring Latest (V2.5.2)

#### Setting Up multi-project build in gradle

1.  Create a **settings.gradle** file.
2.  Copy the gradle executable files that were generated from one of the projects so we can reuse.

```
 cp -r microservices/destination-service/gradle .
 cp microservices/destination-service/gradlew .
 cp microservices/destination-service/gradlew.bat .
```

3.  We no longer need the **Gradle** executable in each projects. We can remove with below command.

```
find microservices -depth -name "gradle" -exec rm -rfv "{}" \;
find microservices -depth -name "gradlew*" -exec rm -fv "{}" \;

```

4.  Now build the microservice project with one command.

```
./gradlew build

```

java -jar microservices/destination-service/build/libs/\*.jar &

```
Initial developement phase should use **RestTemplate** helper class.
We will replace later with Reactive HTTP client **Webclient** .
```
```

java -jar microservices/destination-composite-service/build/libs/*.jar &
java -jar microservices/destination-service/build/libs/*.jar &
java -jar microservices/recommendation-service/build/libs/*.jar &
java -jar microservices/review-service/build/libs/*.jar &

curl http://localhost:7000/dest-composite/1 -s | jq 

 kill $(jobs -p)

```
