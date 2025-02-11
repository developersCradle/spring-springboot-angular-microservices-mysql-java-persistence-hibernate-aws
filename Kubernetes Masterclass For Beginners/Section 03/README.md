# Section 03: Pod. 
Pod.
# What I Learned.

# 13. Introduction.

<img src="pod.PNG"  alt="alt text" width="500"/>

- In Java basic building block would be **Java** class.

<img src="summaryDocker.PNG"  alt="alt text" width="500"/>

<img src="pod2.PNG"  alt="alt text" width="500"/>

1. Smallest of unit of k8.
2. Pod can **run one or more containers**.
3. Pod can have **IP-address**, which in return run **multiple containers** inside, which return have their own addresses.
4. Communicating inside **Pod** the docker containers, does not need IP-address, only the ports is needed.

# 14. Simple Pod Creation

<img src="yaml.PNG"  alt="alt text" width="500"/>

1. `kind` what **kind/type** of Kubernetes resource you will be creating.
2. `spec` will have parameters for creating of the **type/resource**.

- How to use pod. [Pods](https://kubernetes.io/docs/concepts/workloads/pods/#using-pods).

- Example of pod.
    - In here `containers:` is array of containers, check the URL. [Example of array](https://kubernetes.io/docs/reference/kubernetes-api/workload-resources/pod-v1/#Container)

```
apiVersion: v1
kind: Pod
metadata:
  name: 
spec:
  containers:
  - name: nignx
    image: nginx
```

# 15. Creation & Deletion.


# Our pod configuration.

```
apiVersion: v1
kind: Pod
metadata:
  name: my-pod
spec:
  containers:
    - name: nginx
      image: nginx

```

- **Kind** has some deprecated way for creating cluster.
    - Or use **kind** if it works, use `kind create cluster --config 01-cluster.yaml`.

> [!CAUTION]
> Use kubectl. If kind does not work.

- Get **any** resource from kubectl with `kubectl get pod`.

- We don't need to use `watch` command, since my **OS** won't support.

- Applying pod for cluster`kubectl apply -f my-pod.yaml`.

- Delete resource `kubectl delete -f 01-simple-pod.yaml`.

# 16. Describing Pod.

- To get information about the **resource**, we can use the command `resource` example of such. `kubectl describe pod`
    - If we don't have **pod** created, we can create such with following command `kubectl create -f 01-simple-pod.yaml`.

<img src="eventsFromDescribeCommand.PNG"  alt="alt text" width="600"/>

1. This part is one super important when debugging.

<img src="kubectl describe.PNG"  alt="alt text" width="600"/>

1. **First** (the **scheduler**) we assign `worker node` to run the **pod**. 
2. **Second** (the **kubelet**) Kubelet got the work, "the pod". What it needs to get it to work?
    - **Pull** the nginx image.
    - **Create** container.
    - **Start** the container.

- So this field tells what is going on.

# 17. [Quick-Note] - apply Command.

<img src="podUpdate.PNG"  alt="alt text" width="600"/>

1. We can change the version of pod, or update its fields using `apply` command.

- Usually **we don't** usually deal with such commands ourselves.
    - We won't be creating **pods** ourselves.
        - We have other programs for managing different version.

# 18. Image Pull Backoff.

<img src="errorToInspectWithDescribe.PNG"  alt="alt text" width="700"/>

1. We can see from **describe** that there was error pulling error!
2. You can see the first step have been made, and how long it took `scheduler` to execute! 

# 19. Crash Loop Backoff.


<img src="kubectl describe second.PNG"  alt="alt text" width="700"/>

1. You can tell that, pulling off this image is having problem.

2. You can watch the **Age** of the logs.

# 20. Pod Status.