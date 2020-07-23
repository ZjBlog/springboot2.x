#!/bin/bash

APP_NAME=yfk-service.jar

#检查程序是否在运行
is_exist() {
  pid=$(ps -ef | grep $APP_NAME | grep -v grep | awk '{print $2}')
  #如果不存在返回1，存在返回0
  if [ -z "${pid}" ]; then
    return 1
  else
    return 0
  fi
}

is_exist
if [ $? -eq "0" ]; then
  kill -9 $pid
else
  echo "${APP_NAME} is not running"
fi

echo "OK!"
echo "PID: $PIDS"
