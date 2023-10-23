# Projet Spring avec Hibernate et MySQL
Ce projet Spring est une application de démonstration qui utilise Hibernate comme ORM pour interagir avec une base de données MySQL. Il permet de créer une classe dans la base de données à l'aide des technologies Spring Web, JPA et MySQL Driver.

## Configuration Requise:
- JDK 1.8 ou supérieur
- Apache Maven 3.x
- MySQL Server installé localement ou distant
- IDE de votre choix (Eclipse, IntelliJ, etc.)

## Configuration de la Base de Données:
-Créez une base de données MySQL nommée nom_de_votre_base_de_donnees.
-Mettez à jour le fichier src/main/resources/application.properties avec les informations de votre base de données :
`spring.datasource.url=jdbc:mysql://localhost:3306/nom_de_votre_base_de_donnees?useSSL=false
spring.datasource.username=votre_nom_utilisateur
spring.datasource.password=votre_mot_de_passe
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update`

## Lancement de l'Application:
-Clonez ce dépôt sur votre machine locale:
`git clone `

