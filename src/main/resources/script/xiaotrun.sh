#!/bin/sh
source /etc/profile
JRE_HOME=/usr/java/jdk1.8.0_121
JAR_HOME=/root/xiaot/xiaot-boot-0.0.1-SNAPSHOT.jar

P_ID=`jps|grep xiaot|grep -v grep|awk '{print $1}'`
if [ "$P_ID" == "" ]; then
echo "=== XiaoT process not exists or stop success ==="
else
echo "=== begin kill XiaoT process, pid is:$P_ID ==="
kill  -9 $P_ID
fi

$JRE_HOME/bin/java -d64 -server -Xms2G -Xmx2G -XX:+UseG1GC -jar $JAR_HOME  > /root/xiaot/xiaot.log 2>&1 &
#tail -f xiaot.log
exit 0