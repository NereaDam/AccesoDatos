#!/bin/bash

docker run -it --rm -e MYSQL_PWD=quevedo2dam mysql mysqldump -u root -h dam2.mysql.iesquevedo.es -P 3335 luciasanmiguel_hospital 1> hospital.sql