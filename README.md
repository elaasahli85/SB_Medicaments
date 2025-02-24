# Spring Boot Application - Les Comptoirs

## Description
Ce projet est une application Spring Boot permettant la gestion des produits ainsi que des statistiques de vente. Elle utilise des entités JPA pour interagir avec une base de données, des services REST exposés via des contrôleurs, et des dépôts pour accéder aux données.

## Fonctionnalités
- Gestion des produits, clients, commandes...
- Suivi des statistiques de ventes par catégorie.
- Exposition des données via des services REST en JSON et XML.
- Utilisation de Spring Data JPA pour accéder et manipuler les données.

## Technologies Utilisées
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Lombok**

## Structure du Code
### Couche "Accès aux données"
#### Entités
Les entités représentent les tables de base de données et leur mapping avec JPA.

- ex:  [Produit](src/main/java/comptoirs/entity/Produit.java): Représente les produits.

#### Dépôts (Repositories)
Les dépôts gèrent l'accès aux entités via Spring Data JPA.

- ex : [ProduitRepository](src/main/java/comptoirs/dao/ProduitRepository.java): Interface gérant les requêtes sur les entités `Produit`.

### Couche "Services métier"

Cette couche définit les services métier transactionnels qui utilisent la couche "Accès aux données" pour effectuer des opérations complexes.

- ex : [CommandeService](src/main/java/comptoirs/service/CommandeService.java): Gère les bons de commandes en assurant le respects des règles métier.


### Couche "Web"
#### Contrôleurs REST
Les contrôleurs exposent les points d'entrée REST pour interagir avec l'application.

- [CommandeController](src/main/java/comptoirs/rest/CommandeController.java): fournit une API web permettant l'accès au service métier [CommandeService](src/main/java/comptoirs/service/CommandeService.java).

## Documentation
Consultez la documentation officielle pour mieux comprendre les technologies utilisées dans ce projet :

- **[Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)**: Guide sur l'utilisation des plugins Maven pour Spring Boot.
- **[Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)**: Documentation sur l'intégration de JPA avec Spring Boot.
- **[Spring Web](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)**: Développement et exposition d'API avec Spring Web.

## Guides Utiles
Voici des tutoriels pour démarrer avec les technologies Spring utilisées dans ce projet :

- **[Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)**: Accès aux données avec Spring Data JPA.
- **[Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)**: Création d'un service web RESTful avec Spring Boot.
