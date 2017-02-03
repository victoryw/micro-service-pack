#!/usr/bin/env bash
curl -d '{"firstName":"Anne", "lastName":"Queen"}' -H 'Content-Type: application/json' http://localhost:8082/customers
curl http://localhost:8082/customers/1
