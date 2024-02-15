DROP TABLE IF EXISTS demo.users;
DROP TABLE IF EXISTS demo.clients;

create table demo.users (
    id serial,
    user_name text,
    password text,
    authority text
);


create table demo.clients (
    id serial,
    client_id text,
    client_secret text,
    auth_method text,
    grant_type text,
    redirect_uri text,
    scope text
);