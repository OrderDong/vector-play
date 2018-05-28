set JVM_ARGS=-Xmx1024M -Xms1024M -XX:PermSize=256M -XX:MaxPermSize=512M
java %JVM_ARGS% -jar ./vector-play-1.0.0.war --spring.config.location=./application.yml