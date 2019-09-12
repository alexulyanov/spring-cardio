[![Build Status](https://travis-ci.com/alexulyanov/spring-cardio.svg?token=UA72msSYyTpyTjSCRbxX&branch=master)](https://travis-ci.com/alexulyanov/spring-cardio)

Setting up project:
* Download IntelliJ IDEA Community Edition
* In the IntelliJ IDEA, open VCS -> Checkout from Version Control -> Git/GitHub and paste the following link https://github.com/alexulyanov/spring-cardio.git
* Inside /src folder locate CardioApplication class and run in it (Right click -> Run).
* Application will start on http://localhost:8080 

Building and running application in Docker:
* docker build -t <image-tag> 
* docker run -p 8080:8080 <image-tag>

First time it is going to be slow as it download all of the dependencies.