CREATE TABLE TBL_USERS (
    uid INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 5, INCREMENT BY 1),
    firstname VARCHAR(20),
    lastname VARCHAR(20),
    access_level NUMERIC,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(60) NOT NULL,
    contact_number VARCHAR(15),
    PRIMARY KEY (uid));

CREATE TABLE TBL_ITEMS (
    id VARCHAR(40) NOT NULL, 
    owner_id INTEGER NOT NULL,
    item_name VARCHAR(40) NOT NULL,
    category VARCHAR(30) NOT NULL,
    description VARCHAR(200),
    picture VARCHAR(400),
    streetAddress VARCHAR(100),
    city VARCHAR(30),
    state VARCHAR(20),
    country VARCHAR(30),
    postalCode VARCHAR(10),
    reservePrice FLOAT,
    biddingStartPrice FLOAT,
    biddingIncrements FLOAT,
    bidPrice FLOAT,
    notes VARCHAR(200),
    endTime DATETIME,
    CONSTRAINT pk_items PRIMARY KEY (id),
    CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES TBL_USERS(uid));
	
   	
   
    
CREATE TABLE TBL_BID (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 5, INCREMENT BY 1),
    item_id VARCHAR(40) NOT NULL,
    bidder_id INTEGER NOT NULL,
    price FLOAT,
    bid_date DATETIME,
    CONSTRAINT pk_bid PRIMARY KEY (id),
    CONSTRAINT fk_item_id FOREIGN KEY (item_id) REFERENCES TBL_ITEMS(id),
    FOREIGN KEY (bidder_id) REFERENCES TBL_USERS(uid));

    
    
    