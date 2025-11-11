-- sample data
INSERT INTO tblAccountTypes (typeName, description) VALUES ('ADMIN', 'Manager/Administrator');
INSERT INTO tblAccountTypes (typeName, description) VALUES ('SALES', 'Sales staff');
INSERT INTO tblAccountTypes (typeName, description) VALUES ('CUSTOMER', 'Customer');

INSERT INTO tblAccounts (username, password, accountTypeID) VALUES ('admin', 'change_me', 1);

INSERT INTO tblMovies (title, description, durationMinutes, director, cast, releaseDate, trailerLink, posterLink)
VALUES ('The Example Movie', 'A sample movie used for testing', 120, 'Jane Doe', 'Actor A, Actor B', '2024-01-01', '', '');

INSERT INTO tblMovieGenres (genreName) VALUES ('Action');
INSERT INTO tblMovieGenres_tblMovies (movieID, genreID) VALUES (1,1);

INSERT INTO tblCinemaRooms (roomName, capacity, status) VALUES ('Room A', 100, 'OPEN');
