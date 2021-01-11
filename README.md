# Backend de CashOnline

_Esta app expone una API REST de Usuarios (Users) y Prestamos (Loans)_

## Comenzando ⚙️

_Primero nos descargamos el proyecto de manera local._

```
git clone https://github.com/SebastianVelo/cashonline-api.git
```

## Deploy 📦

En Windows, abrimos el cmd dentro del proyecto

* _Luego nos dirigimos a la carpeta target_
```
cd target
```
* _Ejecutamos el .jar dentro de la carpeta_
```
java -jar CashOnline-0.0.1-SNAPSHOT.jar
```

## 🛠️

* [Java 11](https://www.oracle.com/ar/java/technologies/javase-jdk11-downloads.html)  
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spring](https://spring.io/) - Framework
* [H2](https://www.h2database.com/html/main.html) - Base de Datos

## Deploy 📦

En Windows, abrimos el cmd dentro del proyecto

* _Luego nos dirigimos a la carpeta target_
```
cd target
```
* _Ejecutamos el .jar dentro de la carpeta_
```
java -jar CashOnline-0.0.1-SNAPSHOT.jar
```

## Insomnia/Postman proyect 🚀

En esta ubicación se podrá encontrar el archivo .JSON que se podrá importar en INSOMNIA y POSTMAN para probar la API

```
cashonline-api/src/main/resources/CashOnline API.json
```

## API 🚀

### USER

**PUT**

* **INSERT**


```
http://localhost:8080/cashonline/user
```
```
{
			"email": "Pepe.Argento@gmail.com",
			"info": {
				"name": "Pepe",
				"lastname": "Argento"
			}
}
```

* **INSERT ALL**

```
http://localhost:8080/cashonline/user/all
```
```
[
	{
		"info": {
			"name": "Raquela",
			"lastname": "Ezar"
		},
		"email": "Raquela.Ezar@gmail.com"
	},
	{
		"info": {
			"name": "Paola",
			"lastname": "Fillbert"
		},
		"email": "Paola.Fillbert@gmail.com"
	},
	{
		"info": {
			"name": "Ardenia",
			"lastname": "Loleta"
		},
		"email": "Ardenia.Loleta@gmail.com"
	},
	{
		"info": {
			"name": "Elbertina",
			"lastname": "Carvey"
		},
		"email": "Elbertina.Carvey@gmail.com"
	}
]
```

**DELETE**

* **DELETE**

```
http://localhost:8080/cashonline/user/15
```

**GET**

* **GETBYID**

```
http://localhost:8080/cashonline/user/1
```

* **GETBYEMAIL**

```
http://localhost:8080/cashonline/user/email/Gloria.Curren@gmail.com
```

### LOAN

**PUT**

* **INSERT**


```
http://localhost:8080/cashonline/loan
```
```
{
			"idUser": 29,
			"total": 200.40
}
```

* **INSERT ALL**

```
http://localhost:8080/cashonline/loan/all
```
```
[
  {
		"idUser": 41,
		"total": 1016.19
	},
	{
		"idUser": 14,
		"total": 2289.33
	},
	{
		"idUser": 57,
		"total": 2168.1
	},
	{
		"idUser": 17,
		"total": 2104.73
	},
	{
		"idUser": 23,
		"total": 2520.57
	},
	{
		"idUser": 13,
		"total": 3205.45
	},
	{
		"idUser": 51,
		"total": 6950.96
	}
]
```

**DELETE**

* **DELETE**

```
http://localhost:8080/cashonline/loan/43
```

**GET**

* **GETBYID**

```
http://localhost:8080/cashonline/loan/47
```

* **GETALL** (all/{page}/{size})

```
http://localhost:8080/cashonline/loan/all/0/15
```

* **GETBYUSER** (all/{idUser}/{page}/{size})

```
http://localhost:8080/cashonline/loan/user/5/0/15
```

