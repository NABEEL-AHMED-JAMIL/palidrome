# palidrome
Play with String and StringUtils Class  ====> Ok
<div class="table"><a name="d0e3811"></a><p class="title"><b>Table&nbsp;6.1.&nbsp;Supported keywords for query methods</b></p><div class="table-contents"><table summary="Supported keywords for query methods" style="border-collapse: collapse;border-top: 0.5pt solid ; border-bottom: 0.5pt solid ; border-left: 0.5pt solid ; border-right: 0.5pt solid ; "><colgroup><col><col><col></colgroup><thead><tr><th style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; ">Keyword</th><th style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; ">Sample</th><th style="border-bottom: 0.5pt solid ; ">Logical result</th></tr></thead><tbody><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">GreaterThan</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByAgeGreaterThan(int
age)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"age" : {"$gt" : age}}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">LessThan</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByAgeLessThan(int
age)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"age" : {"$lt" : age}}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">Between</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByAgeBetween(int from, int
to)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"age" : {"$gt" : from, "$lt" : to}}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">IsNotNull</code>,
<code class="literal">NotNull</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByFirstnameNotNull()</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"age" : {"$ne" : null}}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">IsNull</code>,
<code class="literal">Null</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByFirstnameNull()</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"age" : null}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">Like</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByFirstnameLike(String
name)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"age" : age}</code> ( <code class="varname">age</code> as
regex)</td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">Regex</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByFirstnameRegex(String
firstname)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"firstname" : {"$regex" : firstname
}}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; ">(No keyword)</td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByFirstname(String
name)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"age" : name}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">Not</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByFirstnameNot(String
name)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"age" : {"$ne" : name}}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">Near</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByLocationNear(Point
point)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"location" : {"$near" : [x,y]}}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">Within</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByLocationWithin(Circle
circle)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"location" : {"$within" : {"$center" : [ [x, y],
distance]}}}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">Within</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="methodname">findByLocationWithin(Box
box)</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"location" : {"$within" : {"$box" : [ [x1, y1],
x2, y2]}}}True</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">IsTrue</code>,
<code class="literal">True</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="code">findByActiveIsTrue()</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"active" : true}</code></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="literal">IsFalse</code>,
<code class="literal">False</code></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><code class="code">findByActiveIsFalse()</code></td><td style="border-bottom: 0.5pt solid ; "><code class="code">{"active" : false}</code></td></tr><tr><td style="border-right: 0.5pt solid ; "><code class="literal">Exists</code></td><td style="border-right: 0.5pt solid ; "><code class="methodname">findByLocationExists(boolean
exists)</code></td><td style=""><code class="code">{"location" : {"$exists" : exists }}</code></td></tr></tbody></table></div></div>


```
Docker run on line so we need to install the docker tool for window
Docker is a software which provides centralized platform to execute your application.(https://www.youtube.com/watch?v=lcQfQRDAMpQ)
It wraps software components into a complete standardized unit which contains everything require to run.
Whether it is code, runtime environment, tools or libraries.
It guarantees that the software will always run as expected.
------------------------------------------------------------------
Create the (DockerFile) in side the project
1)Docker image create method
	1) From image name that you want to import in the image(openjdk,)
		From openjdk:8
	2) ADD this is used to add the jar
		ADD target/docker-spring-boot.jar docker-spring-boot.jar
	3 Expose mean this container run on the port so we used as
		Expose 8085
	4)Run command "Enterypont" tell the docker to run this jar
		ENTERYPOINT ["java", "-jar", "docker-spring-boot.jar"]
---------------------------------------------------------------------
Know before we start to deploy the images on the container we need to now docker install or not
1) docker -v (show the current version of docker)
2) deploy a jar into image so we need to build image(these image run on any mac)
	docker build -f DockerFile -t docker-spring-boot .
3) check the image create or not 
	docker images
4) run the images
	docker run -p 8085:8085 docker-spring-boot(this is the image name)
5) stop container
	ctrl-c (it stop the container)
6) ping Ip address my Ip address are (192.168.99.100) on your computer console
7) after that open your brower and add the following line "http://192.168.99.100:8085/" this "8085" my port which run my application
8) Delete containner and Image in Docker useing these command
	1) remove the image ----> docker rmi  <IMAGE ID>
	2) docker rm  <CONTAINER ID> ---> remove the container
	3) docker stope <CONTAINER ID> ---> stop the container 
To list all containers on your system using ps option, but ps will show only running containers.
So to view all containers use -a parameter with ps.
If you want to remove all docker containers. You can use simply following commands.
The first command will stop all running docker containers and the second command will delete them.
	1) Stop All Containers # docker stop $(docker ps -a -q)
	2) Remove All Containers # docker rm $(docker ps -a -q)
	3) Remove All images from docker # Delete all images docker rmi $(docker images -q)
--------------------------------------------------------------------
FROM openjdk:8
EXPOSE 8085
ADD /target/token_test-0.0.1-SNAPSHOT.jar token_test-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","token_test-0.0.1-SNAPSHOT.jar"]
--------------------------------------------------------------------
```
