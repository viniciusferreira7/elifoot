CREATE TABLE users (
    id  CHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE scopes (
    id  CHAR(36) PRIMARY KEY DEFAULT,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users_scopes (
    user_id  CHAR(36) NOT NULL,
    scope_id  CHAR(36) NOT NULL,
    PRIMARY KEY (user_id, scope_id),
    CONSTRAINT fk_user_scopes_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_user_scopes_scope FOREIGN KEY (scope_id) REFERENCES scopes(id)
);