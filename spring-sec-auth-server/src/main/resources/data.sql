insert into demo.users (user_name, password, authority) values ('user','pw','read');
insert into demo.users (user_name, password, authority) values ('admin','pw','write');

insert into demo.clients(client_id ,client_secret, auth_method, grant_type, redirect_uri, scope)
values (
    'client1', 'secret1', 'client_secret_basic',
    'authorization_code', 'http://127.0.0.1:8080/login/oauth2/code/oidc-client1',
    'openid'
);

insert into demo.clients(client_id ,client_secret, auth_method, grant_type, redirect_uri, scope)
values (
    'client2', 'secret2', 'client_secret_basic',
    'authorization_code', 'http://127.0.0.1:8080/login/oauth2/code/oidc-client2',
    'openid'
);