#!/bin/bash
set -e

# Create a database to run the extension creation script in; adjust as needed
DB_NAME="my_postgis_pgrouting"

# Perform all actions as the 'postgres' user
export PGUSER=postgres

# Enable the PostGIS extension
psql -d "$DB_NAME" -c "CREATE EXTENSION IF NOT EXISTS postgis;"
psql -d "$DB_NAME" -c "CREATE EXTENSION IF NOT EXISTS pgrouting;"
