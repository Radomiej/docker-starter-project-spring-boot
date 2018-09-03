# docker-starter-project-spring-boot

# How-to-start (dev-stage)

## Prepare Docker(Windows)

1. Install Docker for Windows

2. Go to settings and turn on : "Expose deamon on tcp://localhost:2375 without TLS"

## Prepare Docker(Linux)

1. Install Docker for Ubuntu(or other system)(I tested it on Ubuntu Trusty 14.04 (LTS) and VMWare): [https://docs.docker.com/install/linux/docker-ce/ubuntu/]

2. Modifying running script

## Prepare InteliJ 

1. Install plugin for Docker.

2. Import this project.

3. Connect with Docker via tcp deamon.

# Comments

## Elasticsearch
- Elastic search must be running and initializing before our Spring App have been started. 

- Currently are problem on working with es based on netty transport layer(9300). //TODO Switch to pure REST client

### manual docker command
docker run -p 0.0.0.0:9200:9200 -p 0.0.0.0:9300:9300 elasticsearch:latest 

docker run -p 0.0.0.0:9200:9200 -p 0.0.0.0:9300:9200 --name elasticsearch -e http.host=0.0.0.0 -e transport.host=0.0.0.0 -e xpack.security.enabled=false elasticsearch:latest -Des.node.name="MainNode"

## Redis
### manual docker command
docker run -p 0.0.0.0:6379:6379 redis:latest 
