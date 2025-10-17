TP2-DAR2025 – Sockets en mode connecté TCP : E/R de CC & objets

Informations sur le projet

Auteur : Hsan Khecharem

Filière : Licence en Sciences de l’Informatique

Spécialité : Génie Logiciel et Systèmes d’Information

Faculté : Faculté des Sciences de Sfax

Projet : Client/Serveur – Échange de chaînes de caractères et d’objets

Description du TP

Ce TP vise à approfondir les connaissances en développement d’applications réparties en Java utilisant des sockets TCP. Il consiste à étendre l’application Client/Serveur pour :
Permettre l’échange de chaînes de caractères représentant des opérations arithmétiques complètes entre le client et le serveur.
Implémenter l’échange d’objets sérialisables contenant les informations nécessaires aux opérations.
L’objectif est de comprendre la gestion des flux de données, la communication bidirectionnelle, la validation côté client et serveur, ainsi que l’utilisation des flux d’objets pour transmettre des données complexes.

📂 Structure du repository

main/ : README général

Activité_2_1/ : Échange de chaînes de caractères entre client et serveur, validation des opérateurs et format

Activité_2_2/ : Échange d’objets sérialisables pour effectuer des calculs avec gestion des erreurs

💻 Environnement

Java JDK 1.8 ou supérieur

IDE : Eclipse

📝 Description générale des activités

Activité 2-1 : Échange de chaînes de caractères (CC)

Le client envoie une opération complète (ex : 12 + 5) au serveur

Le serveur valide la syntaxe et l’opérateur, effectue le calcul et renvoie le résultat

Gestion des erreurs : opérateur invalide, format incorrect, division par zéro

Communication bidirectionnelle via TCP en utilisant BufferedReader et PrintWriter

Affichage côté serveur des opérations reçues et des résultats calculés

Activité 2-2 : Échange d’objets

Création de la classe Operation implémentant Serializable

Le client crée un objet Operation contenant les opérandes et l’opérateur, puis l’envoie au serveur

Le serveur reçoit l’objet, effectue le calcul et renvoie le résultat ou un message d’erreur

Validation stricte des opérateurs et gestion des erreurs (division par zéro, opérateur non reconnu)

Communication bidirectionnelle via ObjectInputStream et ObjectOutputStream

Le client affiche correctement le résultat ou le message d’erreur

🛠️ Fonctionnalités clés

Transmission fiable de chaînes de caractères et d’objets via TCP

Validation côté client et serveur des opérateurs et du format des opérations

Gestion des erreurs : division par zéro, opérateur invalide, format incorrect

Communication bidirectionnelle structurée

Fermeture correcte des flux et des sockets pour libérer les ressources

📌 Résultats attendus

Le serveur affiche les connexions et les calculs effectués

Le client reçoit et affiche correctement le résultat ou le message d’erreur

Les quatre opérations (addition, soustraction, multiplication, division) fonctionnent correctement

L’application illustre l’utilisation des flux d’objets pour transmettre des données complexes dans un contexte Client/Serveur
