FROM openjdk:11-jdk

ENV IDEMPIERE_VERSION 7.1
ENV IDEMPIERE_HOME /idempiere

WORKDIR $IDEMPIERE_HOME

RUN apt-get update && \
    apt-get install -y --no-install-recommends postgresql-client-9.6 && \
    rm -rf /var/lib/apt/lists/*
ADD org.idempiere.p2/target/products/org.adempiere.server.product/linux/gtk/x86_64 $IDEMPIERE_HOME
RUN ln -s $IDEMPIERE_HOME/idempiere-server.sh /usr/bin/idempiere

COPY docker-entrypoint.sh $IDEMPIERE_HOME
COPY idempiere-server.sh $IDEMPIERE_HOME

ENTRYPOINT ["./docker-entrypoint.sh"]
CMD ["idempiere"]
