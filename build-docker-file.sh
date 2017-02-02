#!/bin/bash
gradle bootRepackage

docker build -t tianyawy/consumer-pact consumer
