create schema if not exists `BEDU_JSE2`;

create user 'admin'@'localhost' identified by 'ADMIN_PWD';
create user 'usuario'@'localhost' identified by 'PASSWD';

grant all on BEDU_JSE2.* to 'admin';
grant SELECT on BEDU_JSE2.* to 'usuario';

flush privileges;