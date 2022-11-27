FROM python:3.8-buster

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update \
    && apt-get -y install --no-install-recommends apt-utils dialog 2>&1 \
    && apt-get -y install git procps lsb-release 	libxml2-utils \
    && apt-get autoremove -y \
    && apt-get clean -y 

RUN /usr/local/bin/python -m pip install --upgrade pip
RUN pip install antlr4-tools
RUN pip install antlr4-python3-runtime==4.9.2

COPY . /comp0010

RUN chmod u+x /comp0010/sh
RUN chmod u+x /comp0010/tools/test
RUN chmod u+x /comp0010/tools/coverage
RUN chmod u+x /comp0010/tools/analysis

RUN cd /comp0010 && python -m pip install -r requirements.txt

ENV DEBIAN_FRONTEND=

EXPOSE 8000

