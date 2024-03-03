FROM postgres:14

RUN apt-get update && apt-get install -y \
    postgresql-14-postgis-3 \
    postgresql-14-postgis-3-scripts \
    postgresql-14-pgrouting \
    && rm -rf /var/lib/apt/lists/*

# Allow statements to be run as soon as the container starts
COPY ./init-db.sh /docker-entrypoint-initdb.d/

# Install pgRouting
RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        postgresql-13-pgrouting \
    && rm -rf /var/lib/apt/lists/*