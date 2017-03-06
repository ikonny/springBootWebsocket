
kill  -9 `ps -ef |grep xiaot  | grep -v grep  | awk '{print $2}'`

#export JAVA_HOME=/usr/java/jdk1.8.0_121
#export PATH=$JAVA_HOME/bin:$PATH
#export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

#cd xiaot
java -d64 -server -Xms2G -Xmx2G -XX:+UseG1GC -jar xiaot-boot-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > xiaot.log 2>&1 &
tail -f xiaot.log