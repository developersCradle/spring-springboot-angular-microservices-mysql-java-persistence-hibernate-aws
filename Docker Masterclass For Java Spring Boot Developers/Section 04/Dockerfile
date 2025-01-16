FROM ubuntu

WORKDIR java

# Downloading JDK
ADD https://download.java.net/java/GA/jdk23.0.1/c28985cbf10d4e648e4004050f8781aa/11/GPL/openjdk-23.0.1_linux-x64_bin.tar.gz java23.tar.gz

# Unizpping
RUN tar -xvzf java23.tar.gz
RUN rm java23.tar.gz

# In linux we will bind to env varible.
# export PATH=$PATH:/jdk-23.0.1/bin

ENV PATH $PATH:/java/jdk-23.0.1/bin
