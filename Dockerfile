FROM postgres:latest

# Install PostGIS
RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        postgresql-13-postgis-3 \
        postgresql-13-postgis-3-scripts \
        postgis \
    && rm -rf /var/lib/apt/lists/*

# Install pgRouting
RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        postgresql-13-pgrouting \
    && rm -rf /var/lib/apt/lists/*