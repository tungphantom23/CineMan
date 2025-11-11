-- Schema for CineMan system (MySQL)
-- Run by Spring Boot at startup when spring.sql.init.mode=always

CREATE TABLE IF NOT EXISTS tblAccountTypes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  typeName VARCHAR(50),
  description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tblAccounts (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  accountTypeID INT,
  FOREIGN KEY (accountTypeID) REFERENCES tblAccountTypes(id)
);

CREATE TABLE IF NOT EXISTS tblEmployees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  fullName VARCHAR(100),
  dateOfBirth DATE,
  address VARCHAR(255),
  phoneNumber VARCHAR(15),
  email VARCHAR(100),
  accountID INT,
  FOREIGN KEY (accountID) REFERENCES tblAccounts(id)
);

CREATE TABLE IF NOT EXISTS tblCustomers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  fullName VARCHAR(100),
  dateOfBirth DATE,
  address VARCHAR(255),
  phoneNumber VARCHAR(15),
  email VARCHAR(100),
  loyaltyPoints INT DEFAULT 0,
  membershipCardID VARCHAR(20),
  accountID INT,
  FOREIGN KEY (accountID) REFERENCES tblAccounts(id)
);

CREATE TABLE IF NOT EXISTS tblMovies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  description TEXT,
  durationMinutes INT,
  director VARCHAR(100),
  cast VARCHAR(255),
  releaseDate DATE,
  trailerLink VARCHAR(255),
  posterLink VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tblMovieGenres (
  id INT AUTO_INCREMENT PRIMARY KEY,
  genreName VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS tblMovieGenres_tblMovies (
  movieID INT,
  genreID INT,
  PRIMARY KEY (movieID, genreID),
  FOREIGN KEY (movieID) REFERENCES tblMovies(id),
  FOREIGN KEY (genreID) REFERENCES tblMovieGenres(id)
);

CREATE TABLE IF NOT EXISTS tblCinemaRooms (
  id INT AUTO_INCREMENT PRIMARY KEY,
  roomName VARCHAR(50),
  capacity INT,
  status VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS tblShowtimes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  showDate DATE,
  startTime TIME,
  endTime TIME,
  baseTicketPrice DECIMAL(18,0),
  movieID INT,
  roomID INT,
  FOREIGN KEY (movieID) REFERENCES tblMovies(id),
  FOREIGN KEY (roomID) REFERENCES tblCinemaRooms(id)
);

CREATE TABLE IF NOT EXISTS tblSeats (
  id INT AUTO_INCREMENT PRIMARY KEY,
  rowNumber VARCHAR(5),
  seatNumber INT,
  seatType VARCHAR(50),
  roomID INT,
  FOREIGN KEY (roomID) REFERENCES tblCinemaRooms(id)
);

CREATE TABLE IF NOT EXISTS tblTickets (
  id INT AUTO_INCREMENT PRIMARY KEY,
  purchaseTime DATETIME,
  actualPrice DECIMAL(18,0),
  status VARCHAR(50),
  showtimeID INT,
  seatID INT,
  customerID INT,
  salespersonID INT,
  FOREIGN KEY (showtimeID) REFERENCES tblShowtimes(id),
  FOREIGN KEY (seatID) REFERENCES tblSeats(id),
  FOREIGN KEY (customerID) REFERENCES tblCustomers(id),
  FOREIGN KEY (salespersonID) REFERENCES tblEmployees(id)
);

CREATE TABLE IF NOT EXISTS tblInvoices (
  id INT AUTO_INCREMENT PRIMARY KEY,
  creationTime DATETIME,
  totalAmount DECIMAL(18,0),
  status VARCHAR(50),
  customerID INT,
  salespersonID INT,
  FOREIGN KEY (customerID) REFERENCES tblCustomers(id),
  FOREIGN KEY (salespersonID) REFERENCES tblEmployees(id)
);

CREATE TABLE IF NOT EXISTS tblInvoiceDetails (
  id INT AUTO_INCREMENT PRIMARY KEY,
  quantity INT,
  unitPrice DECIMAL(18,0),
  invoiceID INT,
  ticketID INT,
  FOREIGN KEY (invoiceID) REFERENCES tblInvoices(id),
  FOREIGN KEY (ticketID) REFERENCES tblTickets(id)
);
