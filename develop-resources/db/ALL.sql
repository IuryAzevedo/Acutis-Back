-- Tabela: banco
CREATE TABLE banco (
                       id BIGSERIAL PRIMARY KEY,
                       nome VARCHAR(100) NOT NULL,
                       data_fundacao TIMESTAMP
);

-- Tabela: usuario
CREATE TABLE usuario (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL,
                         usuario VARCHAR(50) UNIQUE NOT NULL,
                         senha VARCHAR(100) NOT NULL,
                         endereco VARCHAR(255) NOT NULL
);

-- Tabela: agencia
CREATE TABLE agencia (
                         id BIGSERIAL PRIMARY KEY,
                         banco_id INT NOT NULL,
                         nome VARCHAR(100) NOT NULL,
                         FOREIGN KEY (banco_id) REFERENCES banco(id)
                         
);

-- Tabela: conta
CREATE TABLE conta (
                       id BIGSERIAL PRIMARY KEY,
                       agencia_id INT NOT NULL,
                       usuario_id INT NOT NULL,
                       tipo_conta VARCHAR(255) NOT NULL,
                       saldo DECIMAL(15,2) NOT NULL DEFAULT 0.00,
                       cartao_credito BOOLEAN,
                       saldo_cartao_credito DECIMAL(15,2),
                       possui_lis BOOLEAN,
                       saldo_lis DECIMAL(15,2),
                       FOREIGN KEY (agencia_id) REFERENCES agencia(id),
                       FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE transacao (
                       id BIGSERIAL PRIMARY KEY,
                       conta_origem_id BIGINT NOT NULL,
                       conta_destino_id BIGINT NOT NULL,
                       valor DECIMAL(15,2) NOT NULL,
                       data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (conta_origem_id) REFERENCES conta(id),
                       FOREIGN KEY (conta_destino_id) REFERENCES conta(id)
);


CREATE TABLE historico (
                       id BIGSERIAL PRIMARY KEY,
                       usuario_id BIGINT NOT NULL,           -- quem fez
                       entidade VARCHAR(100) NOT NULL,       -- tipo de entidade: "Banco", "Agencia", etc.
                       tipo_acao VARCHAR(50) NOT NULL,       -- "CREATE", "UPDATE", "DELETE"
                       descricao TEXT NOT NULL,              -- descrição textual da ação
                       data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);




