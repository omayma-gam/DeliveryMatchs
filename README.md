# 🚚 DeliveryMatchs

DeliveryMatchs est une plateforme web collaborative qui met en relation les conducteurs disposant de place libre dans leur véhicule et les expéditeurs souhaitant envoyer des colis à moindre coût. Elle optimise les trajets pour un transport plus économique, écologique et intelligent.

## 📌 Table des matières

✨ Fonctionnalités

👥 Rôles & Parcours Utilisateurs

🛠️ Technologies Utilisées

📊 Dashboard Administrateur

🚀 Installation & Démarrage

**✨ Fonctionnalités**
Authentification et inscription sécurisées

Création et gestion des annonces de trajets

Demandes de transport de colis avec validation

Système de notification (acceptation, refus, état de la demande)

Suivi des trajets, demandes et livraisons

Historique des échanges pour chaque utilisateur

Évaluations croisées entre conducteurs et expéditeurs

Interface d’administration avec contrôle global

## 👥 Rôles & Parcours Utilisateurs

**_👤 Utilisateur_**
Inscription avec informations personnelles (nom, email, mot de passe)

Connexion/Déconnexion

Modification du profil

Consultation de l’historique et des notifications

**_🚗 Conducteur_**
Création d’annonces (lieu, étapes, destination, capacité, date…)

Gestion des demandes reçues (accepter/refuser)

Suivi des trajets effectués

Évaluation des expéditeurs

**_📦 Expéditeur_**
Recherche d’annonces selon critères (destination, date, dimensions)

Envoi de demandes de transport avec détails colis

Suivi des demandes envoyées

Évaluation des conducteurs après réception

**_🛡️ Administrateur_**
Interface de gestion centralisée (utilisateurs, annonces, demandes)

Suspension et validation des comptes

Statistiques en temps réel (trajets, utilisateurs actifs, taux de succès)

Modification ou suppression de contenu

## 🛠️ Technologies Utilisées

Couche	Technologies
**_Frontend_**	Angular 16+, Angular Material, Tailwind CSS
**_Backend**_	Spring Boot, Spring Data JPA, Spring Security
**_Base de données_**	MySQL
**_Documentation_**	Swagger, Postman Collection
**_Tests_**	JUnit, Postman Tests
**_Conteneurisation_**	Docker, Docker Compose
**_Visualisation_**	Chart.js (graphiques pour l'admin)

📊 Dashboard Administrateur
📈 Nombre total d’annonces créées

✅ Taux d’acceptation des demandes

👥 Nombre d’utilisateurs actifs

🗂️ Gestion complète des utilisateurs, annonces et demandes

📊 Statistiques en temps réel avec graphiques interactifs
--------------------------------------------------------------------------------------
**_swagger_**
http://localhost:8086/swagger-ui/index.html#/
------------------------------------------------------------------------------------

## UML

**_Diagramme de Classe_**
![Diagramme](Conception_Uml/Class%20jrb.png)
**_Diagramme de cas d'utilisation_**
![Diagramme](Conception_Uml/Cas%20d'utilisation%20jrb.png)
**_Diagramme de séquence_**
![Diagramme](Conception_Uml/séquence%20Admin%20jrb.png)
![Diagramme](Conception_Uml/séquence%20Expediteur%20JRB.png)
![Diagramme](Conception_Uml/séquence%20Utilisateur%20jrb.png)
