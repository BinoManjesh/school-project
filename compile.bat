del *.java~
del journal\*.java~
del *.bat~
cls
javac -cp "+libs\*" -d classes *.java journal\*.java
java -cp "classes" BatGenerator
pause