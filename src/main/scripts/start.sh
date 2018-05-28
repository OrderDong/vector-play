#!/bin/sh
source /etc/profile
base_dir=$(cd "$(dirname "$0")"; pwd)
jar_file=`ls ${base_dir} -t| grep "^vector-play.*\.war$"`
server_name="vector-play"
jvm_args="-Xmx1024M -Xms1024M -XX:PermSize=256M -XX:MaxPermSize=512M -Duser.timezone=GMT+08"
launcher_daemon_out=/tmp/$server_name.log


if [ ! -f "$jar_file" ]; then
	echo "can not found war file , failed to start server! "
	exit 1
       
fi

# If a specific java binary isn't specified search for the standard 'java' binary
if [ -z "$JAVACMD" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
      JAVACMD="$JAVA_HOME/bin/java"
  else
    JAVACMD=`which java`
  fi
fi

if [ ! -x "$JAVACMD" ] ; then
  echo "Error: JAVA_HOME is not defined correctly."
  echo "  We cannot execute $JAVACMD"
  exit 1
fi

pid=`ps -ef | grep "serverName=$server_name" | grep -v "grep" | awk '{print $2}'`

if [ "$pid" = "" ];then
	nohup "$JAVACMD" -DserverName=$server_name -Djava.security.egd=file:/dev/./urandom $jvm_args -jar $jar_file --spring.config.location=./application.yml >/dev/null 2>&1  &

else
	echo "$server_name is running"
fi

