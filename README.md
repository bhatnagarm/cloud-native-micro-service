# Minimlist Microservice in JDK 12

## Introduction
JDK as a language has accelerated in features releases in the last couple of years. This has brought the language at par with some of the most modern languages like Golang, NodeJS etc. These changes like Lambdas, Project Jigsaw, jshell are amazing advancements in Java which has not made its way to the people using these at all. I'm a Java developer who has been working with the language from the days it was under Sun Technologies. I have seen this language coming from the days where Generics were celebrated as a great wins to now where people are scared of Project Jigsaw and prefer to keep away from it.

Working on the language and in coorporate I have seen companies either not ramping up fast enough to some just giving up on the language all together. Frankly I do not blame them doing this. We have come far from the days they had to invest in upgrading technologies once in a few years to once in a few months. And developers before having a few years to understanding new concepts have literally days to understand changes.

This made me start looking at writing something that is a easy structure in Java and help people take advantage of microservices and solve business issue they are dealing with instead of going into neuences of the language.

## Image Size
This is a very debated concept for Microservices images. Is it ok to treat docker images as virtual machines? I have heard a lot of people saying that doing the same reduce complexity. But just doing this also introduce a lot of other problems. If I create a big image it can take away the benefit of ephemerality of the container. If it takes my image minutes to come up then its no longer cheap to shutdown and spown them. Also do you know what this image has? Will you keep a server administrator to configure base images and give a user to your developers to execute programs. What if I say let the developers do whatever they need to do in the image and don't add tools like ssh wget etc which can hurt if there is a issue. You can also do away with user management. This reduces your blast radius to the minimul. I started with designing my own Linux distribution based on BusyBox. Unfortunately Java after version 8 requires a lot of dependencies which are not in default toolset so I had to add it. Fortunately for you I have opened the resultant base image so you an use it.
Issues I faced in reducing image size:
* JDK install uses a lot of packages which can be best discribed as clutter.
* There is no documentation on which Java module uses which libraries below
* Java 11 is using glib based libraries and does not work on musl based OSes (Alpine for example).

With JDK 13 I'm expecting to have a musl based JDK. For the C based libraries I'm assuming that all the JDK modules are required (which is not true but they are very small so why not).

## Use of Modularity
With JDK 9 Project Jigsaw introduced modularity in JDK (similar to Unix). This is a great feature in as reduce memory size of JRE drastically. But again for reasons above developers have not used this to their favour. We are use to modularity thanks to build tools like Maven and Gradle. In this example, I have made sure that my structure help modularize code and reduce repeling effect of chnages. I tried to keep the structure similar to Maven modules.

## Use of Pipeline Design Pattern
I have started looking into pipelines approch as it is easier for me to reduce branching thus increase code quality. Each module will have a testclass which will test all the stages in this class. This will also help parallelize these steps if more then one request are sent.
Also will have seperate classes for calling external services (Note ForMyself: planning to use openFeign). These classes should not have bussiness logic.
(idea introduced by [Gary Bernhardt] https://www.youtube.com/watch?v=yTkzNHF6rMs)

## Not a Framework
This is just a suggested approach to develop cloud native applications. I have tried to stay away from trying to introduce utilities or features that can influence developers. Java has a lot of utilities to do this for users.

## Java who decides
In todays DevOPS model if someone breaks code he the person who is responsible to fix it. But we have a lot of traditional structures in which one person is never the responsible for development of applications. You hava base JDK image installed by either the admin or in somecases downloaded from outside.

## References
[Google Cloud Architecture Best Practices] https://cloud.google.com/solutions/best-practices-for-building-containers
[Spring Boot Micro Applications] https://github.com/dsyer/spring-boot-micro-apps
[Container Memory] https://fabiokung.com/2014/03/13/memory-inside-linux-containers/
[JVM for reduced memory foot print] https://www.eclipse.org/openj9/oj9_performance.html
https://blog.codefx.org/java/java-9-migration-guide/
[Funtional Programming pattern] http://qrman.github.io/posts/2017/02/09/pipeline-pattern-plumber-quest