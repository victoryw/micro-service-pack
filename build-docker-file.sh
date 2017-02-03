#!/bin/bash
gradle bootRepackage

docker build -t tianyawy/consumer-pact consumer

docker build -t tianyawy/consumer-pact-db consumer/db
