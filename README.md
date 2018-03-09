[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2f5e9b234d9b4cbd8669629c299990ad)](https://www.codacy.com/app/jelabra/InciManager_e4b?utm_source=github.com&utm_medium=referral&utm_content=Arquisoft/InciManager_e4b&utm_campaign=badger)
[![Build Status](https://travis-ci.org/Arquisoft/InciManager_e4b.svg?branch=master)](https://travis-ci.org/Arquisoft/InciManager_e4b)
[![codecov](https://codecov.io/gh/Arquisoft/InciManager_e4b/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciManager_e4b)

# InciManager_e4b
InciManager e4b

# Autores
- Sergio Muñiz Rosas (UO245346)
- Darío Alonso Díaz (UO237089)
- Francisco Manuel Mendoza Soto (UO251129)
- Victor David Acebes Caballo (UO251117)

# Descripción
Módulo encargado de tramitar las incidencias que serán enviadas por los agentes

# Ejecución

### Descargar kafka y primeras instrucciones:
https://www.apache.org/dyn/closer.cgi?path=/kafka/1.0.1/kafka_2.11-1.0.1.tgz 

### Desde el directorio kafka
bin\windows\zookeeper-server-start.bat config\zookeeper.properties
bin\windows\kafka-server-start.bat config\server.properties

### Desde el directorio de proyecto para desplegar sobre kafka
mvn spring-boot:run
mvn test

### Puertos donde se despliega
ParticipationSystem -> localhost:8080
Dashboard -> localhost:8090
