NUTRISCORE
__________

L'application se présente sous la forme d'une fenêtre contenant une barre de défilement (slider) 
dont la valeur (A à E) est mise à jour automatiquement selon une valeur aléatoire récupérée via une requête HTTP sur un site distant.
Cette opération est répétée de façon périodique, en continu jusqu'à l'arrêt du programme (fermeture de la fenêtre).


1. Exécution:

	- L'application peut être démarrée en exécutant l'archive java "nutriscore.jar".
	- Il est également possible de lancer l'application en ligne de commande en se placant dans le répertoire du fichier : 
		>java -jar ./nutriscore.jar


2. Requête de nombre aléatoire:

	Afin de pouvoir mettre à jour la valeur du slider, une requête HTTP est effectuée sur le site https://api.random.org
	Une clé d'API doit être au préalable récupérée sur le site pour être passée en paramètre de la requête
		URL: https://api.random.org/json-rpc/2/invoke
		Verbe HTTP: POST
		Méthode d'API: "generateIntegers"
		Version d'API: 2.0
		
	La configuration actuelle demande un unique nombre entier aléatoire compris entre 0 et 4 
	afin de pouvoir mettre à jour le slider selon les correspondances suivantes:
		0 => A
		1 => B
		2 => C
		3 => D
		4 => E
	
	
3. Tâche périodique (timer):
	
	Une requête est effectuée toutes les 10 secondes suivant le paramétrage actuel de l'application.
	
	
4. Classes principales de l'application:
	
	Nutriscore.java:
		- Construction de l'IHM
		- Lancement du timer
 
	TimerActionListener.java:
		- Construction et paramétrage de la requête HTTP
		- Exécution de la requête
		
	TimeActionListenerTest.java:
		- Test de l'exécution de la requête HTTP