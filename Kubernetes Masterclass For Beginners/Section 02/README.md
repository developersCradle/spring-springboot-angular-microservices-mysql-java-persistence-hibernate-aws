# Section 02: Kubernetes Cluster. 

Kubernetes Cluster.

# What I Learned.

# 4. Introduction.

- Kubernetes is big and complex.

# 5. Kubernetes Architecture - Master.

<img src="kubernetesCluster.PNG"  alt="alt text" width="500"/>

1. Kubernetes is cluster of machines.
    - We will run our application inside our cluster.
    
<img src="kubernetesCluster2.PNG"  alt="alt text" width="500"/>

1. Usually you will have **one or more** **master/control-plane**. 
2. Many nodes.

<img src="kubernetesClusterComponents.PNG"  alt="alt text" width="500"/>

1. **Master** has 4 **Components**.
    - Every of these will have different role.

<img src="kubernetesClusterDiagram.PNG"  alt="alt text" width="500"/>

1. Master node with the **4 components**.
    1. **api-server**.
    2. **etcd**.
    3. **controller-manager**.
    4. **scheduler**.

- We will always talk to the **api-server** as entry point.

- When sending request to **api-server**.
    1. **Validate** the request.
    2. **Etcd** will be saved the request.
        - This contains **cluster** information.
    3. **Scheduler** will be asked for the help.
        - **Scheduler** will be picking up nodes for the request.
    4. **controller-manager** will be managing the load.
        - Example, if there is some error with running nodes.

# 6. Kubernetes Architecture - Nodes.

<img src="nodeArchitecture.PNG" alt="alt text" width="500"/>

1. Components of the **nodes**. You can think of operations that mimics **JRE world** of Java.

<img src="kubernetesClusterDiagramNodePerspective.PNG"  alt="alt text" width="500"/>

- Example of **request** where **app A** will be talking **app B**. 

1. **Scheduler** has decided to run **app A** and **app B** inside these two **nodes**. 
    - **Api-server** will firstly send information to this two **kublet** that it will be running application inside these. Small gray box represents **kublet** that are running inside these nodes.
2. **Kublets** are running inside **nodes**. This agent is running each **node** waiting for instruction from master/api-server.
    - **Kublet** will immediately create **containers-runtime** with health check.

<img src="kubeProxy.PNG" alt="alt text" width="500"/>

1. Two instances of app **B**.
2. One instance of app **A**.

- When **A** wants to talk to **B**, it needs to go thought **kube-proxy**.

3. This **kube-proxy** will balance between these **two**.
    - Its kinda acts like **load balancer**.

# 7. Tools Install.

<img src="tools.PNG" alt="alt text" width="500"/>

- We are not using Docker Kubernetes add-on.
    - We are using **kinds**.

- Installing tool like **Kinds** in **windows**. [Tool](https://kind.sigs.k8s.io/docs/user/quick-start/).

<img src="tools2.PNG" alt="alt text" width="500"/>

1. We are using the **kind** for setting up Kubernetes.
    - Kind is for **local cluster**.

<img src="k8Cluster.PNG" alt="alt text" width="500"/>

1. **Kind** is for creating cluster.
    - Uses docker containers for packing.
2. These are **docker containers**.
    - **Master** is docker container.
    - **Worker nodes** are docker containers.

- So this will be like **docker inside docker**. 

<img src="cluster.PNG" alt="alt text" width="500"/>

1. These **clusters** will be hosted by big companies.

- We communicate **trough** **kubectl**.

- We are going to create **cluster** with this config with this `.yaml` file.
    - One **master**.
    - Two **workers**.
```
# three node (two workers) cluster config
kind: Cluster
apiVersion: kind.x-k8s.io/v1alpha4
name: dev-cluster
nodes:
- role: control-plane
- role: worker
- role: worker
```

# 9. Kind Cluster - Part 2.