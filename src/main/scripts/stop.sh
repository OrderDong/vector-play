#!/bin/sh

server_name="vector-play"
pid=`ps -ef | grep "serverName=$server_name" | grep -v "grep" | awk '{print $2}'`

if [ "$pid" = "" ];then
	echo "$server_name is not running"
else
	kill -9 $pid
	echo "kill pid:$pid"
	echo "$server_name stop success"
fi