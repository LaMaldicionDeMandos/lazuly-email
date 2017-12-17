#!/usr/bin/env bash

export PORT=8081
export HOST=http://localhost
export INTERNAL_SECRET=internalsecret
export MAILJET_API=mailjetapi
export MAILJET_SECRET=mailjetsecret
export PROFILE=staging

mvn spring-boot:run -Dspring.profiles.active=$PROFILE