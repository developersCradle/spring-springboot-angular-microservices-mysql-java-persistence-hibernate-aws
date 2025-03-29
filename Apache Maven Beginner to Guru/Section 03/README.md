# Section 3: Compiling Java.

Compiling Java.

# What I Learned.

# 14. Introduction.

- Check ✅.

# 15. Review of Java Compile and Packaging.

<img src="javaCompile.PNG"  alt="alt text" width="500"/>

1. These files are getting into **javac**.
2. Maven can handle multiple compilation tasks.
3. `.class` files are given into the JVM runtime.

<img src="packingJava.PNG"  alt="alt text" width="500"/>

1. Java project will have many files.
2. Unzip will happen and **JVM** will run these.

<img src="javaPackaging.PNG"  alt="alt text" width="500"/>

1. There are many ways to back Java application.
2. The most popular one is `.jar` zip file and the simplest one.
3. **FAT JAR** contains **all the dependencies**, Used by **Spring Boot**.

<img src="javaDeployment.PNG"  alt="alt text" width="500"/>

1. Nowadays, industry is moving more into **Deployable Stand-Alone** format.
2. Old school deployables.

# 16. Hello World Java Command Line.

- Basic hello world.

```
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

- **Maven** will be doing compiling to `.class` file and packing to the zip file.

# 17. Creating Java jar files from Command Line.

- Continue when moody.