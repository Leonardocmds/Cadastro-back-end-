INSERT INTO usuario(nome, email, senha) VALUES('Atendente', 'atendente@email.com', '$2a$10$VbZyXxg6Hq8dFMfXL2ZOH.BXsu05qJueIfdQRbF3MhWaRn9OJp0NS');
INSERT INTO usuario(nome, email, senha) VALUES('Gerente', 'gerente@email.com', '$2a$10$VbZyXxg6Hq8dFMfXL2ZOH.BXsu05qJueIfdQRbF3MhWaRn9OJp0NS');

INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_ATENDENTE');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_GERENTE');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1, 1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2, 2);