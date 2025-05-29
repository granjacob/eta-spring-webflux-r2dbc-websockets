-- Table: public.persona

-- DROP TABLE IF EXISTS public.persona;

CREATE TABLE IF NOT EXISTS public.persona
(
    name character varying(255) COLLATE pg_catalog."default",
    lastname character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    CONSTRAINT persona_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.persona
    OWNER to postgres;