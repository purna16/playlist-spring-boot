Requirements:
1. Java jdk and jre to run java - openjdk11 (sudo apt install default-jdk)
2. Postgres - refer [link](https://www.digitalocean.com/community/tutorials/how-to-install-postgresql-on-ubuntu-20-04-quickstart)
3. Install maven (sudo apt install maven)
4. Install Eclipse (optional)

<br/>

Steps to run backend:
1. Clone the repository
2. Create a database in postgres
3. Set db username and password as candidate:candidate: 
4. Create database playlist
5. Change parameters in src/main/resources/application.properties to configure postgres
    1. spring.datasource.url
    2. spring.datasource.username
    3. spring.datasource.password

6. Run using command "mvn spring-boot:run"
7. OR Run using eclipse
    1. Import in eclipse as an existing maven project
    2. Run PlaylistApplication.java as a Java Application.
# playlist-spring-boot
