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

- La methode `save()` qui permet d'ajouter un nouveau etudiant:
```
@PostMapping("/save")
	public void save(@RequestBody Student student){
		studentRepository.save(student);
	}
```
![image](https://github.com/yahyamourid/TpSpring0/assets/128039351/1b4250b2-2846-4d7a-8d4a-c610edb1f8dc)

- La methode `findById()`  qui permet de récupérer un étudiant depuis son id:
```
@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable int id){
		Student student = studentRepository.findById(id);
		if (student != null)
			return ResponseEntity.ok().body(student);
		else
			return ResponseEntity.notFound().build();
	}
```
![image](https://github.com/yahyamourid/TpSpring0/assets/128039351/0d6c85b2-5801-449d-aa5e-6d415021e00f)

- La methode `update()` qui permet de modifier les donnees d'un etudiant:
```
@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student upStudent){
		Student student = studentRepository.findById(id);
		if (student != null) {
			student.setNom(upStudent.getNom());
			student.setPrenom(upStudent.getPrenom());
			student.setDateNaissance(upStudent.getDateNaissance());
			studentRepository.save(student);
			return ResponseEntity.ok().body(student);
		} else
			return  ResponseEntity.notFound().build();

	}
```
![image](https://github.com/yahyamourid/TpSpring0/assets/128039351/d0094eb3-acbd-4bbc-aaef-1eb5e4031c5a)

- La methode `delete()` qui permet de supprimer un etudiant depuis son id:
```
@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id){
		Student student = studentRepository.findById(id);
		studentRepository.delete(student);
	}
```
![image](https://github.com/yahyamourid/TpSpring0/assets/128039351/4f272dbf-25df-4baf-aa8d-476ede46406e)







