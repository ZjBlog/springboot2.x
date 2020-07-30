#!/bin/sh
#功能简介：启动上层目录下的jar文件
#参数简介：
#    $1:jar文件名（包含后缀名）
#    注意：jar文件必须位于startup.sh目录的上一层目录。
# $0 脚本名称
# dirname 返回脚本文件的目录路径
#启动参数
JAVA_OPTS="-server -Xms400m -Xmx400m -Xmn300m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xverify:none -XX:+DisableExplicitGC -Djava.awt.headless=true"

jar_name=yfk-service.jar
this_dir="$( cd "$( dirname "$0"  )" && pwd )"
parent_dir=`dirname "${this_dir}"`
log_dir="/export/log/yfk-service"
log_file="${log_dir}/console.log"
jar_file="/export/App/yfk-service.wangyin.com/lib/${jar_name}"
# 如果是目录创建
# -d filename 如果 filename为目录，则为真
if [ ! -d "log_dir" ];then
  mkdir $log_dir
  touch $log_file
  echo "创建日志文件成功"
else
  echo "日志文件已经存在"
fi
#-f filename 如果 filename为常规文件，则为真
#父目录下jar文件存在
if [ -f "${jar_file}" ]; then
    #启动jar包；重定向标准错误输出到文件，丢掉标准输出
#    nohup java $JAVA_OPTS -jar ${jar_file} 1>/dev/null 2>"${log_file}" &
    if [ x"$1" = x ]; then
       echo "user JAVA_HOME!"
       nohup ${JAVA_HOME}/bin/java $SGM_OPTS -jar ${jar_file} > ${log_file} 2>&1 &
       echo "${jar_file} start success"
       exit 0
    fi

    nohup java -jar ${jar_file} > ${log_file} 2>&1 &
    echo "${jar_file} start success"
    exit 0
else
    echo -e "\033[31m${jar_file}文件不存在！\033[0m"
    exit 1
fi