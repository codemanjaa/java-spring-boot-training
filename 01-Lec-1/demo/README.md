#Dockerize the application

Run the dockerfile 

docker build --tag=demo:latest .

docker run -p8080:7070 demo:latest