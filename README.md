#ReadMe
##Semesteroppgave DATA1600 05.05.2020

Dette er ett Maven Java 13 prosjekt utviklet i Intellij. 

Ved første kjøring i Intellij må man opprette en run-konfigurasjon av typen «Application» med main class «org.oslomet.App».

Admin Login: 
Brukernavn: Admin
Passord: pass

Programmet brukes til å lage PC-konfigurasjoner. 
Superbruker har ved innlogging anledning til å redigere og opprette egne komponenter. 

Programmet har tre vinduer: View, Edit og Admin. 

View gir brukeren oversikt over pc-konfigurasjoner. Ved oppstart har vi lagt til 3 demo konfigurasjoner. 
Her kan man lagre eller laste inn CVS-filer med konfigurasjoner. Trykk «help» i programmet for mer informasjon. 

Edit gir brukeren mulighet til å konfigurere en PC basert på komponenter i programmet.
Velg ulike komponenter i listen for å lage en konfigurasjon. 
Trykk «help» i programmet for mer informasjon. 

Admin gir superbrukerne mulighet til å legge til eller redigere eksisterende komponenter.
Hvert enkelt attributt tilhørende komponentene har egen inputvalidering ved oppretting. 
Evt. avvik vil bli informert om ved oppretting eller redigering. 
Her kan man også laste inn eller lagre alle komponenter i programmet i form av en jobj-fil. Vi har lagt til eksempel komponenter i en fil som lastes når programmet kjøres. 
Trykk «help» i programmet for mer informasjon. 

