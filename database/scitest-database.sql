CREATE DATABASE scitest;

\c scitest;

CREATE TABLE Polls (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    end_time TIMESTAMP NOT NULL,
    quantity INT NOT NULL,
    users_id BIGINT,
    FOREIGN KEY (users_id) REFERENCES Users (id)
);

-- Criação da tabela Users
CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    voto VARCHAR(255) NOT NULL,
    polls_id BIGINT,
    FOREIGN KEY (polls_id) REFERENCES Polls (id)
);

INSERT INTO "Polls"("id", "name", "end_time, quantity")
VALUES (1, 'teste', "1985‑09‑25 17:45:30.005", 1);