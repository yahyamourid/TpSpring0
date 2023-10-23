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
<img width="960" alt="all" src="https://github.com/yahyamourid/TpSpring0/assets/128039351/04ebf7bc-0671-4c6d-a4fa-ee2da846bff9">

- La methode `save()` qui permet d'ajouter un nouveau etudiant:
```
@PostMapping("/save")
	public void save(@RequestBody Student student){
		studentRepository.save(student);
	}
```
<img width="960" alt="save" src="https://github.com/yahyamourid/TpSpring0/assets/128039351/54963ce9-478a-45ba-aa3f-45c24655082d">

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
<img width="960" alt="getid" src="https://github.com/yahyamourid/TpSpring0/assets/128039351/39d336cb-14e4-4c51-8775-70e9c9cdcc2e">


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
<img width="960" alt="update" src="https://github.com/yahyamourid/TpSpring0/assets/128039351/6da8f1bc-8322-4dbb-bfd1-3a0864908db3">


- La methode `delete()` qui permet de supprimer un etudiant depuis son id:
```
@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id){
		Student student = studentRepository.findById(id);
		studentRepository.delete(student);
	}
```
<img width="960" alt="delete" src="https://github.com/yahyamourid/TpSpring0/assets/128039351/54929a10-25d0-4afd-9d91-5f3cc176f6c5">







