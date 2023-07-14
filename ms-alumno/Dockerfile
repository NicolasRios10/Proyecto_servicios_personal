#Especifica la imagen base a partir de la cual se construira la nueva imagen
FROM adoptopenjdk:11-jdk-hotspot


#Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app



#Colpia los archicos JAR desde el directorio al contenedor
COPY target/ms-alumno-0.0.1.jar .

#ESpecifica los puertos en los que la aplicacion en los que el contenedor en el que esta escuchanado
EXPOSE 9003

#Define el comando que se ejecuta cuando inicia el contenedor basado en la imagen
CMD ["java", "-jar", "ms-alumno-0.0.1.jar"]