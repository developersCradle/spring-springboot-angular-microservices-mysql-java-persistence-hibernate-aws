# Section 2: Need For Docker

What need for Docker.

# What I Learned

# 2. Story Behind Docker.


<img src="problemBefore.PNG"  alt="alt text" width="500"/>

1. Every team had their own software.

<img src="isolationBeforeVirtialization.PNG"  alt="alt text" width="500"/>

1. They used to buy own Hardware for everything.

<img src="virtualization.PNG"  alt="alt text" width="500"/>

1. These individuals are **virtual machines**.
2. New strategy used to buy one big computer.

- Nice isolation!
    - Not perfect. Not efficient.

3. These resources allocations are not perfect. They being used without prioritization.

<img src="kerner.PNG"  alt="alt text" width="500"/>

- **Kernel** is loaded into memory. This cannot be accessed thought normal means. This can be accessed **API layer**. 

<img src="layerForAccessingKernel.PNG"  alt="alt text" width="500"/>

- We have **OS** for accessing **kernel** layer.

<img src="linuxDistros.PNG"  alt="alt text" width="500"/>

- We have different distros for different Linux. They have still the same **Kernel**, but different covering. 

<img src="vmAndDocker.PNG"  alt="alt text" width="500"/>

1. **VM** has own **kernel** and db installed into these **vm's**. These are super heavy. 

2. Docker has only one layer.

# 3. Why Developer needs to learn Docker.

<img src="problemWithVm.PNG"  alt="alt text" width="500"/>

1. Problem in production detected!
2. It works on developers machine!

- This what **Docker** solves for us.
    - You can define dependencies in file.

<img src="dockerPackage.PNG"  alt="alt text" width="500"/>

1. You define dependencies, by yourself.

- In old days we packed application with **.war** or **.jar**.
    - Nowadays, its **Docker** file.

<img src="dockerRunApp.PNG"  alt="alt text" width="500"/>

- Docker can run these just fine.

<img src="whatIsDocker.PNG"  alt="alt text" width="500"/>

# 4. How Docker works on Mac/Windows.

<img src="dockerWorksInWindowsOrMac.PNG"  alt="alt text" width="500"/>

1. Docker will share **Linux** lightweight layer in these other operating systems. For Linux distros it is included all ready.