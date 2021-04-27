DROP TABLE IF EXISTS PLAYER;
CREATE TABLE PLAYER (
                      PALYER_ID INT AUTO_INCREMENT  PRIMARY KEY,
                      NAME VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS GAME;
CREATE TABLE GAME (
                        GAME_ID INT AUTO_INCREMENT  PRIMARY KEY,
                        PALYER1_ID INT,
                        PALYER2_ID INT

);
CREATE TABLE STEPS (
                      GAME_ID INT PRIMARY KEY,
                      PALYER1_ID INT,
                      PALYER2_ID INT,
                      STEP VARCHAR(4) NOT NULL
);
