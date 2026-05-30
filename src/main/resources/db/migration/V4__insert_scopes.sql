insert into scopes(id, name) values('00000000-0000-0000-0000-000000000001', 'admin:all');
insert into scopes(id, name) values('00000000-0000-0000-0000-000000000002', 'stadium:write');
insert into scopes(id, name) values('00000000-0000-0000-0000-000000000003', 'stadium:read');
insert into scopes(id, name) values('00000000-0000-0000-0000-000000000004', 'club:write');
insert into scopes(id, name) values('00000000-0000-0000-0000-000000000005', 'club:read');
insert into scopes(id, name) values('00000000-0000-0000-0000-000000000006', 'player:write');
insert into scopes(id, name) values('00000000-0000-0000-0000-000000000007', 'player:read');

insert into users(id, name, email, password, active) values('00000000-0000-0000-0000-000000000101', 'admin', 'admin@admin.com', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true);
insert into users(id, name, email, password, active) values('00000000-0000-0000-0000-000000000102', 'user', 'john.doe@example.com', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true);

insert into users_scopes(user_id, scope_id) values('00000000-0000-0000-0000-000000000101', '00000000-0000-0000-0000-000000000001');
insert into users_scopes(user_id, scope_id) values('00000000-0000-0000-0000-000000000102', '00000000-0000-0000-0000-000000000003');
insert into users_scopes(user_id, scope_id) values('00000000-0000-0000-0000-000000000102', '00000000-0000-0000-0000-000000000005');
insert into users_scopes(user_id, scope_id) values('00000000-0000-0000-0000-000000000102', '00000000-0000-0000-0000-000000000007');