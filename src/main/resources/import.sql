
INSERT INTO  endereco (cep, cidade, estado, logradouro, numero, complemento, bairro, referencia)VALUES('88045300', 'Sua Cidade', 'Seu Estado', 'Rua Exemplo', 123, 'Complemento','Bairro Exemplo', 'Referência'), ('88045300', 'Sua Cidade', 'Seu Estado', 'Rua Exemplo', 123, 'Complemento','Bairro Exemplo', 'Referência'), ('88045300', 'Sua Cidade', 'Seu Estado', 'Rua Exemplo', 123, 'Complemento','Bairro Exemplo', 'Referência');

INSERT INTO  endereco (cep, cidade, estado, logradouro, numero, complemento, bairro, referencia)VALUES('88045397', 'Sua Cidade', 'Seu Estado', 'Rua Exemplo', 123, 'Complemento','Bairro Exemplo', 'Referência');

INSERT INTO usuario (nome_completo,genero,cpf,telefone,email,status,senha,tipo_usuario) VALUES ('João da Silva',0,'12345678900','11999999999','joao1.silva@email.com',TRUE,'123456',1);
INSERT INTO usuario (nome_completo,genero,cpf,telefone,email,status,senha,tipo_usuario) VALUES ('João da Silva',0,'12345678905','11999999999','joao2.silva@email.com',TRUE,'123456',2);

INSERT INTO paciente (nome_completo,genero,cpf,telefone,email,status,data_nascimento,rg,estado_civil,naturalidade,contato_emergencia,alergias,cuidados_especificos,convenio,numero_convenio,validade_convenio,endereco_id) VALUES ('Nome Sobrenome',0,'12345678900','12345678901','email@example.com',true,'2000-01-01','123456789',1,'Naturalidade','11223344556','Alergias específicas','Cuidados específicos','Convênio Médico','12345','2023/12',1), ('Ana Maria',0,'12345678902','12345678901','email@example.com',false,'2000-01-01','123456789',1,'Naturalidade','11223344556','Alergias específicas','Cuidados específicos','Convênio Médico','12345','2023/01',2), ('Julia Fernandes', 0, '12345678903', '00000000000','julia.f@email.com', true, '1993-04-23', '000000000', 1, 'Brasil', '00000000000', '', '', '', '00000', '2023/11', 3);

INSERT INTO medicamento (nome, tipo, observacao, data, horario, quantidade, unidade, status) VALUES ('Trimedal', 0, 'aaaaaaaaaa', '2000-10-01', '10:30:10', 3, 0, true);

INSERT INTO consulta (motivo, data, horario, descricao, dosagens_precaucoes, indicador_medicacao, status, paciente_id, usuario_id, medicamento_id) VALUES ('fortes dores de cabeça', '2023-10-18', '20:30:00', 'O paciente estava com fortes dores de cabeça a mais de uma smeana', 'tomar de 3 em 3 horas em caso de dor extrema', 'aaaaaaaaaaaaaaaaaaaaaa', true, 1, 1, 1);

INSERT INTO dieta (nome, data, horario, tipo_dieta, descricao, status, paciente_id)VALUES ('Dieta ruim', '2023-10-09', '12:09:10', 3, 'Uma dieta rica em vegetais e frutas.', true, 1);