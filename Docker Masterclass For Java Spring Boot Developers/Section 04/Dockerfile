FROM ubuntu

WORKDIR /vins/welcome

# Adding txt file form project folder to inside docker file.
ADD welcomeMessage.txt welcomeMessage.txt

# Output of txt file.
ENTRYPOINT cat welcomeMessage.txt