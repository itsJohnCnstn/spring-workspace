# How to test it

## Build a docker image for a sample app
```shell
docker build -t hello-app ./hello-app
```

## Boot the minikube
```shell
minikube start
```

### Verify it's working
```shell
kubectl get nodes
```

### Load image to minikube
```shell
minikube image load hello-app:latest
```

## Apply the deployment
```shell
kubectl apply -f deployment.yaml
```

## Observe raised pods
```shell
kubectl get pod
```

## Create a default ClusterIP service.
```shell
kubectl expose deployment k8s-deployment --port=8080 --target-port=8080
```

## Enable ingress addon for minikube
```shell
minikube addons enable ingress
```

## Apply ingress
```shell
kubectl apply -f ingress.yaml
```

## Add hello.local hostname to /etc/hosts
```shell
sudo sh -c 'echo "127.0.0.1 hello.local" >> /etc/hosts'
```

## Open the tunnel
```shell
sudo minikube tunnel
```

## Call the API!
```shell
http http://hello.local
```

[//]: # (TODO: add ingress)