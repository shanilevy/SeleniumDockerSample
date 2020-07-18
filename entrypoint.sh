#!/bin/sh
mvn -f pom.xml clean test -DsuiteXmlFile=$1
/bin/bash