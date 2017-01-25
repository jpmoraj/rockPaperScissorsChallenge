DROP TABLE PLAYERS IF EXISTS;
 
CREATE TABLE PLAYERS (
    PLAYER_ID    integer identity primary key,
    PLAYER_NAME varchar(50) not null,
    POINTS varchar(255)
);