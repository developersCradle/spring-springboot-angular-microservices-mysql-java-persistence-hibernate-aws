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

<img src="podStatus.PNG"  alt="alt text" width="700"/>

1. In Happy case, **1/1** is running.
2. Failed case, **0/1**.

- This is what you mostly see.

<img src="mostOfPodStatuses.PNG"  alt="alt text" width="700"/>

1. This is when the **workload** has been run successfully. 
2. **Kubelet** is retrying the connection. There were error in running container.

# 21. Pod Labels - Part 1.

- Normally there can be multiple **pods**.
    - We could use the label to identify with queries.

```
apiVersion: v1
kind: Pod
metadata:
  name: pod-1
  labels: # These can be anything.
    dept : dept-1
    team: team-1
spec:
  containers:
    - name: nginx
      image: nginx
---
apiVersion: v1
kind: Pod
metadata:
  name: pod-2
  labels: # These can be anything.
    dept : dept-3
    team: team-3
spec:
  containers:
    - name: nginx
      image: nginx
---
apiVersion: v1
kind: Pod
metadata:
  name: pod-3
  labels: # These can be anything.
    dept : dept-3
    team: team-3
spec:
  containers:
    - name: nginx
      image: nginx

```

# 22. Pod Labels - Part 2.

- We create deploy these **pods**. `kubectl create -f 03-multiple-pods.yaml`.

- When we use `kubectl describe pod`.
    - This print all pods.

- We can **describe** one pod using command with label. `kubectl get pod pod-1`.

- This will print the labels, which have been registered `kubectl get pod --show-labels`.

- We use where **dept=dept-1**. Like this `kubectl get pod -l dept=dept-1`.
    - We can also use exclusion `kubectl get pod -l dept!=dept-1`.

# 23. Formatting Output.

- Getting information about **pod** in `yaml` format.
    - `kubectl get pod pod-1 -o yaml`.

# 24. Deleting A Pod.

- Deleting one particular pod. `kubectl delete pod pod-2`.

# 25. Port Forward.

- We have been running `ngnix` container, not connected to the homepage.

<img src="portFoward.PNG"  alt="alt text" width="700"/>

1. These containers are connected to with node network.
  - Every container has their own IP-address.
2. **Nodes** are having running **pods** internally.
  - These **pods** are having their own connection internally.

- So networks are build **top of each other**.
  - We can **simplify** this one with the **port forwarding** concept.
    - This is super simple.

<img src="portFowardTec.PNG"  alt="alt text" width="700"/>

1. This creates simple pipe between you machine and your node.

- We make **port forwarding** with following **.yaml** file. 

```
   apiVersion: v1
kind: Pod
metadata:
  name: my-pod
spec:
  containers:
    - name: nginx
      image: nginx
      ports:
      - name: "web-port"
        containerPort: 80
        # protocol: TCP / UDP Default is the TCP.
```

- If there running **pods** `kubectl get pod`, we need to delete this. `kubectl delete pod my-pod`.

- We can set up connection with **kubectl** **port forwarding** with following command: `kubectl port-forward my-pod 8080:80`.

- Now, when we go to `http://localhost:8080/`, this will go to nginx homepage.
  - This is **port forwarding** for debugging not proper way to server traffic!

# 26. Restart Policy

- We will use **ubuntu** for the image.

```
apiVersion: v1
kind: Pod
metadata:
  name: my-pod
spec:
  containers:
    - name: ubuntu
      image: ubuntu
```

- **Kubelet** will try to restart automatically.

- Pod is having automatically `restartPolicy: Always`.

<img src="restartingPolicy.PNG"  alt="alt text" width="600"/>

1. You can see that **Kubelet** is having restarts many times with the restart policy.

- There are many properties for `restartPolicy`:
  - `Never`.
  - `OnFailure`.

# 27. Docker - ENTRYPOINT vs CMD.

<img src="DockeImage.PNG"  alt="alt text" width="600"/>

<img src="entryPoint.PNG"  alt="alt text" width="600"/>

<img src="kubernetesTerminologies.PNG"  alt="alt text" width="600"/>

1. **Docker** and **Kubernetes** terms are different.

# 28. Pod Args - Exec Form.

- If there are **commands** inside docker file for the **pod**. Like here, we can execute them inside **pod**.

```
apiVersion: v1
kind: Pod
metadata:
  name: my-pod
spec:
  restartPolicy: Never
  containers:
    - name: ubuntu
      image: ubuntu
      args:
        - "date"
```

# 29. Pod Container Logs.

- Following command will print the **logs** from inside **pod** `kubectl logs my-pod`.

- Same as **docker**, but with the pod name.

# 30. Pod Args - Shell Form.

- First we ran, docker in interactive mode. `docker run -it ubuntu`.
  - Then we can echo `$PATH` inside shell.  
    - `echo this is my path $PATH`.
- We want to execute following **shell** command `/bin/sh -c 'echo this is my path $PATH'`.

- So this command inside our `yaml` file.

```
apiVersion: v1
kind: Pod
metadata:
  name: my-pod
spec:
  restartPolicy: Never
  containers:
    - name: ubuntu
      image: ubuntu
      args:
        - "/bin/sh"
        - "-c"
        - "echo This is my path : $PATH"
```

- Now, we can just run this and check the logs:

```
C:\Users\******\Desktop\git projektit\spring-springboot-angular-microservices-mysql-java-persistence-hibernate-aws\Kubernetes Masterclass For Beginners\Section 03\sec02-pod>kubectl logs my-pod
This is my path : /usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
```