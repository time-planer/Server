@echo OFF
mvn package -Dpackaging=war
mvn package -Dpackaging=jar
mvn package
pause