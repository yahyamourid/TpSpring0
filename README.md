# Projet Spring avec Hibernate et MySQL
Ce projet Spring est une application de démonstration qui utilise Hibernate comme ORM pour interagir avec une base de données MySQL. Il permet de créer une classe dans la base de données à l'aide des technologies Spring Web, JPA et MySQL Driver.


## Configuration Requise:
- JDK 1.8 ou supérieur
- Apache Maven 3.x
- MySQL Server installé localement ou distant
- IDE de votre choix (Eclipse, IntelliJ, etc.)

## Configuration de la Base de Données:
- Créez une base de données MySQL nommée nom_de_votre_base_de_donnees.
- Mettez à jour le fichier src/main/resources/application.properties avec les informations de votre base de données :
```
spring.datasource.url=jdbc:mysql://localhost:3306/nom_de_votre_base_de_donnees?useSSL=false
spring.datasource.username=votre_nom_utilisateur
spring.datasource.password=votre_mot_de_passe
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```

## Lancement de l'Application:
- Clonez ce dépôt sur votre machine locale:
```
git clone https://github.com/yahyamourid/TpSpring0.git
```
- Ouvrez le projet dans votre IDE, compilez et exécutez l'application.
- A partir de votre Terminal:
```
 mvn clean install
```
Cette commande va télécharger les dépendances, compiler votre code et créer un fichier JAR exécutable dans le dossier `target`.

```
 mvn spring-boot:run 
```
  pour lancer le projet.

## Le Test des services:
- La methode `findAll()` qui permet de récupérer tous les étudiants dans la base de données:
  ```
 @GetMapping("/all")
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
  ```
![image](https://github.com/yahyamourid/TpSpring0/assets/128039351/d92b13a2-89e3-4307-ba85-eccfbbae8290)



