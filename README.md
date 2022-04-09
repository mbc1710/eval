# evaluation
Proyecto de code challenge

End point:
curl -X GET "http://localhost:8087/api/prices/{dateApplication}/{productId}/{brandId}" -H "accept: application/json"

parametros de entrada de ejemplo:
brandId=1
dateApplication=2020-06-14 00:00:00
productId=35455

para ejecutar las pruebas unitarias cambiar a JUnit 4 en:
Run Configurations --> Junit --> seleccionar la clase (TestToAllLayer, TestTo...Layer, ...Test) --> la opcion de "Test runner"
