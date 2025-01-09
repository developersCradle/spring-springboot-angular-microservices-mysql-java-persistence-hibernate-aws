# Section 04: Docker Crash Course.

Docker crash course.

# What I Learned.

# 6. Installing Docker.

- [Source](https://www.docker.com/) Normal install ✅.

# 7. Install Verification.

<img src="dockerArchitecture.PNG"  alt="alt text" width="500"/>

1. Server application will be running.
2. Client will be interacting with the server.

- We can verify docker working with `docker --version`.
    - Also, we can check `docker --version`.

# 8. Docker Terminologies.

<img src="dockerTerminologies.PNG"  alt="alt text" width="500"/>

1. **Image** is output of **Build**.
2. **Tag** is the version.
3. **Containers** are running instances of image with certain tag/version.

# 9. Docker System Prune.

- These commands are for **cleaning temp files**.

<img src="dockerIgnorePrune.PNG"  alt="alt text" width="500"/>

1. `-f` for **forcefully remove** and `-a` including **images**.
2. `-f` for **forcefully remove**.

# 10. Hello World.

<img src="dockerCommand.PNG"  alt="alt text" width="500"/>

1. `docker run` makes instance of the image.

- `docker run hello-world`
    - If image **not** found, this will be pulled from **Docker Hub**.
        - So `pull` command is included inside `run`.
<img src="dockerImages.PNG"  alt="alt text" width="500"/>

1. First time, it will look for local installation, then it will be pulling it from registry.

<img src="dockerImagesSecondTime.PNG"  alt="alt text" width="500"/>

1. Second time, when the image is found in local, this is being used!

# 11. Docker Pull.

- `run` command will do the `pulling` indirectly.

- We have the following command `docker pull hello-world`. Does the pulling.

<img src="dockerRunWithDifferentVersions.PNG"  alt="alt text" width="500"/>

1. `Docker run` will check local **v1**, if someone have been updated the registery with **v2**, **v1** will be prioritized.

> Should we use `pull` or `run` ?

<img src="dockerPullWithDifferentVersions.PNG"  alt="alt text" width="500"/>

- Once in the while, `pull` should be used. It can update local images.

# 12. Creating Ubuntu Container.

- Listing all **containers** `docker ps -a`.

- Executing commands **inside** Ubuntu **container**.
    - `docker run ubuntu ls`.

- Each of docker images are different, so they execute differently!

# 13. Interactive Mode.

<img src="dockerRun.PNG"  alt="alt text" width="500"/>

- Interacting with Ubuntu **Container**. `docker run -it ubuntu`.

- We can launch **Linux** commands in this state.

- Every time you run new container. Everything will be gone.

# 14. Docker Start Command.

- Starting container with **name** `docker run -it -name=c1 ubuntu`.

<img src="dockerRunWithName.PNG"  alt="alt text" width="500"/>

- We can launch existing container with `docker start`.
    - This is not very frequent command!

# 15. Docker Stop / Kill Command.

- We had `start` command, so we will have `stop` command.

- We can stop using `docker stop c1`.
    - This will wait and kill process slowly.

- Also, we can kill **imminently** using `docker kill c2`.
    - This will be instantaneous.

# 16. Docker Exec Command.

<img src="dockerExec.PNG"  alt="alt text" width="500"/>

1. This is the same with the `run`, but with `exec` it does not create **new container**.

- We can use this to execute **commands** in **pre-existing containers**.

<img src="dockerExecOnPreExistingContainers.PNG"  alt="alt text" width="500"/>

1. You can see that, you can **execute** commands on **pre-existent** **containers** without using the terminal which was used to start the **container**.

- Also, with the interactive mode `exec -it`, jumps to the terminal when starting.

# 17. Image Name Format.

- This is format, when starting `docker run`.

<img src="dockerImageFormat.PNG"  alt="alt text" width="500"/>

1. Some of the these parameters are **optional**. In this case if this is private image, this can be useful.

- You can have option to store images in **AWS ECR**.

- Hello world image [hello world](https://hub.docker.com/_/hello-world).

- **Tag** can specify, different purpose images.

- Latest is not mean latest date stamp, but maintainers choice to use **tag** **latest**.

# 18. Creating Nginx Container.

- Docker image of this image `docker pull nginx:perl`.
    - **Perl** tag.

- You can use commands inside container with `docker exec -it admiring_yonath bash`.

# 19. Port Mapping.

<img src="dockerNginxContainer.PNG"  alt="alt text" width="500"/>

1. This container is running inside virtual machine.
2. To make port listening same port as in inside your **chrome** with **VM** is done with **port mapping**.

<img src="DockerPortMapping.PNG"  alt="alt text" width="500"/>

1. Localhost port is mapped to the **VM** with **Nginx port**.

<img src="dockerPortMappingDocument.PNG"  alt="alt text" width="500"/>

1. For single instance.
2. For multiple instances.

- Container are **lightweight**, we can launch many at same time.

# 20. Checking Mapped Ports.

- What are the port, what docker is exposing.
    - Done, with `docker ps`.

# 21. Detached Mode.

- Running with **detached mode**. `docker run -d nginx`.

# 22. Accessing Container Log.

- We can get logs out of container. `docker logs e74`, with start hash from container.

# 23. Volume Mapping - Theory.

<img src="DockerVolumeMapping.PNG"  alt="alt text" width="500"/>

1. **Container** and own computer has its **own file structure**. Also, containers are **stateless**.
2. **Volume mapping** can be pointing folder from folder.

<img src="dockerVolumeMappingCommands.PNG"  alt="alt text" width="500"/>

- When sharing in **Mac** or **Windows**, there is security settings to be checked. They must follow specific folder pattern.

<img src="whenSharingMacAndWindows.PNG"  alt="alt text" width="500"/>

# 24. Volume Mapping - Demo Part 1.

- **Volume Mapping** with Ubuntu inside **Windows** is `docker run -it -v C:\Docker\Volume\Data:/data ubuntu`
    - We use following volume mapping inside Windows.

- Now, when we create folder/or do some other modifications inside container, will reflect to the mapped Windows folder.

- We can make this **stateful** with following. 

# 26. Volume Mapping - Nginx.

- [DockerHub nginx](https://hub.docker.com/_/nginx).

- Official hosting documentation.

<img src="nginxHosting.PNG"  alt="alt text" width="600"/>

- We create `Index.html` in local file system.
    - Then we just map this one, `docker run -p 80:80 -v PathInLocal:PathInNginxContainer nginx`

# 27. Volume Mapping - Single File.

- We can map only some files, not whole folders.
    - We just point to the file. 
    -`docker run -p 80:80 -v PathInLocalToTheFile:PathInNginxContainerToTheSingleFile nginx` 

# 28. Volume Mapping - Read Only Mode.

- Same, but with read only.
    - So, if host files are deleted. Won't deleted container files.