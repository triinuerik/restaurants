{\rtf1\ansi\ansicpg1252\cocoartf1504\cocoasubrtf820
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 CREATE TABLE rating\
(\
    id BIGINT PRIMARY KEY NOT NULL,\
    name VARCHAR(48),\
    comment TEXT,\
    rating SMALLINT,\
    restoran_id BIGINT,\
    CONSTRAINT rating_restoran_id_fkey FOREIGN KEY (restoran_id) REFERENCES restoran (id)\
);\
CREATE TABLE restoran\
(\
    id BIGINT PRIMARY KEY NOT NULL,\
    address VARCHAR(255),\
    name VARCHAR(255),\
    version INTEGER\
);}