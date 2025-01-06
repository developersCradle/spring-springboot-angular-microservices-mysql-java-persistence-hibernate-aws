# Section 4: Docker Crash Course.

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
