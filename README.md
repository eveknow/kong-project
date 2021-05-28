# pycorp-rank

Guide:
1. docker-compose -f kong.yml up -d --build
2. docker-compose -f mysql.yml up -d --build
3. docker-compose -f rabbit.yml up -d --build
4. docker-compose -f redis.yml up -d --build
5. docker-compose -f app.yml up -d --build
6. Init DB: Run init.sql for mysql
7. Run services: user-api, middle-api, tracking-service, product-api
8. Curl: curl -H "x-consumer-username:thanhtk" http:/localhost:8021/products/13635700


Architecture Design:

![alt text](https://github.com/eveknow/pycorp-rank/blob/5891d13f495f786d4ed7428e34bdeea0ba28f348/AD.png?raw=true)

