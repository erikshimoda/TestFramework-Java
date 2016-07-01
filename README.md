cucumberjvm-selenium-pageObject
=====================

Page Object Framework using cucumber jvm (java) and Selenium java.
Read about it on [seleniumframework.com] (http://www.seleniumframework.com/cucumber-jvm-2/what-is-cucumber-jvm/)
# TestFramework-Java

Antes de executar este projeto, é necessário configurar os webdrivers.

Download do PhantomJS
http://phantomjs.org/download.html

Download do ChromeDriver
http://chromedriver.storage.googleapis.com/index.html?path=2.9/

Download do Firefoxdriver
http://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-firefox-driver/2.53.0

Download InternetExplorerDriver
http://selenium-release.storage.googleapis.com/index.html?path=2.53/

Para executar através de linha de comando, utilize:
mvn test

Para escolher qual browser executar, utilize:

mvn -Dbrowser=firefox test

mvn -Dbrowser=ie test

** caso não seja escolhido nenhum browser, será executado o chrome.


VERSÃO BETA - AINDA EM CONSTRUÇÃO
