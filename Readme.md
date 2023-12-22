## Krótki opis systemu

W ramach projektu należy utworzyć system umożliwiaj ący zbieranie 
danych z minimum jednego, a najlepiej dwóch/trzech dowolnych serwisów 
pogodowych i udostępnić uśrednione (rezultatem powinna być dana wartość 
pogodowa obliczona jako średnia arytmetyczna z rezultatów zwróconych przez
każdy serwis) wartości obliczone na podstawie zwróconych odpowiedzi.

## Główne funkcje systemu

* Pobieranie danych pogodowych z odpowiednich serwisów sieciowych 
(lub plików znajdujących się na Twoim dysku)
* Pobrane dane powinny być zapisywane do bazy danych
* Aplikacja powinna przyjmować datę i lokalizację miasta w celu 
pobierania uśrednionych wartości
* Wyniki uśredniania powinny być zapisywane w bazie danych

## Stos techologiczny
* JDK 17
* GSON 2.10.1
* Hibernate 6.4.1.Final
* H2 2.2.224
* JUnit5 5.10.1

