#!/usr/bin/env bash
curl -v  http://localhost:8082/customers/1 
curl -v -d '{"firstName":"Anne", "lastName":"Queen"}' -H 'Content-Type: application/json' http://localhost:8082/customers
curl -v http://localhost:8082/customers/1
