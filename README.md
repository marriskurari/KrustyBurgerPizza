# KrustyBurgerPizza


## Fyrir kennara

  Einfaldasta leidin til ad keyra thetta er med thvi ad:

  Setja upp MySQL, detail eru fyrir nedan, thad er til script til ad setja upp MySQL.

  Keyra server JAR file-inn ---> ./server/initial/build/libs/gs-rest-service-0.1.0.jar (sorry med version name, ekki buinn ad uppfaera i langan tima)

  Keyra "mvn package" i folderinu --> ./HotelApi/   thetta keyrir testin lika, mjog hentugt

  Keyra API.main, vid erum lika med JAR file fyrir thad herna --> ./HotelApi/target/api-1.jar

  Badir jar file-arnir eru med dependencies inn i theim svo thad tharf ekki ad vesenast med classpath og svoleidis.

  Fyrir framendann tha tharf madur ad hafa sett up node og npm, sidan.

  0. Ná í git folder.
  1. npm install
  2. npm run build
  3. npm run dev

## Front-end: JS - React + scss er sett upp með webpack.

  Ég suggesta að fara eftir þessu til að setja upp front-end.
  https://reactjs.org/docs/thinking-in-react.html

  Síðan held ég að það gæti verið sniðugt að reyna að koma út úr okkur "snapshot" af bakendanum svo við getum skipt þægilega upp verkum.

## Back-end: Java application með smá server.

  Hljómar flókið en er það ekki, það að tengja niðurstöðurnar við serverinn er mjög easy, við erum að tala um bókstaflega eitthvad sem er einfalt.

  Til ad sja syntax-inn tha getur madur farid inn i ./HotelApi/src/main/java/search/API.java til ad skoda.
  Ef madur vill importa tha getur madur skodad ./HotelApi/src/test/java/Test1.java


## MySQL setup
Keyra setup.sql. Lika height ad pipe-a thetta.

## Hvernig maður setur upp allt?
#### Front-end:
  0. Ná í git folder.
  1. npm install
  2. npm run build
  3. npm run dev

#### Back-end:
  0. Ná í git folder (sama folder samt).
  1. Installa gradle (nota google ef maður er ekki viss hvernig, ekki erfitt skref), tho thad aetti ad vera nog ad vera med wrapper.
  2. cd --> ./server/initial
  4. ./gradlew bootRun
	5. Madur tarf lika ad vera med mysql-server a tolvunni til ad geta installad thessu.

**Listi af errorum**

	0. 	...... SQLException access denied.
			Laga med tvi ad logga sig inn og bua til account sem heitir spongebob og er "IDENTIFIED BY 'krusty' (i.e. passw er krusty). Sidan gefa honum priveleges.

	1. java.util.concurrent.ExecutionException: org.apache.catalina.LifecycleException:
			Laga med tvi ad keyra 'gradle wrapper --gradle-version 2.13'

	2. Ef 'gradle is not a command' tha installa gradle.

	3. Execution failed for task ':compileJava'.
			//Ef thu ert med jdk-9 tha svekk. https://askubuntu.com/questions/84483/how-to-completely-uninstall-java  sidan installa jdk-8 virkadi hja mer, pottthett haegt ad gera thetta einfaldar med multiple jdk einhvernveginn
			Komst ad thvi ad keyra 'gradle wrapper --gradle-version <meira en 3.3>' tha skiptir ekki ekki mali hvada jdk madur er med

	4. No database named 'krustybase' -> logga inn i mysql -> CREATE DATABASE 'krustybase'.

Eg lenti amk i thessum 4 thegar eg var ad installa i thessari viku.

  Sidenote:
  Hvering hefur þetta áhrif á development?
  Eins lengi og leitarvélin er separate module sem maður getur importað.

  Kóðin sem gradle generate-ar er weird líka, en til þess að develop-a þá getur maður fundið hann í ./server/initial/src/main/java/hello , þar sem entrypoint er "Application.java"
