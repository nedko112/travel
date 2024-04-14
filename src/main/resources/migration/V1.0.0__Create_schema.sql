CREATE TABLE IF NOT EXISTS destination
(
    id BIGSERIAL PRIMARY KEY,
    departure VARCHAR(150) DEFAULT NULL,
    destination VARCHAR(150) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS price
(
    id BIGSERIAL PRIMARY KEY,
    price DOUBLE PRECISION DEFAULT NULL,
    destination_id BIGINT DEFAULT NULL,
    CONSTRAINT fk_destination FOREIGN KEY (destination_id) REFERENCES destination(id)
);

CREATE TABLE IF NOT EXISTS ticket
(
    id BIGSERIAL PRIMARY KEY,
    discount DOUBLE PRECISION DEFAULT NULL,
    created_on TIME(6) DEFAULT NULL,
    departure_from TIME(6) DEFAULT NULL,
    arrive_at TIME(6) DEFAULT NULL,
    destination_id BIGINT DEFAULT NULL,
    FOREIGN KEY (destination_id) REFERENCES destination(id)
);

CREATE TABLE IF NOT EXISTS consumer
(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    amount DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS consumer_tickets
(
    consumer_id BIGINT,
    tickets_id BIGINT,
    FOREIGN KEY (consumer_id) REFERENCES consumer(id),
    FOREIGN KEY (tickets_id) REFERENCES ticket(id)
);
