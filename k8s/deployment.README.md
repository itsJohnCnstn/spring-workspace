# deployment.yaml Guide

This document explains every field currently present in `deployment.yaml`.

## Purpose

`deployment.yaml` defines a Kubernetes Deployment named `my-app` that runs 5 Pods of a containerized Spring application on port `8080`.

## Field-by-Field Explanation

| Path | Current value | What it does |
| --- | --- | --- |
| `apiVersion` | `apps/v1` | Uses the stable Kubernetes API group/version for Deployments. |
| `kind` | `Deployment` | Declares this manifest as a Deployment resource. |
| `metadata.name` | `my-app` | The Deployment object name in the cluster namespace. |
| `spec.replicas` | `5` | Desired number of Pod replicas managed by this Deployment. |
| `spec.selector.matchLabels.app` | `my-app` | Label selector that tells the Deployment which Pods belong to it. |
| `spec.template.metadata.labels.app` | `my-app` | Label applied to Pods created by this Deployment. Must match the selector. |
| `spec.template.spec.containers[0].name` | `my-app` | Logical container name inside each Pod. |
| `spec.template.spec.containers[0].image` | `my-app:latest` | Container image reference to run. |
| `spec.template.spec.containers[0].imagePullPolicy` | `Never` | Tells kubelet to never pull from a registry and only use a local image on the node. |
| `spec.template.spec.containers[0].ports[0].containerPort` | `8080` | Declares the container's listening port for Kubernetes metadata and service mapping. |

## Practical Notes

- `replicas: 5` increases availability and concurrency, but also uses 5x Pod resources.
- Selector and template labels must stay aligned (`app: my-app`) or rollout/management breaks.
- `image: my-app:latest` is easy for local experiments but weaker for repeatable deployments than immutable tags.
- `imagePullPolicy: Never` usually works only in local clusters (for example Docker Desktop, kind, minikube) where you load/build images directly on nodes.

## Apply and Verify

```bash
kubectl apply -f deployment.yaml
kubectl get deployment my-app
kubectl get pods -l app=my-app
```

## Troubleshooting

- `ErrImageNeverPull`: Image is not present on node while `imagePullPolicy` is `Never`.
- No Pods managed by Deployment: `spec.selector.matchLabels` and `spec.template.metadata.labels` are mismatched.
- App unreachable on expected port: application may not actually bind to `8080` inside the container.
