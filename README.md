Gamification Web
==================

## About
Built an application that applies elements of game playing to increase productivity of small development teams.

## Technical Specifications
+ J2E
+ JPA
+ EJB
+ JSF
+ Bootstrap/CSS/JS
+ Glassfish Server
+ PostgresSQL


## Directory Structure 

  ```
 \
 |--EJB/build/classes/
 \
  |--EJB
  \
   |--GeneralRegister.class
   |--PersistenceServiceEJB.class 
  |--MODEL
  \
   |--Project.class
   |--Staff.class
   |--Task.class
  |--UTIL
  \
   |--JPAUtil.class
   
 |--WorkGamefication/src/main/java/
 \
  |--META-INF
  \
   |--persistence.xml
  |--converter
  \
   |--ProjectConverter.java
   |--StaffConverter.java
  |--managedbeans
  \
   |--ProjectManagedBean.java
   |--StaffManagedBean.java
   |--TaskManagedBean.java
  |--model
  \
   |--~~ConexaoDAO.java~~
   
 |--WorkGamefication/WebContent/ 
 \
  |--WEB-INF
  \
   |--lib
   \
    |--all-themes-1.0.10.jar
    |--postgresql-9.1-901.jdbc4.jar
    |--primefaces-6.0.jar
   |--faces-config.xml
   |--web.xml
  |--resources
  \
   |--images
   |--js
   |--lib
  |--template
  \
   |--menu.xhtml
  |--contact.xhtml
  |--listStaff.xhtml
  |--listTask.xhtml
  |--project.xhtml
  |--staff.xhtml
  |--task.xhtml
  
  ```
