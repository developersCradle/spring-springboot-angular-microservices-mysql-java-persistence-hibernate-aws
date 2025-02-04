# Section 02: Kubernetes Cluster. 

Kubernetes Cluster.

# What I Learned.

# 4. Introduction.

- Kubernetes is big and complex.

# 5. Kubernetes Architecture - Master.

<img src="kubernetesCluster.PNG"  alt="alt text" width="500"/>

1. Kubernetes is cluster of machines.
    - We will run our application inside our cluster.
    
<img src="kubernetesCluster.PNG"  alt="alt text" width="500"/>

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

- We will always talk to the **api-server**.

- When sending request to **api-server**.
    1. **Validate** the request.
    2. **Etcd** will be saved the request.
        - Contains **cluster** information.
    3. **Scheduler** will be asked for the help.
        - **Scheduler** will be picking up nodes for the request.
    4. **controller-manager** will be managing the load.
        - Example, if there is some error with running nodes.

# 6. Kubernetes Architecture - Nodes.

<img src="nodeArchitecture.PNG" alt="alt text" width="500"/>

1. Components of the **nodes** represents, running of the **node**. Like will be **JRE** in the Java world.

<img src="kubernetesClusterDiagramNodePerspective.PNG"  alt="alt text" width="500"/>

- Example of **request**, will be **app A** will be talking **app B**. 

1. **Scheduler** has decided to run these two apps in the **app A** and **app B** inside these two **nodes**. 
    - **api-server*** will be just inform that three two **kublet** will be running these two apps.
2. **kublet** running inside **nodes**.