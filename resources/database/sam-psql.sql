create table if not exists finger_print_data(
id serial primary key,
ansi_data bytea,
iso_data bytea,
bmp_data bytea,
raw_data bytea,
wsq_data bytea
);
