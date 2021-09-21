alter table tb_doctor_medical_specialty
drop
foreign key FKnnv6a3j4dhq4hc7k5lmcu1tkd;


alter table tb_doctor_medical_specialty
drop
foreign key FKfl5rmwkt9rwc9raa6ccmbg4xc;


drop table if exists medical_specialty;

drop table if exists tb_doctor;

drop table if exists tb_doctor_medical_specialty;

create table medical_specialty (
                                   id integer not null auto_increment,
                                   name varchar(255),
                                   primary key (id)
) engine=InnoDB;

create table tb_doctor (
                           id integer not null auto_increment,
                           bairro varchar(255),
                           cell_phone bigint not null,
                           cep integer,
                           crm integer,
                           deleted bit not null,
                           landline bigint not null,
                           localidade varchar(255),
                           logradouro varchar(255),
                           name varchar(255),
                           uf varchar(255),
                           primary key (id)
) engine=InnoDB;

create table tb_doctor_medical_specialty (
                                             doctor_id integer not null,
                                             medical_specialty_id integer not null,
                                             primary key (doctor_id, medical_specialty_id)
) engine=InnoDB;

alter table tb_doctor_medical_specialty
    add constraint FKnnv6a3j4dhq4hc7k5lmcu1tkd
        foreign key (medical_specialty_id)
            references medical_specialty (id);

alter table tb_doctor_medical_specialty
    add constraint FKfl5rmwkt9rwc9raa6ccmbg4xc
        foreign key (doctor_id)
            references tb_doctor (id);