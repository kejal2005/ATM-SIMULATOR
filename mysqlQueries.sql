CREATE DATABASE ATM;
USE ATM;

CREATE TABLE signup (
    formno      VARCHAR(20) PRIMARY KEY,
    name        VARCHAR(100),
    fname       VARCHAR(100),
    dob         VARCHAR(20),
    gender      VARCHAR(20),
    email       VARCHAR(100),
    marital     VARCHAR(20),
    address     VARCHAR(200),
    city        VARCHAR(50),
    state       VARCHAR(50),
    pincode     VARCHAR(10)
);

CREATE TABLE signuptwo (
    formno         VARCHAR(20) PRIMARY KEY,
    religion       VARCHAR(30),
    category       VARCHAR(30),
    income         VARCHAR(30),
    qualification  VARCHAR(30),
    occupation     VARCHAR(30),
    pan            VARCHAR(20),
    aadhar         VARCHAR(20),
    senior         VARCHAR(10),
    existing       VARCHAR(10),
    FOREIGN KEY (formno) REFERENCES signup(formno)
);

CREATE TABLE signupthree (
    formno        VARCHAR(20) PRIMARY KEY,
    accountType   VARCHAR(40),
    cardNumber    VARCHAR(20),
    pinNumber     VARCHAR(10),
    facilities    VARCHAR(200),
    FOREIGN KEY (formno) REFERENCES signup(formno)
);

CREATE TABLE login (
    formno      VARCHAR(20) PRIMARY KEY,
    cardNumber  VARCHAR(20),
    pinNumber   VARCHAR(10),
    FOREIGN KEY (formno) REFERENCES signup(formno)
);

CREATE TABLE bank (
    pin    VARCHAR(10),
    date   VARCHAR(100),
    type   VARCHAR(30),
    amount VARCHAR(50)
);