'use strict';

var dbm;
var type;
var seed;

/**
  * We receive the dbmigrate dependency from dbmigrate initially.
  * This enables us to not have to rely on NODE_PATH.
  */
exports.setup = function(options, seedLink) {
  dbm = options.dbmigrate;
  type = dbm.dataType;
  seed = seedLink;
};

exports.up = function(db) {
  return db.runSql(`CREATE TABLE IF NOT EXISTS public."Users"
(
    id uuid NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    hash character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "isActivated" boolean DEFAULT false,
    "activationId" uuid,
    "createdAt" timestamp with time zone NOT NULL,
    "updatedAt" timestamp with time zone NOT NULL,
    CONSTRAINT "Users_pkey" PRIMARY KEY (id),
    CONSTRAINT "Users_activationId_key" UNIQUE ("activationId"),
    CONSTRAINT "Users_email_key" UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Users"
    OWNER to postgres;`);
};

exports.down = function(db) {
  return db.runSql(`DROP TABLE IF EXISTS public."Users";`);
};

exports._meta = {
  "version": 1
};
